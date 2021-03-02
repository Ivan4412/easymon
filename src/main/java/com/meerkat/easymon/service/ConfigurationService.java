package com.meerkat.easymon.service;

import com.meerkat.easymon.data.gen.model.TConfiguration;
import org.springframework.stereotype.Service;

/**
 * author : yjs
 * createTime : 2019/11/19
 * description :
 * version : 1.0
 */
@Service
public interface ConfigurationService {
    /**
     * 根据Id查找配置
     *
     * @param id
     * @return
     */
    TConfiguration findConfigurationById(Long id);

    /**
     * 根据Name查找配置
     *
     * @param name
     * @return
     */
    TConfiguration findConfigurationVaildByName(String name);
}
