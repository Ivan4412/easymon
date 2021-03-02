package com.meerkat.easymon.service.Impl;

import com.meerkat.easymon.common.Constant;
import com.meerkat.easymon.data.gen.dao.TMonitLogMapper;
import com.meerkat.easymon.data.gen.model.TMonitLog;
import com.meerkat.easymon.data.gen.model.TMonitLogExample;
import com.meerkat.easymon.service.MonitLogService;
import com.meerkat.easymon.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * author : yjs
 * createTime : 2018/6/5
 * description : 监控信息日志服务类
 * version : 1.0
 */
@Service
public class MonitLogServiceImpl implements MonitLogService {


    @Autowired
    private TMonitLogMapper tMonitLogMapper;

    /**
     * 记录监控信息日志
     */
    @Override
    public boolean insert(TMonitLog monitLog) {
        Date date = new Date();
        monitLog.setCreatedTime(date);
        return tMonitLogMapper.insert(monitLog) > 0;
    }

    /**
     * 根据ruled_id查询日志信息
     */
    @Override
    public List<TMonitLog> findMonitLogByRuleId(String ruleId) {

        TMonitLogExample example = new TMonitLogExample();
        example.createCriteria().andRuleIdEqualTo(ruleId);
        List<TMonitLog> list = tMonitLogMapper.selectByExample(example);
        return list;
    }

    /**
     * 根据ruled_id和receiver_id查询最新一条日志信息
     */
    @Override
    public TMonitLog findMonitLogByRuleIdLastOne(String ruleId, String receiverId) {
        TMonitLogExample example = new TMonitLogExample();
        example.setOrderByClause("created_time desc");
        example.createCriteria().andRuleIdEqualTo(ruleId).andReceiverIdEqualTo(receiverId);
        List<TMonitLog> list = tMonitLogMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * 根据ruled_id查询最新一条日志信息
     */
    @Override
    public TMonitLog findMonitLogByRuleIdLastOneToday(String ruleId){
        TMonitLogExample example = new TMonitLogExample();
        example.setOrderByClause("created_time desc");
        example.createCriteria().andRuleIdEqualTo(ruleId).andReceiverIdIsNull().andCreatedTimeGreaterThan(DateUtil.getZeroDay());
        List<TMonitLog> list = tMonitLogMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * 根据ruled_id和receiver_id查询在noticeInterval时间内最新一条成功发送邮件日志信息
     */
    @Override
    public TMonitLog findMonitLogByRuleIdLastOneMail(String ruleId, String receiverId, long noticeInterval) {
        Date notifyTime = new Date(new Date().getTime() - noticeInterval);
        TMonitLogExample example = new TMonitLogExample();
        example.setOrderByClause("created_time desc");
        example.createCriteria().andRuleIdEqualTo(ruleId).andReceiverIdEqualTo(receiverId).andIsMailEqualTo(Constant.MONITLOG_ISMAIL).andCreatedTimeGreaterThan(notifyTime);
        List<TMonitLog> list = tMonitLogMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * 根据ruled_id查询在noticeInterval时间内最新一条成功发送微信日志信息
     */
    @Override
    public TMonitLog findMonitLogByRuleIdLastOneWeChat(String ruleId, long noticeInterval) {
        Date notifyTime = new Date(new Date().getTime() - noticeInterval);
        TMonitLogExample example = new TMonitLogExample();
        example.setOrderByClause("created_time desc");
        example.createCriteria().andRuleIdEqualTo(ruleId).andReceiverIdIsNull().andIsWechatEqualTo(Constant.MONITLOG_ISWECHAT).andCreatedTimeGreaterThan(notifyTime);
        List<TMonitLog> list = tMonitLogMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * 根据ruled_id查询在当天内最新一条成功发送微信日志信息
     */
    @Override
    public TMonitLog findMonitLogByRuleIdTodayWeChat(String ruleId) {
        Date notifyTime = DateUtil.getZeroDay();
        TMonitLogExample example = new TMonitLogExample();
        example.setOrderByClause("created_time desc");
        example.createCriteria().andRuleIdEqualTo(ruleId).andReceiverIdIsNull().andIsWechatEqualTo(Constant.MONITLOG_ISWECHAT).andCreatedTimeGreaterThan(notifyTime);
        List<TMonitLog> list = tMonitLogMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * 根据ruled_id和receiver_id查询在noticeInterval时间内最新一条成功发送短信日志信息
     */
    @Override
    public TMonitLog findMonitLogByRuleIdLastOneTelephone(String ruleId, String receiverId, long noticeInterval) {
        Date notifyTime = new Date(new Date().getTime() - noticeInterval);
        TMonitLogExample example = new TMonitLogExample();
        example.setOrderByClause("created_time desc");
        example.createCriteria().andRuleIdEqualTo(ruleId).andReceiverIdEqualTo(receiverId).andIsTelephoneEqualTo(Constant.MONITLOG_ISTELEPHONE).andCreatedTimeGreaterThan(notifyTime);
        List<TMonitLog> list = tMonitLogMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * 根据ruled_id和receiver_id查询在当天内最新一条成功发送短信日志信息
     */
    @Override
    public TMonitLog findMonitLogByRuleIdTodayTelephone(String ruleId, String receiverId) {
        Date notifyTime = DateUtil.getZeroDay();
        TMonitLogExample example = new TMonitLogExample();
        example.setOrderByClause("created_time desc");
        example.createCriteria().andRuleIdEqualTo(ruleId).andReceiverIdEqualTo(receiverId).andIsTelephoneEqualTo(Constant.MONITLOG_ISTELEPHONE).andCreatedTimeGreaterThan(notifyTime);
        List<TMonitLog> list = tMonitLogMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * 根据ruled_id查询在noticeInterval时间段的日志信息(查询receiver_id为null的那条)
     */
    @Override
    public  List<TMonitLog>  findMonitLogListByRuleIdAndInterval(String ruleId, long noticeInterval) {
        Date notifyTime = new Date(new Date().getTime() - noticeInterval);
        TMonitLogExample example = new TMonitLogExample();
        example.setOrderByClause("created_time desc");
        example.createCriteria().andRuleIdEqualTo(ruleId).andReceiverIdIsNull().andCreatedTimeGreaterThan(notifyTime);
        List<TMonitLog> list = tMonitLogMapper.selectByExample(example);
        return list;
    }

}
