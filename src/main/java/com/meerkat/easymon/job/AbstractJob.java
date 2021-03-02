package com.meerkat.easymon.job;

import com.meerkat.easymon.common.Constant;
import com.meerkat.easymon.config.Config;
import com.meerkat.easymon.data.gen.model.TConfiguration;
import com.meerkat.easymon.data.gen.model.TMonitLog;
import com.meerkat.easymon.data.gen.model.TReceiver;
import com.meerkat.easymon.data.gen.model.TRuleReceiver;
import com.meerkat.easymon.dto.ScheduleJob;
import com.meerkat.easymon.email.EmailService;
import com.meerkat.easymon.service.*;
import com.meerkat.easymon.sms.SmsService;
import org.apache.commons.lang.StringUtils;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/**
 * author : yjs
 * createTime : 2018/6/5
 * description : 抽象定时任务类
 * version : 1.0
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public abstract class AbstractJob implements Job {

	private static final Logger log = LoggerFactory.getLogger(AbstractJob.class);

	/** 监控信息日志服务 */
	@Autowired
	MonitLogService  monitLogService;

	/** 告警信息接收人服务类 */
	@Autowired
	private ReceiverService receiverService;

	/** 监控规则接收人映射服务类 */
	@Autowired
	private RuleReceiverService ruleReceiverService;

	/** 短信消息服务类 */
	@Autowired
	private SmsService smsService;

	/** 邮件消息服务类 */
	@Autowired
	private EmailService emailService;

	/** 微信消息服务类 */
	@Autowired
	private WeChatService weChatService;

	/** 配置参数服务类 */
	@Autowired
	private ConfigurationService configurationService;

	/**
	 * 系统配置
	 */
	@Autowired
	private Config config;

	/**
	 * @param context
	 * @throws JobExecutionException
	 */
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		beforeExecute(context);

		ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get(ScheduleJob.JOB_PARAM_KEY);
		String message = "执行失败";
		try {
			synchronized (this) {
				execute(scheduleJob);
			}
			message = scheduleJob.getExecuteResult();
			log.info("job({})是否告警:{}",scheduleJob.getJobId(),scheduleJob.getWarning());
		}catch(Throwable e) {
			log.error("调度任务出错", e);
			message = e.getMessage();
			throw new JobExecutionException(e); //TODO
		}finally {
		 	afterExecute(scheduleJob, message);
		}
	}

	/**
	 * 子类实现该业务方法
	 */
	public abstract void execute(ScheduleJob scheduleJob) throws JobExecutionException;


	//执行前
	private void beforeExecute(JobExecutionContext context) {
	}

	//执行后
	private void afterExecute(ScheduleJob scheduleJob, String message) {

		//记录该条规则监控日志
 		try {
			TMonitLog jobLog = new TMonitLog();
			Date date = new Date();
			jobLog.setCreatedTime(date);
			jobLog.setRuleId(scheduleJob.getJobId());
			if(message!=null && message.length()>1000){
				message = message.substring(0,1000);
			}
			jobLog.setResult(message);
			if(scheduleJob.getWarning()) {
				jobLog.setIsWarning(Constant.MONITLOG_ISWARNING);
			}else{
				jobLog.setIsWarning(Constant.MONITLOG_ISNOTWARNING);
			}

			//由于企业微信发布在消息群中，故一条预警，只需发一条消息，不需要针对每个接收人发送一遍
            sendWeChatMessage(scheduleJob, jobLog);

			monitLogService.insert(jobLog);

		}catch(Exception e) {
			log.error("规则监控日志记录出错:", e);
		}

		//发送告警消息
		sendNotifyMessage(scheduleJob, message);
	}

	private void sendWeChatMessage(ScheduleJob scheduleJob, TMonitLog jobLog) {
		if (scheduleJob.getWarning()) {

			log.debug("job({})发送微信告警消息:{}", scheduleJob.getJobId(), scheduleJob.getWarningMessage());
			//获取监控规则与消息接收人映射
			List<TRuleReceiver> list = ruleReceiverService.getRuleReceiverByRuleId(scheduleJob.getJobId());
			List<TReceiver> receiverList = new ArrayList<>();
			List<String> weChatAddressList = new ArrayList<>();
			for (TRuleReceiver ruleReceiver : list) {
				if (StringUtils.isNotBlank(ruleReceiver.getWechatAddr()) && !ruleReceiver.getWechatAddr().equals(Constant.RULERECEIVER_NOTWECHAT)) {
					TReceiver receiver = receiverService.findReceiverById(ruleReceiver.getReceiverId());
					receiverList.add(receiver);
					weChatAddressList.add(ruleReceiver.getWechatAddr());
				}
			}

			//去除可能的重复元素
			receiverList = new ArrayList<>(new HashSet<>(receiverList));
			weChatAddressList = new ArrayList<>(new HashSet<>(weChatAddressList));

			//查询最近监控日志信息，在规定时间间隔内，同一规则告警不发送接收人多次
			boolean isWeChatFlag = true; //是否发送微信预警

			//增量数据方式，与发送方式5，不做告警间隔时间限制
			if (!"increment".equals(scheduleJob.getType()) && scheduleJob.getSendType() != Constant.MONITRULE_SEND_TYPE_ALWAYS) {
				//该接收人最近规定时间间隔内接受到该条监控规则微信告警的日志
				TMonitLog monitLogWeChatOld = monitLogService.findMonitLogByRuleIdLastOneWeChat(scheduleJob.getJobId(), config.getNoticeInterval() * 1000);
				//短信是否需要通知
				isWeChatFlag = (monitLogWeChatOld == null ? true : false);
			}
			if (scheduleJob.getSendType() == Constant.MONITRULE_SEND_TYPE_ONCE) {
				//对于当天只发送一次的消息，查询该接收人最近一天内接受到该条监控规则微信告警的日志
				TMonitLog monitLogWeChatOnceOld = monitLogService.findMonitLogByRuleIdTodayWeChat(scheduleJob.getJobId());
				//微信是否需要通知
				isWeChatFlag = (monitLogWeChatOnceOld == null ? isWeChatFlag : false);
			}

			//发送微信消息
			if (isWeChatFlag) {
				Boolean result = false;
				for (String wechatAddress : weChatAddressList) {
					try {
						TConfiguration tConfiguration = configurationService.findConfigurationVaildByName(wechatAddress);
						if (tConfiguration == null) {
							continue;
						}
						String urlAddress = tConfiguration.getContent();

						if (weChatService.sendText(scheduleJob.getWarningMessage(), receiverList, urlAddress)) {
							result = true;
						}
					} catch (Exception e) {
						log.error("微信消息发送失败:{}", e.getMessage());
					}
				}
				if (result) {
					jobLog.setIsWechat(Constant.MONITLOG_ISWECHAT);
				} else {
					jobLog.setIsWechat(Constant.MONITLOG_ISWECHAT);
				}
			}
		}
	}

	private void sendNotifyMessage(ScheduleJob scheduleJob, String message) {

		if(scheduleJob.getWarning()){

			log.debug("job({})发送告警消息:{}",scheduleJob.getJobId(),scheduleJob.getWarningMessage());

			//获取监控规则与消息接收人映射
			List<TRuleReceiver> list = ruleReceiverService.getRuleReceiverByRuleId(scheduleJob.getJobId());
			if(list != null && list.size() > 0){
				for(int i = 0;i<list.size();i++) {
					TRuleReceiver ruleReceiver = list.get(i);

					//取得接收人信息
					TReceiver receiver = receiverService.findReceiverById(ruleReceiver.getReceiverId());
					if(receiver != null) {

						//针对每个接收人记录规则执行情况
						TMonitLog jobLog = new TMonitLog();
						jobLog.setCreatedTime(new Date());
						jobLog.setRuleId(scheduleJob.getJobId());
						jobLog.setResult(message);
						jobLog.setReceiverId(receiver.getReceiverId());
						jobLog.setIsWarning(Constant.MONITLOG_ISWARNING);
						jobLog.setIsMail(Constant.MONITLOG_ISNOTMAIL);  // 默认标记
						jobLog.setIsTelephone(Constant.MONITLOG_ISNOTTELEPHONE); // 默认标记

 						//查询最近监控日志信息，在规定时间间隔内，同一规则告警不发送接收人多次
						boolean isMailFlag = true; //是否发送邮件预警
						boolean isTelephoneFlag = true; //是否发送短信预警

						//增量数据方式，与发送方式5，不做告警间隔时间限制
						if(!"increment".equals(scheduleJob.getType()) && scheduleJob.getSendType() != Constant.MONITRULE_SEND_TYPE_ALWAYS) {
							//该接收人最近规定时间间隔内接受到该条监控规则邮件告警的日志
							TMonitLog monitLogMailOld = monitLogService.findMonitLogByRuleIdLastOneMail(ruleReceiver.getRuleId(), receiver.getReceiverId(), config.getNoticeInterval() * 1000);
							//邮件是否需要通知
							isMailFlag = (monitLogMailOld == null ? true : false);

							//该接收人最近规定时间间隔内接受到该条监控规则短信告警的日志
							TMonitLog monitLogTelephoneOld = monitLogService.findMonitLogByRuleIdLastOneTelephone(ruleReceiver.getRuleId(), receiver.getReceiverId(), config.getNoticeInterval() * 1000);
							//短信是否需要通知
							isTelephoneFlag = (monitLogTelephoneOld == null ? true : false);
						}
						if(scheduleJob.getSendType() == Constant.MONITRULE_SEND_TYPE_ONCE) {
							//对于当天只发送一次的短信消息，查询该接收人最近一天内接受到该条监控规则短信告警的日志
							TMonitLog monitLogTelephoneOnceOld = monitLogService.findMonitLogByRuleIdTodayTelephone(ruleReceiver.getRuleId(), receiver.getReceiverId());
							//短信是否需要通知
							isTelephoneFlag = (monitLogTelephoneOnceOld == null ? isTelephoneFlag : false);
						}

						//发送邮件
						if(ruleReceiver.getIsMail() == Constant.RULERECEIVER_ISMAIL && isMailFlag) {

							StringBuffer messageContent = new StringBuffer("");
							messageContent.append("告警消息：<font color='red'>");
							messageContent.append(scheduleJob.getWarningMessage());
							messageContent.append("</font><br>执行内容：");
							messageContent.append(scheduleJob.getContent());
							messageContent.append("<br>期望结果：");
							messageContent.append(scheduleJob.getExpectedResult());
							messageContent.append("<br>执行结果：");
							messageContent.append(scheduleJob.getExecuteResult());

							String result = emailService.sendEmail(receiver.getEmail(),"easymon业务告警消息",messageContent.toString());
							if ("SUCCESS".equals(result)) {
								jobLog.setIsMail(Constant.MONITLOG_ISMAIL);
							} else {
								jobLog.setIsMail(Constant.MONITLOG_ISNOTMAIL);
								jobLog.setResult("发送邮件失败");
							}
						}

						//发送短信
						if(ruleReceiver.getIsTelephone() == Constant.RULERECEIVER_ISTELEPHONE && isTelephoneFlag) {
							String result = smsService.send(receiver.getMobilePhone(), scheduleJob.getWarningMessage());
							if ("SUCCESS".equals(result)) {
								jobLog.setIsTelephone(Constant.MONITLOG_ISTELEPHONE);
							} else {
								jobLog.setIsTelephone(Constant.MONITLOG_ISNOTTELEPHONE);
								jobLog.setResult("发送短信失败");
							}
						}

						monitLogService.insert(jobLog);
					}
				}
			}
		}
	}

}
