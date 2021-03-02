package com.meerkat.easymon.service;

import com.meerkat.easymon.data.gen.model.TReceiver;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author : yjs
 * createTime : 2019/7/4
 * description :
 * version : 1.0
 */
@Service
public interface WeChatService {

    /**
     *  通过企业微信群机器人发送消息
     * @param content  告警消息
     * @param receivers 接收人列表
     * @param weCharAddress 微信地址
     * @return
     */
     boolean sendText(String content, List<TReceiver> receivers, String weCharAddress);
}
