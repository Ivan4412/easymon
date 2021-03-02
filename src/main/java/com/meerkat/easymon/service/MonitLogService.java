package com.meerkat.easymon.service;

import com.meerkat.easymon.data.gen.model.TMonitLog;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author : yjs
 * createTime : 2018/6/5
 * description : 监控信息日志服务类
 * version : 1.0
 */
@Service
public interface MonitLogService {

    /**
     * 记录监控信息日志
     */
    boolean insert(TMonitLog monitLog);

    /**
     * 根据ruled_id查询日志信息
     */
    List<TMonitLog> findMonitLogByRuleId(String ruleId);

    /**
     * 根据ruled_id查询最新一条日志信息
     */
    TMonitLog findMonitLogByRuleIdLastOne(String ruleId, String receiverId);

    /**
     * 根据ruled_id查询最新一条日志信息
     */
    TMonitLog findMonitLogByRuleIdLastOneToday(String ruleId);

    /**
     * 根据ruled_id和receiver_id查询在noticeInterval时间内最新一条成功发送邮件日志信息
     */
    TMonitLog findMonitLogByRuleIdLastOneMail(String ruleId, String receiverId, long noticeInterval);

    /**
     * 根据ruled_id查询在noticeInterval时间内最新一条成功发送微信日志信息
     */
    TMonitLog findMonitLogByRuleIdLastOneWeChat(String ruleId, long noticeInterval);

    /**
     * 根据ruled_id查询在当天内最新一条成功发送微信日志信息
     */
    TMonitLog findMonitLogByRuleIdTodayWeChat(String ruleId);

    /**
     * 根据ruled_id和receiver_id查询在noticeInterval时间内最新一条成功发送短信日志信息
     */
    TMonitLog findMonitLogByRuleIdLastOneTelephone(String ruleId, String receiverId, long noticeInterval);

    /**
     * 根据ruled_id和receiver_id查询在当天内最新一条成功发送短信日志信息
     */
    TMonitLog findMonitLogByRuleIdTodayTelephone(String ruleId, String receiverId);

    /**
     * 根据ruled_id查询在noticeInterval时间段的日志信息(查询receiver_id为null的那条)
     */
    List<TMonitLog> findMonitLogListByRuleIdAndInterval(String ruleId, long noticeInterval);
}
