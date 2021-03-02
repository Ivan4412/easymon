package com.meerkat.easymon.service.Impl;

import com.meerkat.easymon.data.gen.dao.TReceiverMapper;
import com.meerkat.easymon.data.gen.model.TReceiver;
import com.meerkat.easymon.data.gen.model.TReceiverExample;
import com.meerkat.easymon.service.ReceiverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * author : yjs
 * createTime : 2018/6/5
 * description : 告警信息接收人服务类
 * version : 1.0
 */
@Service
public class ReceiverServiceImpl implements ReceiverService{

    @Autowired
    private TReceiverMapper tReceiverMapper;

    /**
     * 根据Id查找接收人
     */

    public TReceiver findReceiverById(String id){
        TReceiverExample example = new TReceiverExample();
        example.createCriteria().andReceiverIdEqualTo(id);
        List<TReceiver> list = tReceiverMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(list)) {
            return list.get(0);
        }else {
            return null;
        }
    }

}
