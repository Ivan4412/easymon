package com.meerkat.easymon.service.Impl;

import com.meerkat.easymon.common.Constant;
import com.meerkat.easymon.data.gen.dao.TMonitRuleMapper;
import com.meerkat.easymon.data.gen.model.TMonitRule;
import com.meerkat.easymon.data.gen.model.TMonitRuleExample;
import com.meerkat.easymon.service.MonitRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * author : yjs
 * createTime : 2018/6/5
 * description : 监控规则服务类
 * version : 1.0
 */
@Service
public class MonitRuleServiceImpl implements MonitRuleService{


	@Autowired
	TMonitRuleMapper tMonitRuleMapper;

    /**
     * 获取所有有效监控规则
	 * @return List<TMonitRule>
     */
	public List<TMonitRule> getAllValidMonitRule() {
		TMonitRuleExample example = new TMonitRuleExample();
		example.createCriteria().andIsVaildEqualTo(Constant.MONITRULE_ISVAILD);
		List<TMonitRule> list = tMonitRuleMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(list)) {
			return list;
		}else {
			return null;
		}
	}

	/**
	 * 获取所有监控规则
	 * @return List<TMonitRule>
	 */
	public List<TMonitRule> getAllMonitRule() {
		TMonitRuleExample example = new TMonitRuleExample();
		example.createCriteria();
		List<TMonitRule> list = tMonitRuleMapper.selectByExample(example);
		if(!CollectionUtils.isEmpty(list)) {
			return list;
		}else {
			return null;
		}
	}

}
