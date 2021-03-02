package com.meerkat.easymon.service.Impl;

import com.meerkat.easymon.common.Constant;
import com.meerkat.easymon.data.gen.dao.TConfigurationMapper;
import com.meerkat.easymon.data.gen.model.TConfiguration;
import com.meerkat.easymon.data.gen.model.TConfigurationExample;
import com.meerkat.easymon.service.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * author : yjs
 * createTime : 2019/11/19
 * description : 配置参数服务类
 * version : 1.0
 */
@Service
public class ConfigurationServiceImpl implements ConfigurationService {

    @Autowired
    private TConfigurationMapper tConfigurationMapper;

    /**
     * 根据Id查找配置
     */
    @Override
    public TConfiguration findConfigurationById(Long id) {
        TConfigurationExample example = new TConfigurationExample();
        example.createCriteria().andIdEqualTo(id);
        List<TConfiguration> list = tConfigurationMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        } else {
            return null;
        }
    }

    /**
     * 根据Name查找配置
     */
    @Override
    public TConfiguration findConfigurationVaildByName(String name) {
        TConfigurationExample example = new TConfigurationExample();
        example.createCriteria().andNameEqualTo(name).andIsVaildEqualTo(Constant.CONFIGURATION_ISVAILD);
        List<TConfiguration> list = tConfigurationMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        } else {
            return null;
        }
    }

}
