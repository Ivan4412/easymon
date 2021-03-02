package com.meerkat.easymon.data.gen.dao;

import com.meerkat.easymon.data.gen.model.TRuleReceiver;
import com.meerkat.easymon.data.gen.model.TRuleReceiverExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TRuleReceiverMapper {
    int countByExample(TRuleReceiverExample example);

    int deleteByExample(TRuleReceiverExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TRuleReceiver record);

    int insertSelective(TRuleReceiver record);

    List<TRuleReceiver> selectByExampleWithRowbounds(TRuleReceiverExample example, RowBounds rowBounds);

    List<TRuleReceiver> selectByExample(TRuleReceiverExample example);

    TRuleReceiver selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TRuleReceiver record, @Param("example") TRuleReceiverExample example);

    int updateByExample(@Param("record") TRuleReceiver record, @Param("example") TRuleReceiverExample example);

    int updateByPrimaryKeySelective(TRuleReceiver record);

    int updateByPrimaryKey(TRuleReceiver record);
}