package com.meerkat.easymon.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:system.properties",encoding = "utf-8")
@Configuration
public class Config {

    @Value("${APP.SHUTDOWN.HOOK}")
    private String shutdownHook;

    @Value("${EASYMONSERVICE.INTERVAL}")
    private Integer serviceInterval;

    @Value("${NOTICE.INTERVAL}")
    private Integer noticeInterval;

    @Value("${SMS.USERNAME}")
    private String smsUsername;

    @Value("${SMS.PASSWORD}")
    private String smsPassword;

    @Value("${SMS.NOTICE_ADDRESS}")
    private String noticeAddress;

    @Value("${SMS.USE_URL}")
    private String smsUseUrl;

    @Value("${SMS.USED_URL}")
    private String smsUsedUrl;

    @Value("${EMAIL.PORT}")
    private String emailPort;

    @Value("${EMAIL.HOST}")
    private String emailHost;

    @Value("${EMAIL.AUTH}")
    private String emailAuth;

    @Value("${EMAIL.EMAIL}")
    private String emailAddress;

    @Value("${EMAIL_PASSWORD}")
    private String emailPassword;

    @Value("${EMAIL_FROM}")
    private String emailFrom;

    @Value("${EMAIL_FROM_NAME}")
    private String emailFromName;

    @Value("${APP_ID}")
    private String appId;

    public Integer getNoticeInterval() {
        return noticeInterval;
    }

    public void setNoticeInterval(Integer noticeInterval) {
        this.noticeInterval = noticeInterval;
    }

    public String getEmailPort() {
        return emailPort;
    }

    public void setEmailPort(String emailPort) {
        this.emailPort = emailPort;
    }

    public String getEmailHost() {
        return emailHost;
    }

    public void setEmailHost(String emailHost) {
        this.emailHost = emailHost;
    }

    public String getEmailAuth() {
        return emailAuth;
    }

    public void setEmailAuth(String emailAuth) {
        this.emailAuth = emailAuth;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmailPassword() {
        return emailPassword;
    }

    public void setEmailPassword(String emailPassword) {
        this.emailPassword = emailPassword;
    }

    public String getEmailFrom() {
        return emailFrom;
    }

    public void setEmailFrom(String emailFrom) {
        this.emailFrom = emailFrom;
    }

    public String getEmailFromName() {
        return emailFromName;
    }

    public void setEmailFromName(String emailFromName) {
        this.emailFromName = emailFromName;
    }

    public String getSmsUseUrl() {
        return smsUseUrl;
    }

    public void setSmsUseUrl(String smsUseUrl) {
        this.smsUseUrl = smsUseUrl;
    }

    public String getSmsUsedUrl() {
        return smsUsedUrl;
    }

    public void setSmsUsedUrl(String smsUsedUrl) {
        this.smsUsedUrl = smsUsedUrl;
    }

    public String getSmsUsername() {
        return smsUsername;
    }

    public void setSmsUsername(String smsUsername) {
        this.smsUsername = smsUsername;
    }

    public String getSmsPassword() {
        return smsPassword;
    }

    public void setSmsPassword(String smsPassword) {
        this.smsPassword = smsPassword;
    }

    public String getNoticeAddress() {
        return noticeAddress;
    }

    public void setNoticeAddress(String noticeAddress) {
        this.noticeAddress = noticeAddress;
    }

    public String getShutdownHook() {
        return shutdownHook;
    }

    public void setShutdownHook(String shutdownHook) {
        this.shutdownHook = shutdownHook;
    }

    public Integer getServiceInterval() {
        return serviceInterval;
    }

    public void setServiceInterval(Integer serviceInterval) {
        this.serviceInterval = serviceInterval;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

}
