package com.meerkat.easymon.service.Impl;

import com.meerkat.easymon.common.Constant;
import com.meerkat.easymon.config.Config;
import com.meerkat.easymon.data.gen.model.TCommonReq;
import com.meerkat.easymon.data.gen.model.TReceiver;
import com.meerkat.easymon.dto.WeChatResp;
import com.meerkat.easymon.job.AbstractJob;
import com.meerkat.easymon.service.CommonReqService;
import com.meerkat.easymon.service.ConfigurationService;
import com.meerkat.easymon.service.WeChatService;
import com.meerkat.easymon.util.HttpUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * author : yjs
 * createTime : 2019/7/4
 * description :
 * version : 1.0
 */
@Service
public class WeChatServiceImpl implements WeChatService {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(AbstractJob.class);

    //appid
    private static final String APP_ID = "weChat";

    @Autowired
    protected CommonReqService commonReqService;

    @Autowired
    protected ConfigurationService configurationService;

    @Autowired
    Config config;

    /**
     * 通过企业微信群机器人发送消息
     *
     * @param content   告警消息
     * @param receivers 接收人列表
     * @return
     */
    @Override
    public boolean sendText(String content, List<TReceiver> receivers, String weCharAddress) {

        if (CollectionUtils.isEmpty(receivers)) { //无微信通知人时，不通知
            log.debug("无微信消息接收人，不发送微信消息");
            return false;
        }

        if (StringUtils.isEmpty(weCharAddress)) {
            log.debug("无微信消息地址");
            return false;
        }

        JSONArray mentionedArray = new JSONArray(); //@相关人员
        JSONArray mentionedMobileArray = new JSONArray();//@电话对应相关人员
        for (TReceiver receiver : receivers) {
            mentionedArray.add(receiver.getReceiverName());
            mentionedMobileArray.add(receiver.getMobilePhone());
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msgtype", "text");
        JSONObject textObject = new JSONObject();

        textObject.put("content", content);

        if (mentionedArray.isEmpty()) {
            return false;
        }
        textObject.put("mentioned_list", mentionedArray);
        textObject.put("mentioned_mobile_list", mentionedMobileArray);
        jsonObject.put("text", textObject);

        //记录发送接口信息
        TCommonReq commonReq = new TCommonReq();
        commonReq.setAppId(APP_ID);
        commonReq.setInterfaceName("cgi-bin.webhook.send");
        commonReq.setReqContent(jsonObject.toString());

        try {
            String result = HttpUtil.sendPost(weCharAddress, jsonObject.toString());
            JSONObject resultObj = JSONObject.fromObject(result);
            //再将json对象转化为具体的类对象
            WeChatResp resp = (WeChatResp) JSONObject.toBean(resultObj, WeChatResp.class);

            if (resp != null && resp.getErrcode() == 0) {
                log.debug("发送微信消息成功");
                commonReq.setIsSuccess(Constant.COMMONREQ_SUCESS);
                commonReq.setRspContent("发送微信消息成功");
                commonReq.setReturnCode(Constant.SUCCERSS_CODE);
            } else {
                String errMessage = resp == null ? "发送微信消息异常" : (resp.getErrmsg() == null ? "" : resp.getErrmsg());
                log.error("发送微信消息失败:{}", errMessage);
                commonReq.setIsSuccess(Constant.COMMONREQ_FAIL);
                commonReq.setRspContent(errMessage);
                commonReq.setReturnCode(Constant.ERROR_CODE);
            }
        } catch (Exception e) {
            commonReq.setIsSuccess(Constant.COMMONREQ_FAIL);
            commonReq.setRspContent(e.getMessage());
            commonReq.setReturnCode(Constant.ERROR_CODE);
            log.error("发送微信消息失败:", e);
        }
        if (commonReq.getRspContent() != null && commonReq.getRspContent().length() > 2000) {
            commonReq.setRspContent(commonReq.getRspContent().substring(0, 2000));
        }
        commonReqService.insert(commonReq);

        return (commonReq.getIsSuccess() == Constant.COMMONREQ_SUCESS);
    }
}
