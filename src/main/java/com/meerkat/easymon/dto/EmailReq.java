package com.meerkat.easymon.dto;

/**
 * author : yjs
 * createTime : 2018/8/1
 * description :
 * version : 1.0
 */
public class EmailReq {

    private static final long  serialVersionUID =1L;

    private String receiver;

    private String subject;

    private String content;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmailReq emailReq = (EmailReq) o;

        if (!receiver.equals(emailReq.receiver)) return false;
        if (!subject.equals(emailReq.subject)) return false;
        return content.equals(emailReq.content);
    }

    @Override
    public int hashCode() {
        int result = receiver.hashCode();
        result = 31 * result + subject.hashCode();
        result = 31 * result + content.hashCode();
        return result;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
