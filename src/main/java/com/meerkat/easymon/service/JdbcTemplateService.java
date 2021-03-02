package com.meerkat.easymon.service;

import com.meerkat.easymon.data.gen.model.TDatasource;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * author : yjs
 * createTime : 2018/6/6
 * description : JdbcTemplate服务类
 * version : 1.0
 */
@Service
public interface JdbcTemplateService {

    public void setDataSource(DriverManagerDataSource dataSource);

    public void setDataSource(TDatasource dataSource);

    public DriverManagerDataSource convert2DataSource(TDatasource tDatasource);

    <T> T execute(PreparedStatementCreator psc, PreparedStatementCallback<T> action);

    <T> T execute(StatementCallback<T> action);

    void execute(String sql);

    public void update(String sql);

    public void update(String sql, Object... args);

    public void update(String sql, Object[] args, int[] argTypes);

    public void batchUpdate(String[] sql);

    public void batchUpdate(String sql, List<Object[]> batchArgs);

    public void batchUpdate(String sql, List<Object[]> batchArgs, int[] argTypes);

    public void  query(String  sql, RowCallbackHandler rch);

    public <T> List<T> queryForList(String sql, Class<T> elementType);

    public <T> List<T> queryForList(String sql, Object[] args, Class<T> elementType);

    public <T> List<T> queryForList(String sql, Class<T> elementType, Object... args);

    public <T> List<T> queryForList(String sql, Object[] args, int[] argTypes, Class<T> elementType);

    public List<Map<String, Object>> queryForList(String sql);

    public List<Map<String, Object>> queryForList(String sql, Object... args);

    public List<Map<String, Object>> queryForList(String sql, Object[] args, int[] argTypes);

    public Map<String, Object> queryMap(String sql);

    public Map<String, Object> queryForMap(String sql, Object... args);

    public Map<String, Object> queryMap(String sql, Object[] args, int[] argTypes);

    public <T> T queryObject(String sql, Class<T> requiredType);

    public <T> T queryForObject(String sql, Class<T> requiredType, Object... args);

    public <T> T queryObject(String sql, Object[] args, Class<T> requiredType);

    public <T> T queryObject(String sql, Object[] args, int[] argTypes, Class<T> requiredType);

    public <T> T queryObject(String sql, RowMapper<T> rowMapper);

    public <T> T queryObject(String sql, Object[] args, RowMapper<T> rowMapper);

    public <T> T queryForObject(String sql, RowMapper<T> rowMapper, Object... args);

    public <T> T queryForObject(String sql, Object[] args, int[] argTypes, RowMapper<T> rowMapper);

    public SqlRowSet queryForRowSet(String sql);

}
