package com.meerkat.easymon.data.gen.dao;

import com.meerkat.easymon.data.gen.model.TCommonReq;
import com.meerkat.easymon.data.gen.model.TCommonReqExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TCommonReqMapper {
    int countByExample(TCommonReqExample example);

    int deleteByExample(TCommonReqExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TCommonReq record);

    int insertSelective(TCommonReq record);

    List<TCommonReq> selectByExampleWithRowbounds(TCommonReqExample example, RowBounds rowBounds);

    List<TCommonReq> selectByExample(TCommonReqExample example);

    TCommonReq selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TCommonReq record, @Param("example") TCommonReqExample example);

    int updateByExample(@Param("record") TCommonReq record, @Param("example") TCommonReqExample example);

    int updateByPrimaryKeySelective(TCommonReq record);

    int updateByPrimaryKey(TCommonReq record);
}