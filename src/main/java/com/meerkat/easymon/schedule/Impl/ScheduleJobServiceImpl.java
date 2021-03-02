package com.meerkat.easymon.schedule.Impl;

import com.meerkat.easymon.common.Constant;
import com.meerkat.easymon.config.Config;
import com.meerkat.easymon.data.gen.model.TDatasource;
import com.meerkat.easymon.data.gen.model.TMonitRule;
import com.meerkat.easymon.dto.ScheduleJob;
import com.meerkat.easymon.schedule.ScheduleJobService;
import com.meerkat.easymon.service.DataResourceService;
import com.meerkat.easymon.service.MonitRuleService;
import com.meerkat.easymon.util.ScheduleUtils;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * author : yjs
 * createTime : 2018/6/5
 * description : 定时任务服务类
 * version : 1.0
 */
@Service
public class ScheduleJobServiceImpl implements ScheduleJobService {

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
     * 数据源服务
     */
    @Autowired
    private DataResourceService dataResourceService;

    /**
     * 系统配置
     */
    @Autowired
    private Config config;

    /**
     * 日志信息
     */
    private static final Logger log = LoggerFactory.getLogger(ScheduleJobServiceImpl.class);

    public void initScheduleJob() {

        //获取所有有效监控规则
        List<TMonitRule> listRult = monitRuleService.getAllValidMonitRule();
        if (!CollectionUtils.isEmpty(listRult)) { //存在有效监控规则，则启动或更新
            for (TMonitRule monitRule : listRult) {

                ScheduleJob scheduleJob = this.convertScheduleJob(monitRule);

                Trigger trigger = ScheduleUtils.getTrigger(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup());

                //不存在，创建一个
                if (trigger == null) {
                    ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
                    log.info("启动任务：(jobId:{},jobGroup:{},jobDesc:{},datasource:{},cron:{},interval:{},content:{},expect:{},message:{})", scheduleJob.getJobId(), scheduleJob.getJobGroup(), scheduleJob.getDescription(), scheduleJob.getDatasource()==null?null:scheduleJob.getDatasource().getDatasourceDesc(), scheduleJob.getCronExpression(), scheduleJob.getTriggerInterval(), scheduleJob.getContent(), scheduleJob.getExpectedResult(), scheduleJob.getWarningMessage());
                } else {
                    //已存在，那么更新相应的定时设置
                    ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
                    log.info("更新任务：(jobId:{},jobGroup:{},jobDesc:{},datasource:{},cron:{},interval:{},content:{},expect:{},message:{})", scheduleJob.getJobId(), scheduleJob.getJobGroup(), scheduleJob.getDescription(), scheduleJob.getDatasource()==null?null:scheduleJob.getDatasource().getDatasourceDesc(), scheduleJob.getCronExpression(), scheduleJob.getTriggerInterval(), scheduleJob.getContent(), scheduleJob.getExpectedResult(), scheduleJob.getWarningMessage());
                }
            }
        }

        //启动规则监控任务（当数据库中监控规则发生变化时，更新监控任务）
        Trigger rulemonitTrigger = ScheduleUtils.getTrigger(scheduler, "RuleMonit", "group0");
        if (rulemonitTrigger == null) {
            ScheduleUtils.createRuleMonitScheduleJob(scheduler, "RuleMonit", "group0", config.getServiceInterval());
            log.info("启动规则监控任务(RuleMonit:group0:{})",config.getServiceInterval());
        } else {
            ScheduleUtils.updateRuleMonitScheduleJob(scheduler, "RuleMonit", "group0", config.getServiceInterval());
            log.info("更新规则监控任务(RuleMonit:group0:{})",config.getServiceInterval());
        }

    }

    /**
     * 监控规则转成定时任务类
     *
     * @param monitRule
     */
    public ScheduleJob convertScheduleJob(TMonitRule monitRule) {
        ScheduleJob scheduleJob = new ScheduleJob();
        scheduleJob.setJobId(monitRule.getRuleId());
        scheduleJob.setJobGroup("Group1"); //规则调度任务，都放在Group1中
        scheduleJob.setJobName(monitRule.getRuleId());
        scheduleJob.setTriggerState(Trigger.TriggerState.NONE);
        scheduleJob.setWarning(false);//默认不告警

        if(monitRule.getIsVaild() == Constant.MONITRULE_ISVAILD ){
            scheduleJob.setValid(true);
        }else{
            scheduleJob.setValid(false);
        }

        scheduleJob.setTriggerType(monitRule.getTriggerType()); //触发类型
        scheduleJob.setTriggerInterval(monitRule.getTriggerInterval() == null ? 0 : monitRule.getTriggerInterval()); //触发间隔
        scheduleJob.setCronExpression(monitRule.getCronExpression());

        //查找数据源
        if(monitRule.getDatesourceId() != null) {
            TDatasource datasource = dataResourceService.findDatasourceById(monitRule.getDatesourceId());
            scheduleJob.setDatasource(datasource);
        }else{
            scheduleJob.setDatasource(null);
        }

        scheduleJob.setDescription(monitRule.getRuleDesc());
        scheduleJob.setType(monitRule.getType());
        scheduleJob.setContent(monitRule.getContent());
        scheduleJob.setExpectedResult(monitRule.getExpectedResult());
        scheduleJob.setExecuteResult("");
        scheduleJob.setWarningMessage(monitRule.getMessage());
        scheduleJob.setSendType(monitRule.getSendType() == null ? 0 : monitRule.getSendType()); //预警发送方式
        scheduleJob.setGmtCreate(new Date());
        scheduleJob.setGmtModify(new Date());

        return scheduleJob;
    }


