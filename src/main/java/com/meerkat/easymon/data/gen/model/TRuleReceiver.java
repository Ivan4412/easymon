package com.meerkat.easymon.data.gen.model;

import java.io.Serializable;
import java.util.Date;

public class TRuleReceiver implements Serializable {
    private Long id;

    private String receiverId;

    private String ruleId;

    private Short isMail;

    private Short isTelephone;

    private String wechatAddr;

    private String creater;

    private Date createTime;

    private String updater;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId == null ? null : receiverId.trim();
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId == null ? null : ruleId.trim();
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

    public String getWechatAddr() {
        return wechatAddr;
    }

    public void setWechatAddr(String wechatAddr) {
        this.wechatAddr = wechatAddr == null ? null : wechatAddr.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", receiverId=").append(receiverId);
        sb.append(", ruleId=").append(ruleId);
        sb.append(", isMail=").append(isMail);
        sb.append(", isTelephone=").append(isTelephone);
        sb.append(", wechatAddr=").append(wechatAddr);
        sb.append(", creater=").append(creater);
        sb.append(", createTime=").append(createTime);
        sb.append(", updater=").append(updater);
        sb.append(", updateTime=").append(updateTime);
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
        TRuleReceiver other = (TRuleReceiver) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getReceiverId() == null ? other.getReceiverId() == null : this.getReceiverId().equals(other.getReceiverId()))
            && (this.getRuleId() == null ? other.getRuleId() == null : this.getRuleId().equals(other.getRuleId()))
            && (this.getIsMail() == null ? other.getIsMail() == null : this.getIsMail().equals(other.getIsMail()))
            && (this.getIsTelephone() == null ? other.getIsTelephone() == null : this.getIsTelephone().equals(other.getIsTelephone()))
            && (this.getWechatAddr() == null ? other.getWechatAddr() == null : this.getWechatAddr().equals(other.getWechatAddr()))
            && (this.getCreater() == null ? other.getCreater() == null : this.getCreater().equals(other.getCreater()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdater() == null ? other.getUpdater() == null : this.getUpdater().equals(other.getUpdater()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getReceiverId() == null) ? 0 : getReceiverId().hashCode());
        result = prime * result + ((getRuleId() == null) ? 0 : getRuleId().hashCode());
        result = prime * result + ((getIsMail() == null) ? 0 : getIsMail().hashCode());
        result = prime * result + ((getIsTelephone() == null) ? 0 : getIsTelephone().hashCode());
        result = prime * result + ((getWechatAddr() == null) ? 0 : getWechatAddr().hashCode());
        result = prime * result + ((getCreater() == null) ? 0 : getCreater().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdater() == null) ? 0 : getUpdater().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}