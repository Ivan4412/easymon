package com.meerkat.easymon.dto;

import com.meerkat.easymon.data.gen.model.TDatasource;
import org.quartz.Trigger;

import java.io.Serializable;
import java.util.Date;

/**
 * author : yjs
 * createTime : 2018/6/5
 * description : 定时任务类
 * version : 1.0
 */

public class ScheduleJob implements Serializable {

    private static final long  serialVersionUID = -4216007640768329946L;

    /** 任务调度的参数key */
    public static final String JOB_PARAM_KEY    = "jobParam";

    /** 任务id */
    private String             jobId;

    /** 任务名称 */
    private String             jobName;

    /** 任务分组 */
    private String             jobGroup;

    /** 触发器 */
    private String             jobTrigger;

    /** 任务状态 */
    private Trigger.TriggerState triggerState;

    /** 任务数据源 */
    private TDatasource       datasource;

    /** 触发类型 */
    private short             triggerType;

    /** 运行间隔时间*/
    private int             triggerInterval;

    /** 任务运行时间表达式 */
    private String             cronExpression;

    /** 任务描述 */
    private String             description;

    /** 任务类型 */
    private String             type;

    /** 任务内容 */
    private String             content;

    /** 预期结果 */
    private String             expectedResult;

    /** 执行结果 */
    private String             executeResult;

    /** 是否有效 */
    private Boolean            valid;

    /** 是否告警 */
    private Boolean            warning;

    /** 告警消息 */
    private String             warningMessage;

    /**发送方式 */
    private  short             sendType;

    /** 创建时间 */
    private Date               gmtCreate;

    /** 修改时间 */
    private Date               gmtModify;

    @Override
    public String toString() {
        return "ScheduleJob{" + "jobId='" + jobId + '\'' + ", jobName='" + jobName + '\'' + ", jobGroup='" + jobGroup + '\'' + ", jobTrigger='" + jobTrigger + '\'' + ", triggerState=" + triggerState + ", datasource=" + datasource + ", triggerType=" + triggerType + ", triggerInterval=" + triggerInterval + ", cronExpression='" + cronExpression + '\'' + ", description='" + description + '\'' + ", type='" + type + '\'' + ", content='" + content + '\'' + ", expectedResult='" + expectedResult + '\'' + ", executeResult='" + executeResult + '\'' + ", valid=" + valid + ", warning=" + warning + ", warningMessage='" + warningMessage + '\'' + ", sendType='" + sendType + '\'' + ", gmtCreate=" + gmtCreate + ", gmtModify=" + gmtModify + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScheduleJob that = (ScheduleJob) o;

        if (triggerType != that.triggerType) return false;
        if (triggerInterval != that.triggerInterval) return false;
        if (!jobId.equals(that.jobId)) return false;
        if (jobName != null ? !jobName.equals(that.jobName) : that.jobName != null) return false;
        if (jobGroup != null ? !jobGroup.equals(that.jobGroup) : that.jobGroup != null) return false;
     //   if (jobTrigger != null ? !jobTrigger.equals(that.jobTrigger) : that.jobTrigger != null) return false;
     //   if (triggerState != that.triggerState) return false;
        if (datasource != null ? !datasource.equals(that.datasource) : that.datasource != null) return false;
        if (cronExpression != null ? !cronExpression.equals(that.cronExpression) : that.cronExpression != null)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (expectedResult != null ? !expectedResult.equals(that.expectedResult) : that.expectedResult != null)
            return false;
        if (valid != null ? !valid.equals(that.valid) : that.valid != null) return false;
    //    if (warning != null ? !warning.equals(that.warning) : that.warning != null) return false;
        if (warningMessage != null ? !warningMessage.equals(that.warningMessage) : that.warningMessage != null)
            return false;
        if (sendType != that.sendType) return false;
    //    if (gmtCreate != null ? !gmtCreate.equals(that.gmtCreate) : that.gmtCreate != null) return false;
    //    return gmtModify != null ? gmtModify.equals(that.gmtModify) : that.gmtModify == null;
        return true;
    }

    @Override
    public int hashCode() {
        int result = jobId.hashCode();
        result = 31 * result + (jobName != null ? jobName.hashCode() : 0);
        result = 31 * result + (jobGroup != null ? jobGroup.hashCode() : 0);
        result = 31 * result + (jobTrigger != null ? jobTrigger.hashCode() : 0);
        result = 31 * result + (triggerState != null ? triggerState.hashCode() : 0);
        result = 31 * result + (datasource != null ? datasource.hashCode() : 0);
        result = 31 * result + (int) triggerType;
        result = 31 * result + triggerInterval;
        result = 31 * result + (cronExpression != null ? cronExpression.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (expectedResult != null ? expectedResult.hashCode() : 0);
        result = 31 * result + (executeResult != null ? executeResult.hashCode() : 0);
        result = 31 * result + (valid != null ? valid.hashCode() : 0);
        result = 31 * result + (warning != null ? warning.hashCode() : 0);
        result = 31 * result + (warningMessage != null ? warningMessage.hashCode() : 0);
        result = 31 * result + (int) sendType;
        result = 31 * result + (gmtCreate != null ? gmtCreate.hashCode() : 0);
        result = 31 * result + (gmtModify != null ? gmtModify.hashCode() : 0);
        return result;
    }

    public short getSendType() {
        return sendType;
    }

    public void setSendType(short sendType) {
        this.sendType = sendType;
    }

    public String getExecuteResult() {
        return executeResult;
    }

    public void setExecuteResult(String executeResult) {
        this.executeResult = executeResult;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public Trigger.TriggerState getTriggerState() {
        return triggerState;
    }

    public void setTriggerState(Trigger.TriggerState triggerState) {
        this.triggerState = triggerState;
    }

    public short getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(short triggerType) {
        this.triggerType = triggerType;
    }

    public int getTriggerInterval() {
        return triggerInterval;
    }

    public void setTriggerInterval(int triggerInterval) {
        this.triggerInterval = triggerInterval;
    }

    public Boolean getWarning() {
        return this.warning;
    }

    public void setWarning(Boolean warning) {
        this.warning = warning;
    }

    public TDatasource getDatasource() {
        return datasource;
    }

    public void setDatasource(TDatasource datasource) {
        this.datasource = datasource;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static String getJobParamKey() {
        return JOB_PARAM_KEY;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobTrigger() {
        return jobTrigger;
    }

    public void setJobTrigger(String jobTrigger) {
        this.jobTrigger = jobTrigger;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public String getWarningMessage() {
        return warningMessage;
    }

    public void setWarningMessage(String warningMessage) {
        this.warningMessage = warningMessage;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Date gmtModify) {
        this.gmtModify = gmtModify;
    }
}
