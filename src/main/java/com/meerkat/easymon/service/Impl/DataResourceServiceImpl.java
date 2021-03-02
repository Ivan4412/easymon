package com.meerkat.easymon.service.Impl;

import com.meerkat.easymon.data.gen.dao.TDatasourceMapper;
import com.meerkat.easymon.data.gen.model.TDatasource;
import com.meerkat.easymon.data.gen.model.TDatasourceExample;
import com.meerkat.easymon.service.DataResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * author : yjs
 * createTime : 2018/6/5
 * description : 数据源服务类
 * version : 1.0
 */
@Service
public class DataResourceServiceImpl implements DataResourceService {

    @Autowired
    TDatasourceMapper tDatasourceMapper;

    /**
     * 根据数据源ID获取数据源
     * @return TDatasource
     */
    @Override
    public  TDatasource findDatasourceById(Long id) {
        TDatasourceExample example = new TDatasourceExample();
        example.createCriteria().andIdEqualTo(id);
        List<TDatasource> list = tDatasourceMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        }else {
            return null;
        }
    }
}
