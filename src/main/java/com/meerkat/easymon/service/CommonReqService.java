package com.meerkat.easymon.service;

import com.meerkat.easymon.data.gen.model.TCommonReq;
import org.springframework.stereotype.Service;

/**
 * author : yjs
 * createTime : 2018/7/25
 * description :
 * version : 1.0
 */
@Service
public interface CommonReqService {
    /**
     * 记录接口请求
     */
    boolean insert(TCommonReq tCommonReq);
}
