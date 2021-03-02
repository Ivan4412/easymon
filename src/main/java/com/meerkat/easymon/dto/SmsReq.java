package com.meerkat.easymon.dto;

import java.io.Serializable;

/**
 * author : yjs
 * createTime : 2018/7/30
 * description :
 * version : 1.0
 */
public class SmsReq implements Serializable {

    private static final long  serialVersionUID =1L;

    private String phone;
    private String content;
    private int realtimeFlag;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmsReq smsReq = (SmsReq) o;

        if (realtimeFlag != smsReq.realtimeFlag) return false;
        if (phone != null ? !phone.equals(smsReq.phone) : smsReq.phone != null) return false;
        return content != null ? content.equals(smsReq.content) : smsReq.content == null;
    }

    @Override
    public int hashCode() {
        int result = phone != null ? phone.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + realtimeFlag;
        return result;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRealtimeFlag() {
        return realtimeFlag;
    }

    public void setRealtimeFlag(int realtimeFlag) {
        this.realtimeFlag = realtimeFlag;
    }
}
