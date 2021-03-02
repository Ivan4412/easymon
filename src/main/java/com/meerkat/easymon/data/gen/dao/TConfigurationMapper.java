package com.meerkat.easymon.data.gen.dao;

import com.meerkat.easymon.data.gen.model.TConfiguration;
import com.meerkat.easymon.data.gen.model.TConfigurationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TConfigurationMapper {
    int countByExample(TConfigurationExample example);

    int deleteByExample(TConfigurationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TConfiguration record);

    int insertSelective(TConfiguration record);

    List<TConfiguration> selectByExampleWithRowbounds(TConfigurationExample example, RowBounds rowBounds);

    List<TConfiguration> selectByExample(TConfigurationExample example);

    TConfiguration selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TConfiguration record, @Param("example") TConfigurationExample example);

    int updateByExample(@Param("record") TConfiguration record, @Param("example") TConfigurationExample example);

    int updateByPrimaryKeySelective(TConfiguration record);

    int updateByPrimaryKey(TConfiguration record);
}