package com.meerkat.easymon.service;

import com.meerkat.easymon.data.gen.model.TRuleReceiver;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/6/5.
 */
@Service
public interface RuleReceiverService {

    /**
     * 根据rule_id查找接收人列表
     */
    public List<TRuleReceiver> getRuleReceiverByRuleId(String ruleId);



}
