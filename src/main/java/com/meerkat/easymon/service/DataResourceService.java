package com.meerkat.easymon.service;

import com.meerkat.easymon.data.gen.model.TDatasource;
import org.springframework.stereotype.Service;

/**
 * Created by yjs on 2018/6/5.
 */
@Service
public interface DataResourceService {

    /**
     * 根据数据源ID获取数据源
     * @return List<TDatasource>
     */
    TDatasource findDatasourceById(Long id) ;
}
