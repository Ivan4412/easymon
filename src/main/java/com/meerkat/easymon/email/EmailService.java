package com.meerkat.easymon.email;

import org.springframework.stereotype.Service;

/**
 * author : yjs
 * createTime : 2018/6/7
 * description : 邮件消息服务类
 * version : 1.0
 */
@Service
public interface EmailService {
    /**
     * 发送邮件消息
     * @param address
     * @param title
     * @param content
     * @return
     */
    String sendEmail(String address, String title, String content);
}
