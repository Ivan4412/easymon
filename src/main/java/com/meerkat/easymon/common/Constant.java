package com.meerkat.easymon.common;

/**
 * Created by yjs on 2018/6/5.
 */
public class Constant {

    //调用第三方接口返回码
    public static final String ERROR_CODE = "999999"; //失败
    public static final String SUCCERSS_CODE = "000000"; //成功

    //MonitRule表常量
    //是否有效
    public static final short MONITRULE_ISVAILD = 1;
    public static final short MONITRULE_ISNOTVAILD = 0;
    //触发类型
    public static final short MONITRULE_TRIGGER_TYPE_INTERVAL = 1; //间隔
    public static final short MONITRULE_TRIGGER_TYPE_CRON= 2; //Cron表达式
    //发送方式
    public static final short MONITRULE_SEND_TYPE_IMMEDIATELY = 1; //立即发送
    public static final short MONITRULE_SEND_TYPE_LATE = 2; //次日统一发送
    public static final short MONITRULE_SEND_TYPE_AUTO = 3; //如果当前系统时间在晚上22点到早晨7点之间，早晨7点统一发送，否则立即发送
    public static final short MONITRULE_SEND_TYPE_ONCE = 4; //当天只发送一次
    public static final short MONITRULE_SEND_TYPE_ALWAYS = 5; //立即发送，无视配置的不重复告警时间限制

    //RuleReceiver表常量
    //是否发送邮件
    public static final short RULERECEIVER_ISMAIL = 1;
    public static final short RULERECEIVER_ISNOTMAIL = 0;
    //是否发送短信
    public static final short RULERECEIVER_ISTELEPHONE = 1;
    public static final short RULERECEIVER_ISNOTTELEPHONE = 0;
    //是否已发送微信消息
    public static final String RULERECEIVER_NOTWECHAT = "0";

    //MonitLog表常量
    //是否告警
    public static final short MONITLOG_ISWARNING = 1;
    public static final short MONITLOG_ISNOTWARNING = 0;
    //是否已发送邮件
    public static final short MONITLOG_ISMAIL = 1;
    public static final short MONITLOG_ISNOTMAIL = 0;
    //是否已发送短信
    public static final short MONITLOG_ISTELEPHONE = 1;
    public static final short MONITLOG_ISNOTTELEPHONE = 0;
    //是否已发送微信消息
    public static final short MONITLOG_ISWECHAT = 1;
    public static final short MONITLOG_ISNOTWECHAT = 0;

    //CommonReq标常量
    //请求是否成功
    public static final short COMMONREQ_SUCESS = 1;
    public static final short COMMONREQ_FAIL = 0;
    public static final short COMMONREQ_AMBIGUITY = 2;

    //Configuration常量
    //是否有效
    public static final short CONFIGURATION_ISVAILD = 1;
    public static final short CONFIGURATION_ISNOTVAILD = 0;

}
