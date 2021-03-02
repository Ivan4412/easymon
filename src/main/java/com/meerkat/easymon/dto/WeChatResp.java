package com.meerkat.easymon.dto;

import java.util.Objects;

/**
 * author : yjs
 * createTime : 2018/8/1
 * description :
 * version : 1.0
 */
public class WeChatResp {

    private static final long serialVersionUID = -1L;

    private Integer errcode;

    private String errmsg;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeChatResp)) return false;
        WeChatResp that = (WeChatResp) o;
        return Objects.equals(errcode, that.errcode) && Objects.equals(errmsg, that.errmsg);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errcode, errmsg);
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}