    public void runOnce(Long scheduleJobId) {
 /*       ScheduleJob scheduleJob = jdbcDao.get(ScheduleJob.class, scheduleJobId);
        ScheduleUtils.runOnce(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup());*/
    }

    public void pauseJob(Long scheduleJobId) {
/*        ScheduleJob scheduleJob = jdbcDao.get(ScheduleJob.class, scheduleJobId);
        ScheduleUtils.pauseJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup());
         */
    }

    public void resumeJob(Long scheduleJobId) {
/*        ScheduleJob scheduleJob = jdbcDao.get(ScheduleJob.class, scheduleJobId);
        ScheduleUtils.resumeJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup());
         */
    }

    public ScheduleJob get(Long scheduleJobId) {
  /*      ScheduleJob scheduleJob = jdbcDao.get(ScheduleJob.class, scheduleJobId);
        return scheduleJob;*/
        return null;
    }

    public List<ScheduleJob> queryList(ScheduleJob scheduleJob) {

    /*     List<ScheduleJob> scheduleJobList = jdbcDao.queryList(scheduleJob);

        try {
            for (ScheduleJob job : scheduleJobList) {

                JobKey jobKey = ScheduleUtils.getJobKey(job.getJobName(), job.getJobGroup());
                List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
                if (CollectionUtils.isEmpty(triggers)) {
                    continue;
                }

                //这里一个任务可以有多个触发器， 但是我们一个任务对应一个触发器，所以只取第一个即可，清晰明了
                Trigger trigger = triggers.iterator().next();
                job.setJobTrigger(trigger.getKey().getName());

                Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
                job.setStatus(triggerState.name());

                if (trigger instanceof CronTrigger) {
                    CronTrigger cronTrigger = (CronTrigger) trigger;
                    String cronExpression = cronTrigger.getCronExpression();
                    job.setCronExpression(cronExpression);
                }
            }
        } catch (SchedulerException e) {

        }
       return scheduleJobList;*/

        return null;

    }

    /**
     * 获取运行中的job列表
     *
     * @return
     */
    public List<ScheduleJob> queryExecutingJobList() {

     /*   try {
            // 存放结果集
            List<ScheduleJob> jobList = new ArrayList<ScheduleJob>();

            // 获取scheduler中的JobGroupName
            for (String group:scheduler.getJobGroupNames()){
                // 获取JobKey 循环遍历JobKey
                for(JobKey jobKey:scheduler.getJobKeys(GroupMatcher.<JobKey>groupEquals(group))){
                    JobDetail jobDetail = scheduler.getJobDetail(jobKey);
                    JobDataMap jobDataMap = jobDetail.getJobDataMap();
                    ScheduleJob scheduleJob = (ScheduleJob)jobDataMap.get(ScheduleJob.JOB_PARAM_KEY);
                    List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
                    Trigger trigger = triggers.iterator().next();
                    Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
                    scheduleJob.setJobTrigger(trigger.getKey().getName());
                    scheduleJob.setStatus(triggerState.name());
                    if (trigger instanceof CronTrigger) {
                        CronTrigger cronTrigger = (CronTrigger) trigger;
                        String cronExpression = cronTrigger.getCronExpression();
                        scheduleJob.setCronExpression(cronExpression);
                    }
                    // 获取正常运行的任务列表
                    if(triggerState.name().equals("NORMAL")){
                        jobList.add(scheduleJob);
                    }
                }
            }*/

        /** 非集群环境获取正在执行的任务列表 */
        /**
         List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();
         List<ScheduleJobVo> jobList = new ArrayList<ScheduleJobVo>(executingJobs.size());
         for (JobExecutionContext executingJob : executingJobs) {
         ScheduleJobVo job = new ScheduleJobVo();
         JobDetail jobDetail = executingJob.getJobDetail();
         JobKey jobKey = jobDetail.getKey();
         Trigger trigger = executingJob.getTrigger();
         job.setJobName(jobKey.getName());
         job.setJobGroup(jobKey.getGroup());
         job.setJobTrigger(trigger.getKey().getName());
         Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
         job.setStatus(triggerState.name());
         if (trigger instanceof CronTrigger) {
         CronTrigger cronTrigger = (CronTrigger) trigger;
         String cronExpression = cronTrigger.getCronExpression();
         job.setCronExpression(cronExpression);
         }
         jobList.add(job);
         }*/

 /*           return jobList;
        } catch (SchedulerException e) {
            return null;
        }*/
        return null;

    }
}
