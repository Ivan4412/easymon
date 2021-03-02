package com.meerkat.easymon.data.gen.model;

import java.io.Serializable;
import java.util.Date;

public class TMonitRule implements Serializable {
    private String ruleId;

    private Long datesourceId;

    private String type;

    private String content;

    private String expectedResult;

    private String ruleDesc;

    private Short triggerType;

    private Integer triggerInterval;

    private String cronExpression;

    private String message;

    private Short isVaild;

    private String creater;

    private Date createTime;

    private String updater;

    private Date updateTime;

    private Short sendType;

    private static final long serialVersionUID = 1L;

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
    }

    public Long getDatesourceId() {
        return datesourceId;
    }

    public void setDatesourceId(Long datesourceId) {
        this.datesourceId = datesourceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult == null ? null : expectedResult.trim();
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc == null ? null : ruleDesc.trim();
    }

    public Short getTriggerType() {
        return triggerType;
    }

    public void setTriggerType(Short triggerType) {
        this.triggerType = triggerType;
    }

    public Integer getTriggerInterval() {
        return triggerInterval;
    }

    public void setTriggerInterval(Integer triggerInterval) {
        this.triggerInterval = triggerInterval;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression == null ? null : cronExpression.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public Short getIsVaild() {
        return isVaild;
    }

    public void setIsVaild(Short isVaild) {
        this.isVaild = isVaild;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Short getSendType() {
        return sendType;
    }

    public void setSendType(Short sendType) {
        this.sendType = sendType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ruleId=").append(ruleId);
        sb.append(", datesourceId=").append(datesourceId);
        sb.append(", type=").append(type);
        sb.append(", content=").append(content);
        sb.append(", expectedResult=").append(expectedResult);
        sb.append(", ruleDesc=").append(ruleDesc);
        sb.append(", triggerType=").append(triggerType);
        sb.append(", triggerInterval=").append(triggerInterval);
        sb.append(", cronExpression=").append(cronExpression);
        sb.append(", message=").append(message);
        sb.append(", isVaild=").append(isVaild);
        sb.append(", creater=").append(creater);
        sb.append(", createTime=").append(createTime);
        sb.append(", updater=").append(updater);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", sendType=").append(sendType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TMonitRule other = (TMonitRule) that;
        return (this.getRuleId() == null ? other.getRuleId() == null : this.getRuleId().equals(other.getRuleId()))
            && (this.getDatesourceId() == null ? other.getDatesourceId() == null : this.getDatesourceId().equals(other.getDatesourceId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getExpectedResult() == null ? other.getExpectedResult() == null : this.getExpectedResult().equals(other.getExpectedResult()))
            && (this.getRuleDesc() == null ? other.getRuleDesc() == null : this.getRuleDesc().equals(other.getRuleDesc()))
            && (this.getTriggerType() == null ? other.getTriggerType() == null : this.getTriggerType().equals(other.getTriggerType()))
            && (this.getTriggerInterval() == null ? other.getTriggerInterval() == null : this.getTriggerInterval().equals(other.getTriggerInterval()))
            && (this.getCronExpression() == null ? other.getCronExpression() == null : this.getCronExpression().equals(other.getCronExpression()))
            && (this.getMessage() == null ? other.getMessage() == null : this.getMessage().equals(other.getMessage()))
            && (this.getIsVaild() == null ? other.getIsVaild() == null : this.getIsVaild().equals(other.getIsVaild()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getSendType() == null ? other.getSendType() == null : this.getSendType().equals(other.getSendType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRuleId() == null) ? 0 : getRuleId().hashCode());
        result = prime * result + ((getDatesourceId() == null) ? 0 : getDatesourceId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getExpectedResult() == null) ? 0 : getExpectedResult().hashCode());
        result = prime * result + ((getRuleDesc() == null) ? 0 : getRuleDesc().hashCode());
        result = prime * result + ((getTriggerType() == null) ? 0 : getTriggerType().hashCode());
        result = prime * result + ((getTriggerInterval() == null) ? 0 : getTriggerInterval().hashCode());
        result = prime * result + ((getCronExpression() == null) ? 0 : getCronExpression().hashCode());
        result = prime * result + ((getMessage() == null) ? 0 : getMessage().hashCode());
        result = prime * result + ((getIsVaild() == null) ? 0 : getIsVaild().hashCode());
        result = prime * result + ((getCreater() == null) ? 0 : getCreater().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdater() == null) ? 0 : getUpdater().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getSendType() == null) ? 0 : getSendType().hashCode());
        return result;
    }
}