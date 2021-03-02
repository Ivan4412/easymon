package com.meerkat.easymon.schedule;

import com.meerkat.easymon.data.gen.model.TMonitRule;
import com.meerkat.easymon.dto.ScheduleJob;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author : yjs
 * createTime : 2018/6/5
 * description : 定时任务服务类
 * version : 1.0
 */
@Service
public interface ScheduleJobService {

    /**
     * 初始化定时任务
     */
    public void initScheduleJob();


    /**
     * 运行一次任务
     *
     * @param scheduleJobId the schedule job id
     * @return
     */
    public void runOnce(Long scheduleJobId);

    /**
     * 暂停任务
     *
     * @param scheduleJobId the schedule job id
     * @return
     */
    public void pauseJob(Long scheduleJobId);

    /**
     * 恢复任务
     *
     * @param scheduleJobId the schedule job id
     * @return
     */
    public void resumeJob(Long scheduleJobId);

    /**
     * 获取任务对象
     * 
     * @param scheduleJobId
     * @return
     */
    public ScheduleJob get(Long scheduleJobId);

    /**
     * 查询任务列表
     * 
     * @param scheduleJob
     * @return
     */
    public List<ScheduleJob> queryList(ScheduleJob scheduleJob);

    /**
     * 获取运行中的任务列表
     *
     * @return
     */
    public List<ScheduleJob> queryExecutingJobList();

    /**
     * 监控规则转成定时任务类
     *
     * @param monitRule
     */
    public ScheduleJob convertScheduleJob(TMonitRule monitRule);

}
