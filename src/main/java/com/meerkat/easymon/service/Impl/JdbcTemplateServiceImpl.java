package com.meerkat.easymon.service.Impl;

import com.meerkat.easymon.data.gen.model.TDatasource;
import com.meerkat.easymon.service.JdbcTemplateService;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * author : yjs
 * createTime : 2018/6/6
 * description : JdbcTemplate服务类
 * version : 1.0
 */
@Service
public class JdbcTemplateServiceImpl implements JdbcTemplateService {

    private JdbcTemplate jdbcTemplate;

    /**
     * 设置数据源
     * @param dataSource
     */
    @Override
    public void setDataSource(DriverManagerDataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /**
     * 设置数据源
     * @param dataSource
     */
    @Override
    public void setDataSource(TDatasource dataSource) {
        this.setDataSource(this.convert2DataSource(dataSource));
    }

    @Override
    public DriverManagerDataSource convert2DataSource(TDatasource tDatasource){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(tDatasource.getDriveClassName());
        dataSource.setUrl(tDatasource.getUrl());
        dataSource.setUsername(tDatasource.getUsername());
        dataSource.setPassword(tDatasource.getPassword());
        return dataSource;
    }

    @Override
    public <T> T execute(PreparedStatementCreator psc, PreparedStatementCallback<T> action) {
        return  jdbcTemplate.execute(psc,action);
    }

    @Override
    public <T> T execute(StatementCallback<T> action) {
        return  jdbcTemplate.execute(action);
    }

    @Override
    public void execute(String sql) {
        jdbcTemplate.execute(sql);
    }

    @Override
    public void update(String sql){
        jdbcTemplate.update(sql);
    }
    @Override
    public void update(String sql, Object... args){
        jdbcTemplate.update(sql, args);
    }
    @Override
    public void update(String sql, Object[] args, int[] argTypes){
        jdbcTemplate.update(sql, args, argTypes);
    }

    //批量处理
    @Override
    public void batchUpdate(String[] sql){
        jdbcTemplate.batchUpdate(sql);
    }


    @Override
    public void batchUpdate(String sql, List<Object[]> batchArgs){
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    //argTypes：指定batchArgs参数的类型，例如： Types.DATE, Types.VARCHAR
    @Override
    public void batchUpdate(String sql, List<Object[]> batchArgs, int[] argTypes){
        jdbcTemplate.batchUpdate(sql, batchArgs, argTypes);
    }

    //返回list集合，list里存放的是实体对象，不是map集合
    @Override
    public <T> List<T> queryForList(String sql, Class<T> elementType){
        return jdbcTemplate.queryForList(sql, elementType);
    }


    @Override
    public <T> List<T> queryForList(String sql, Object[] args, Class<T> elementType){
        return jdbcTemplate.queryForList(sql, args, elementType);
    }


    @Override
    public <T> List<T> queryForList(String sql, Class<T> elementType, Object... args){
        return jdbcTemplate.queryForList(sql, elementType, args);
    }

    //argTypes：指定args参数的类型，例如： Types.DATE, Types.VARCHAR
    @Override
    public <T> List<T> queryForList(String sql, Object[] args, int[] argTypes, Class<T> elementType){
        return jdbcTemplate.queryForList(sql, args, argTypes, elementType);
    }

    //返回list集合，list里存放的是map集合，不是实体对象
    @Override
    public List<Map<String, Object>> queryForList(String sql){
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public List<Map<String, Object>> queryForList(String sql, Object... args){
        return jdbcTemplate.queryForList(sql, args);
    }

    //argTypes：指定args参数的类型，例如： Types.DATE, Types.VARCHAR
    @Override
    public List<Map<String, Object>> queryForList(String sql, Object[] args, int[] argTypes){
        return jdbcTemplate.queryForList(sql, args, argTypes);
    }

    //返回map集合，不是实体对象
    @Override
    public Map<String, Object> queryMap(String sql){
        return jdbcTemplate.queryForMap(sql);
    }

    @Override
    public Map<String, Object> queryForMap(String sql, Object... args){
        return jdbcTemplate.queryForMap(sql, args);
    }


    //argTypes：指定传入参数的类型，例如： Types.DATE, Types.VARCHAR
    @Override
    public Map<String, Object> queryMap(String sql, Object[] args, int[] argTypes){
        return jdbcTemplate.queryForMap(sql, args, argTypes);
    }

    public void  query(String sql, RowCallbackHandler rch){
        jdbcTemplate.query(sql, rch);
    }

    //返回基本数据类型，如：String、Integer、Long
    @Override
    public <T> T queryObject(String sql, Class<T> requiredType){
        return jdbcTemplate.queryForObject(sql, requiredType);
    }

    @Override
    public <T> T queryForObject(String sql, Class<T> requiredType, Object... args){
        return jdbcTemplate.queryForObject(sql, requiredType, args);
    }

    @Override
    public <T> T queryObject(String sql, Object[] args, Class<T> requiredType){
        return jdbcTemplate.queryForObject(sql, args, requiredType);
    }

    //argTypes：指定args参数的类型，例如： Types.DATE, Types.VARCHAR
    @Override
    public <T> T queryObject(String sql, Object[] args, int[] argTypes, Class<T> requiredType){
        return jdbcTemplate.queryForObject(sql, args, argTypes, requiredType);
    }

    //返回实体对象,不是map集合
    @Override
    public <T> T queryObject(String sql, RowMapper<T> rowMapper){
        return jdbcTemplate.queryForObject(sql, rowMapper);
    }

    @Override
    public <T> T queryObject(String sql, Object[] args, RowMapper<T> rowMapper){
        return jdbcTemplate.queryForObject(sql, args, rowMapper);
    }

    @Override
    public <T> T queryForObject(String sql, RowMapper<T> rowMapper, Object... args){
        return jdbcTemplate.queryForObject(sql, rowMapper, args);
    }

    //argTypes：指定args参数的类型，例如： Types.DATE, Types.VARCHAR
    @Override
    public <T> T queryForObject(String sql, Object[] args, int[] argTypes, RowMapper<T> rowMapper){
        return jdbcTemplate.queryForObject(sql, args, argTypes, rowMapper);
    }

    @Override
    public SqlRowSet queryForRowSet(String sql){
        return jdbcTemplate.queryForRowSet(sql);
    }

}
