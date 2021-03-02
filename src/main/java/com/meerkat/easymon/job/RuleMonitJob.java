package com.meerkat.easymon.job;

import com.meerkat.easymon.data.gen.model.TMonitRule;
import com.meerkat.easymon.dto.ScheduleJob;
import com.meerkat.easymon.schedule.ScheduleJobService;
import com.meerkat.easymon.service.MonitRuleService;
import com.meerkat.easymon.util.ScheduleUtils;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * author : yjs
 * createTime : 2018/6/8
 * description :
 * version : 1.0
 */
public class RuleMonitJob implements Job {

    private static final Logger log = LoggerFactory.getLogger(RuleMonitJob.class);

    /**
     * 调度工厂Bean
     */
    @Autowired
    private Scheduler scheduler;

    /**
     * 监控规则服务
     */
    @Autowired
    private MonitRuleService monitRuleService;

    /**
     * 定时调度任务服务类
     */
    @Autowired
    private ScheduleJobService scheduleJobService;


    /**
     * 规则监控任务执行方法
     * @param context
     * @throws JobExecutionException
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.debug("RuleMonitJob is running:{}", new Date());
        try {
            execute();
        }catch(Throwable e) {
            log.error("规则监控任务调度任务出错", e);
            throw new JobExecutionException(e);
        }
    }

    private void execute() throws JobExecutionException{
        //获取所有监控规则
        List<TMonitRule> listRult = monitRuleService.getAllMonitRule();
        if (CollectionUtils.isEmpty(listRult)) {
            return;
        }

        try {
            for (TMonitRule monitRule : listRult) {

            ScheduleJob scheduleJob = scheduleJobService.convertScheduleJob(monitRule);

            JobKey jokey = new JobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());


                if(scheduler != null && scheduler.getJobDetail(jokey) != null && scheduler.getJobDetail(jokey).getJobDataMap() != null
                        && scheduler.getJobDetail(jokey).getJobDataMap().get(ScheduleJob.JOB_PARAM_KEY) != null) { //如果存在在执行的该任务
                    ScheduleJob scheduleJobOld = (ScheduleJob) scheduler.getJobDetail(jokey).getJobDataMap().get(ScheduleJob.JOB_PARAM_KEY);
                    log.debug("旧规则{}:", scheduleJobOld);
                    log.debug("新规则{}:", scheduleJob);
                    if (!scheduleJob.equals(scheduleJobOld)) {
                        ScheduleUtils.deleteScheduleJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup());
                        if (scheduleJobOld != null && scheduleJob.getValid()) {
                            ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
                            log.info("监控规则变动，更新任务：(jobId:{},jobGroup:{},jobDesc:{},datasource:{},cron:{},interval:{},content:{},expect:{},message:{},isVaild:{}，sendType:{})", scheduleJob.getJobId(), scheduleJob.getJobGroup(), scheduleJob.getDescription(), scheduleJob.getDatasource()==null?null:scheduleJob.getDatasource().getDatasourceDesc(), scheduleJob.getCronExpression(), scheduleJob.getTriggerInterval(), scheduleJob.getContent(), scheduleJob.getExpectedResult(), scheduleJob.getWarningMessage(), scheduleJob.getValid(),scheduleJob.getSendType());
                        }else{
                            log.info("监控规则变动，停用任务：(jobId:{},jobGroup:{},jobDesc:{},datasource:{},cron:{},interval:{},content:{},expect:{},message:{},isVaild:{}，sendType:{})", scheduleJob.getJobId(), scheduleJob.getJobGroup(), scheduleJob.getDescription(), scheduleJob.getDatasource()==null?null:scheduleJob.getDatasource().getDatasourceDesc(), scheduleJob.getCronExpression(), scheduleJob.getTriggerInterval(), scheduleJob.getContent(), scheduleJob.getExpectedResult(), scheduleJob.getWarningMessage(), scheduleJob.getValid(),scheduleJob.getSendType());
                        }
                    }
                }else{
                    if (scheduleJob != null && scheduleJob.getValid()) {
                        ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
                        log.info("监控规则变动，发现新任务：(jobId:{},jobGroup:{},jobDesc:{},datasource:{},cron:{},interval:{},content:{},expect:{},message:{},isVaild:{}，sendType:{})", scheduleJob.getJobId(), scheduleJob.getJobGroup(), scheduleJob.getDescription(), scheduleJob.getDatasource()==null?null:scheduleJob.getDatasource().getDatasourceDesc(), scheduleJob.getCronExpression(), scheduleJob.getTriggerInterval(), scheduleJob.getContent(), scheduleJob.getExpectedResult(), scheduleJob.getWarningMessage(), scheduleJob.getValid(),scheduleJob.getSendType());
                    }
                 }

            }
        } catch (SchedulerException e) { //TODO
            throw new JobExecutionException(e.getMessage());
        }
    }

}
