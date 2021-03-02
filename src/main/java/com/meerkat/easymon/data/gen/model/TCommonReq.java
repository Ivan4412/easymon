package com.meerkat.easymon.data.gen.model;

import java.io.Serializable;
import java.util.Date;

public class TCommonReq implements Serializable {
    private Long id;

    private String appId;

    private String interfaceName;

    private Short isSuccess;

    private String reqContent;

    private String rspContent;

    private String returnCode;

    private String remark;

    private Date createdTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName == null ? null : interfaceName.trim();
    }

    public Short getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(Short isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getReqContent() {
        return reqContent;
    }

    public void setReqContent(String reqContent) {
        this.reqContent = reqContent == null ? null : reqContent.trim();
    }

    public String getRspContent() {
        return rspContent;
    }

    public void setRspContent(String rspContent) {
        this.rspContent = rspContent == null ? null : rspContent.trim();
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode == null ? null : returnCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appId=").append(appId);
        sb.append(", interfaceName=").append(interfaceName);
        sb.append(", isSuccess=").append(isSuccess);
        sb.append(", reqContent=").append(reqContent);
        sb.append(", rspContent=").append(rspContent);
        sb.append(", returnCode=").append(returnCode);
        sb.append(", remark=").append(remark);
        sb.append(", createdTime=").append(createdTime);
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
        TCommonReq other = (TCommonReq) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAppId() == null ? other.getAppId() == null : this.getAppId().equals(other.getAppId()))
            && (this.getInterfaceName() == null ? other.getInterfaceName() == null : this.getInterfaceName().equals(other.getInterfaceName()))
            && (this.getIsSuccess() == null ? other.getIsSuccess() == null : this.getIsSuccess().equals(other.getIsSuccess()))
            && (this.getReqContent() == null ? other.getReqContent() == null : this.getReqContent().equals(other.getReqContent()))
            && (this.getRspContent() == null ? other.getRspContent() == null : this.getRspContent().equals(other.getRspContent()))
            && (this.getReturnCode() == null ? other.getReturnCode() == null : this.getReturnCode().equals(other.getReturnCode()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getCreatedTime() == null ? other.getCreatedTime() == null : this.getCreatedTime().equals(other.getCreatedTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAppId() == null) ? 0 : getAppId().hashCode());
        result = prime * result + ((getInterfaceName() == null) ? 0 : getInterfaceName().hashCode());
        result = prime * result + ((getIsSuccess() == null) ? 0 : getIsSuccess().hashCode());
        result = prime * result + ((getReqContent() == null) ? 0 : getReqContent().hashCode());
        result = prime * result + ((getRspContent() == null) ? 0 : getRspContent().hashCode());
        result = prime * result + ((getReturnCode() == null) ? 0 : getReturnCode().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getCreatedTime() == null) ? 0 : getCreatedTime().hashCode());
        return result;
    }
}