package com.meerkat.easymon.service;

import com.meerkat.easymon.data.gen.model.TMonitRule;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lenovo on 2018/6/5.
 */
@Service
public interface MonitRuleService {

	/**
	 * 获取所有有效监控规则
	 * @return List<TMonitRule>
	 */
	public List<TMonitRule> getAllValidMonitRule() ;

	/**
	 * 获取所有监控规则
	 * @return List<TMonitRule>
	 */
	public List<TMonitRule> getAllMonitRule();

}
