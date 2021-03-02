package com.meerkat.easymon.data.gen.model;

import java.io.Serializable;
import java.util.Date;

public class TMonitLog implements Serializable {
    private Long id;

    private String ruleId;

    private String receiverId;

    private String result;

    private Short isWarning;

    private Short isMail;

    private Short isTelephone;

    private Date createdTime;

    private Short isWechat;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId == null ? null : receiverId.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Short getIsWarning() {
        return isWarning;
    }

    public void setIsWarning(Short isWarning) {
        this.isWarning = isWarning;
    }

    public Short getIsMail() {
        return isMail;
    }

    public void setIsMail(Short isMail) {
        this.isMail = isMail;
    }

    public Short getIsTelephone() {
        return isTelephone;
    }

    public void setIsTelephone(Short isTelephone) {
        this.isTelephone = isTelephone;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Short getIsWechat() {
        return isWechat;
    }

    public void setIsWechat(Short isWechat) {
        this.isWechat = isWechat;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", ruleId=").append(ruleId);
        sb.append(", receiverId=").append(receiverId);
        sb.append(", result=").append(result);
        sb.append(", isWarning=").append(isWarning);
        sb.append(", isMail=").append(isMail);
        sb.append(", isTelephone=").append(isTelephone);
        sb.append(", createdTime=").append(createdTime);
        sb.append(", isWechat=").append(isWechat);
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
        TMonitLog other = (TMonitLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRuleId() == null ? other.getRuleId() == null : this.getRuleId().equals(other.getRuleId()))
            && (this.getReceiverId() == null ? other.getReceiverId() == null : this.getReceiverId().equals(other.getReceiverId()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getIsWarning() == null ? other.getIsWarning() == null : this.getIsWarning().equals(other.getIsWarning()))
            && (this.getIsMail() == null ? other.getIsMail() == null : this.getIsMail().equals(other.getIsMail()))
            && (this.getIsTelephone() == null ? other.getIsTelephone() == null : this.getIsTelephone().equals(other.getIsTelephone()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()))
            && (this.getIsWechat() == null ? other.getIsWechat() == null : this.getIsWechat().equals(other.getIsWechat()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRuleId() == null) ? 0 : getRuleId().hashCode());
        result = prime * result + ((getReceiverId() == null) ? 0 : getReceiverId().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getIsWarning() == null) ? 0 : getIsWarning().hashCode());
        result = prime * result + ((getIsMail() == null) ? 0 : getIsMail().hashCode());
        result = prime * result + ((getIsTelephone() == null) ? 0 : getIsTelephone().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        result = prime * result + ((getIsWechat() == null) ? 0 : getIsWechat().hashCode());
        return result;
    }
}