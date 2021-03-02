package com.meerkat.easymon.service.Impl;

import com.meerkat.easymon.data.gen.dao.TRuleReceiverMapper;
import com.meerkat.easymon.data.gen.model.TRuleReceiver;
import com.meerkat.easymon.data.gen.model.TRuleReceiverExample;
import com.meerkat.easymon.service.RuleReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * author : yjs
 * createTime : 2018/6/5
 * description : 监控规则接收人映射服务类
 * version : 1.0
 */
@Service
public class RuleReceiverServiceImpl implements RuleReceiverService {

    @Autowired
    private TRuleReceiverMapper tRuleReceiverMapper;

    /**
     * 根据rule_id查找接收人列表
     */
    public List<TRuleReceiver> getRuleReceiverByRuleId(String ruleId){
        TRuleReceiverExample example = new TRuleReceiverExample();
        example.createCriteria().andRuleIdEqualTo(ruleId);
        List<TRuleReceiver> list = tRuleReceiverMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(list)) {
            return list;
        }else {
            return null;
        }
    }

}
