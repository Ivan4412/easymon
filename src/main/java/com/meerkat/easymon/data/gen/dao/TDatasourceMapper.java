package com.meerkat.easymon.data.gen.dao;

import com.meerkat.easymon.data.gen.model.TDatasource;
import com.meerkat.easymon.data.gen.model.TDatasourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TDatasourceMapper {
    int countByExample(TDatasourceExample example);

    int deleteByExample(TDatasourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TDatasource record);

    int insertSelective(TDatasource record);

    List<TDatasource> selectByExampleWithRowbounds(TDatasourceExample example, RowBounds rowBounds);

    List<TDatasource> selectByExample(TDatasourceExample example);

    TDatasource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TDatasource record, @Param("example") TDatasourceExample example);

    int updateByExample(@Param("record") TDatasource record, @Param("example") TDatasourceExample example);

    int updateByPrimaryKeySelective(TDatasource record);

    int updateByPrimaryKey(TDatasource record);
}