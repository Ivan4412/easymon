package com.meerkat.easymon.service.Impl;

import com.meerkat.easymon.data.gen.dao.TCommonReqMapper;
import com.meerkat.easymon.data.gen.model.TCommonReq;
import com.meerkat.easymon.service.CommonReqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * author : yjs
 * createTime : 2018/7/25
 * description : 第三方接口请求服务类
 * version : 1.0
 */
@Service
public class CommonReqServiceImpl implements CommonReqService {


    @Autowired
    private TCommonReqMapper tCommonReqMapper;

    /**
     * 记录接口请求
     */
    public boolean insert(TCommonReq tCommonReq){
        Date date = new Date();
        tCommonReq.setCreatedTime(date);
        return tCommonReqMapper.insert(tCommonReq) > 0;
    }


}
