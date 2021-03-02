package com.meerkat.easymon.data.gen.dao;

import com.meerkat.easymon.data.gen.model.TMonitRule;
import com.meerkat.easymon.data.gen.model.TMonitRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TMonitRuleMapper {
    int countByExample(TMonitRuleExample example);

    int deleteByExample(TMonitRuleExample example);

    int deleteByPrimaryKey(String ruleId);

    int insert(TMonitRule record);

    int insertSelective(TMonitRule record);

    List<TMonitRule> selectByExampleWithRowbounds(TMonitRuleExample example, RowBounds rowBounds);

    List<TMonitRule> selectByExample(TMonitRuleExample example);

    TMonitRule selectByPrimaryKey(String ruleId);

    int updateByExampleSelective(@Param("record") TMonitRule record, @Param("example") TMonitRuleExample example);

    int updateByExample(@Param("record") TMonitRule record, @Param("example") TMonitRuleExample example);

    int updateByPrimaryKeySelective(TMonitRule record);

    int updateByPrimaryKey(TMonitRule record);
}