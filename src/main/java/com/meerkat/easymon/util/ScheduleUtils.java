package com.meerkat.easymon.util;


import com.meerkat.easymon.common.Constant;
import com.meerkat.easymon.dto.ScheduleJob;
import com.meerkat.easymon.exceptions.ScheduleException;
import com.meerkat.easymon.job.MainJob;
import com.meerkat.easymon.job.RuleMonitJob;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * author : yjs
 * createTime : 2018/6/5
 * description : 定时任务操作辅助类
 * version : 1.0
 */
public class ScheduleUtils {

    /**
     * 日志对象
     */
    private static final Logger LOG = LoggerFactory.getLogger(ScheduleUtils.class);

    /**
     * 获取触发器key
     *
     * @param jobName
     * @param jobGroup
     * @return
     */
    public static TriggerKey getTriggerKey(String jobName, String jobGroup) {

        return TriggerKey.triggerKey(jobName, jobGroup);
    }

    /**
     * 获取表达式触发器
     *
     * @param scheduler the scheduler
     * @param jobName   the job name
     * @param jobGroup  the job group
     * @return cron trigger
     */
    public static Trigger getTrigger(Scheduler scheduler, String jobName, String jobGroup) {

        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
            return scheduler.getTrigger(triggerKey);
        } catch (SchedulerException e) {
            LOG.error("获取定时任务CronTrigger出现异常", e);
            throw new ScheduleException("获取定时任务CronTrigger出现异常");
        }
    }

    /**
     * 获取简单触发器
     *
     * @param scheduler the scheduler
     * @param jobName   the job name
     * @param jobGroup  the job group
     * @return cron trigger
     */
    public static SimpleTrigger getSimpleTrigger(Scheduler scheduler, String jobName, String jobGroup) {

        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(jobName, jobGroup);
            return (SimpleTrigger) scheduler.getTrigger(triggerKey);
        } catch (SchedulerException e) {
            LOG.error("获取定时任务SimpleTrigger出现异常", e);
            throw new ScheduleException("获取定时任务CronTrigger出现异常");
        }
    }

    /**
     * 创建任务
     *
     * @param scheduler   the scheduler
     * @param scheduleJob the schedule job
     */
    public static void createScheduleJob(Scheduler scheduler, ScheduleJob scheduleJob) {

        switch (scheduleJob.getTriggerType()) {

            case Constant.MONITRULE_TRIGGER_TYPE_INTERVAL:  //间隔表达，将其转换为Cron表达式

                //简单调度构建器
                SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(scheduleJob.getTriggerInterval()).repeatForever();

                //创建定时调度任务
                createScheduleJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup(), simpleScheduleBuilder, scheduleJob);

                break;
            case Constant.MONITRULE_TRIGGER_TYPE_CRON: //Cron表达式

                //表达式调度构建器
                CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());

                //创建定时调度任务
                createScheduleJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup(), cronScheduleBuilder, scheduleJob);
                break;

            default:
                //TODO
                break;
        }

        scheduleJob.setTriggerState(Trigger.TriggerState.NORMAL); //任务启用

    }

    /**
     * 创建定时任务
     *
     * @param scheduler       the scheduler
     * @param jobName         the job name
     * @param jobGroup        the job group
     * @param scheduleBuilder this job scheduleBuilder
     * @param param           the param
     */
    public static void createScheduleJob(Scheduler scheduler, String jobName, String jobGroup, ScheduleBuilder scheduleBuilder, Object param) {

        //构建job信息
        JobDetail jobDetail = JobBuilder.newJob(MainJob.class).withIdentity(jobName, jobGroup).build();

        //按新的cronExpression表达式构建一个新的trigger
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroup).withSchedule(scheduleBuilder).build();

        String jobTrigger = trigger.getKey().getName();

        ScheduleJob scheduleJob = (ScheduleJob) param;
        scheduleJob.setJobTrigger(jobTrigger);

        //放入参数，运行时的方法可以获取
        jobDetail.getJobDataMap().put(ScheduleJob.JOB_PARAM_KEY, scheduleJob);

        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            LOG.error("创建定时任务失败", e);
            throw new ScheduleException("创建定时任务失败");
        }
    }

    /**
     * 运行一次任务
     *
     * @param scheduler
     * @param jobName
     * @param jobGroup
     */
    public static void runOnce(Scheduler scheduler, String jobName, String jobGroup) {
        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        try {
            scheduler.triggerJob(jobKey);
        } catch (SchedulerException e) {
            LOG.error("运行一次定时任务失败", e);
            throw new ScheduleException("运行一次定时任务失败");
        }
    }

    /**
     * 暂停任务
     *
     * @param scheduler
     * @param jobName
     * @param jobGroup
     */
    public static void pauseJob(Scheduler scheduler, String jobName, String jobGroup) {

        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        try {
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            LOG.error("暂停定时任务失败", e);
            throw new ScheduleException("暂停定时任务失败");
        }
    }

    /**
     * 恢复任务
     *
     * @param scheduler
     * @param jobName
     * @param jobGroup
     */
    public static void resumeJob(Scheduler scheduler, String jobName, String jobGroup) {

        JobKey jobKey = JobKey.jobKey(jobName, jobGroup);
        try {
            scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            LOG.error("暂停定时任务失败", e);
            throw new ScheduleException("暂停定时任务失败");
        }
    }

    /**
     * 获取jobKey
     *
     * @param jobName  the job name
     * @param jobGroup the job group
     * @return the job key
     */
    public static JobKey getJobKey(String jobName, String jobGroup) {

        return JobKey.jobKey(jobName, jobGroup);
    }

    /**
     * 更新定时任务
     *
     * @param scheduler   the scheduler
     * @param scheduleJob the schedule job
     */
    public static void updateScheduleJob(Scheduler scheduler, ScheduleJob scheduleJob) {

        switch (scheduleJob.getTriggerType()) {
            case Constant.MONITRULE_TRIGGER_TYPE_INTERVAL:  //间隔表达，将其转换为Cron表达式

                //简单调度构建器
                SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(scheduleJob.getTriggerInterval()).repeatForever();

                //更新定时调度任务
                updateScheduleJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup(), simpleScheduleBuilder);

                break;
            case Constant.MONITRULE_TRIGGER_TYPE_CRON: //Cron表达式

                //表达式调度构建器
                CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());

                //更新定时调度任务
                updateScheduleJob(scheduler, scheduleJob.getJobName(), scheduleJob.getJobGroup(), cronScheduleBuilder);
                break;

            default:
                //TODO
                break;
        }
    }


    /**
     * 更新定时任务
     *
     * @param scheduler       the scheduler
     * @param jobName         the job name
     * @param jobGroup        the job group
     * @param scheduleBuilder the cron scheduleBuilder
     */
    public static void updateScheduleJob(Scheduler scheduler, String jobName, String jobGroup, ScheduleBuilder scheduleBuilder) {

        try {
            TriggerKey triggerKey = ScheduleUtils.getTriggerKey(jobName, jobGroup);

            Trigger trigger = scheduler.getTrigger(triggerKey);

            //重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

            Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());

            // 忽略状态为PAUSED的任务，解决集群环境中在其他机器设置定时任务为PAUSED状态后，集群环境启动另一台主机时定时任务全被唤醒的bug
            if (!triggerState.name().equalsIgnoreCase("PAUSED")) {
                //按新的trigger重新设置job执行
                scheduler.rescheduleJob(triggerKey, trigger);
            }
        } catch (SchedulerException e) {
            LOG.error("更新定时任务失败", e);
            throw new ScheduleException("更新定时任务失败");
        }
    }

    /**
     * 删除定时任务
     *
     * @param scheduler
     * @param jobName
     * @param jobGroup
     */
    public static void deleteScheduleJob(Scheduler scheduler, String jobName, String jobGroup) {
        try {
            scheduler.deleteJob(getJobKey(jobName, jobGroup));
        } catch (SchedulerException e) {
            LOG.error("删除定时任务失败", e);
            throw new ScheduleException("删除定时任务失败");
        }
    }

    /**
     * 规则监控任务（当数据库中监控规则发生变化时，更新监控任务）
     * @param scheduler
     * @param jobName
     * @param jobGroup
     * @param interval
     */

    public static void createRuleMonitScheduleJob(Scheduler scheduler, String jobName, String jobGroup, int interval) {

        //构建job信息
        JobDetail jobDetail = JobBuilder.newJob(RuleMonitJob.class).withIdentity(jobName, jobGroup).build();

        //简单调度构建器
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(interval).repeatForever();

        //按新的cronExpression表达式构建一个新的trigger
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(jobName, jobGroup).withSchedule(simpleScheduleBuilder).build();

        try {
            scheduler.scheduleJob(jobDetail, trigger);
        } catch (SchedulerException e) {
            LOG.error("创建规则监控定时任务失败", e);
            throw new ScheduleException("创建规则监控定时任务失败");
        }
    }

    /**
     * 更新规则监控任务
     * @param scheduler
     * @param jobName
     * @param jobGroup
     * @param interval
     */

    public static void updateRuleMonitScheduleJob(Scheduler scheduler, String jobName, String jobGroup, int interval) {

        //简单调度构建器
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(interval).repeatForever();

        //更新定时调度任务
        updateScheduleJob(scheduler, jobName, jobGroup, simpleScheduleBuilder);

    }

}
