package com.meerkat.easymon.sms;

import org.springframework.stereotype.Service;

/**
 * author : yjs
 * createTime : 2018/6/7
 * description : 短信服务类
 * version : 1.0
 */
@Service
public interface SmsService {


	/**
	 * 本地发送消息
	 * 
	 * @param phone
	 * @param content
	 * @return
	 */
	String send(String phone, String content);

}
