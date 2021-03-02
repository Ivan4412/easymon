package com.meerkat.easymon.data.gen.dao;

import com.meerkat.easymon.data.gen.model.TMonitLog;
import com.meerkat.easymon.data.gen.model.TMonitLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TMonitLogMapper {
    int countByExample(TMonitLogExample example);

    int deleteByExample(TMonitLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TMonitLog record);

    int insertSelective(TMonitLog record);

    List<TMonitLog> selectByExampleWithRowbounds(TMonitLogExample example, RowBounds rowBounds);

    List<TMonitLog> selectByExample(TMonitLogExample example);

    TMonitLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TMonitLog record, @Param("example") TMonitLogExample example);

    int updateByExample(@Param("record") TMonitLog record, @Param("example") TMonitLogExample example);

    int updateByPrimaryKeySelective(TMonitLog record);

    int updateByPrimaryKey(TMonitLog record);
}