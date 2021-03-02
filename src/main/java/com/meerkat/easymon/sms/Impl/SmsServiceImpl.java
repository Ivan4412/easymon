package com.meerkat.easymon.sms.Impl;


import com.meerkat.easymon.common.Constant;
import com.meerkat.easymon.config.Config;
import com.meerkat.easymon.dto.SmsReq;
import com.meerkat.easymon.sms.SmsService;
import com.jianzhou.sdk.BusinessService;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * author : yjs
 * createTime : 2018/6/7
 * description : 短信服务类
 * version : 1.0
 */
@Service
public class SmsServiceImpl implements SmsService {
	private Logger logger = Logger.getLogger(SmsServiceImpl.class);

	@Autowired
	Config config;

	/** 日志信息*/
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(SmsServiceImpl.class);

	/**
	 * 本地发送短信消息
	 * @param phone
	 * @param content
	 * @return
	 */
	@Deprecated
	@Override
	public String send(String phone, String content) {
		
		BusinessService bs = new BusinessService();

		String username = config.getSmsUsername();
		String password = config.getSmsPassword();
		String smsUrl = config.getNoticeAddress();
		bs.setWebService(smsUrl);
		int ret = bs.sendBatchMessage(username, password, phone, content);
		String result = "SUCCESS";

		if (ret <= 0) {
			switch (ret) {
				case -1:
					result = "短信条数已用完";
					break;
				case -2:
					result = "登陆失败";
					break;
				default:
					result = "其他异常错误";
					break;
			}
		}

		log.info("Send message {} to {} result {}", content, phone, result);
		return result;
	}

}
