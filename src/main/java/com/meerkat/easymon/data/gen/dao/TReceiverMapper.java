package com.meerkat.easymon.data.gen.dao;

import com.meerkat.easymon.data.gen.model.TReceiver;
import com.meerkat.easymon.data.gen.model.TReceiverExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TReceiverMapper {
    int countByExample(TReceiverExample example);

    int deleteByExample(TReceiverExample example);

    int deleteByPrimaryKey(String receiverId);

    int insert(TReceiver record);

    int insertSelective(TReceiver record);

    List<TReceiver> selectByExampleWithRowbounds(TReceiverExample example, RowBounds rowBounds);

    List<TReceiver> selectByExample(TReceiverExample example);

    TReceiver selectByPrimaryKey(String receiverId);

    int updateByExampleSelective(@Param("record") TReceiver record, @Param("example") TReceiverExample example);

    int updateByExample(@Param("record") TReceiver record, @Param("example") TReceiverExample example);

    int updateByPrimaryKeySelective(TReceiver record);

    int updateByPrimaryKey(TReceiver record);
}