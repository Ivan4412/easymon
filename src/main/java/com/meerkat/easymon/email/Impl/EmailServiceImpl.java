package com.meerkat.easymon.email.Impl;


import com.meerkat.easymon.config.Config;
import com.meerkat.easymon.email.EmailAutherticator;
import com.meerkat.easymon.email.EmailService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.Security;
import java.util.Date;
import java.util.Properties;

/**
 * author : yjs
 * createTime : 2018/6/7
 * description : 邮件消息服务类
 * version : 1.0
 */
@Service
public class EmailServiceImpl implements EmailService {

    /**
     * 日志信息
     */
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private Config config;

    @Override
    public String sendEmail(String address, String title, String content) {
        String result = "FAIL";
        try {
            send(address, title, content);
            result = "SUCCESS";
        } catch (Exception e) {
            result = e.getMessage();
        }

        log.info("Send email {} to {} result {}", content, address, result);
        return result;
    }


    private void send(String emailAddress, String title, String content) throws Exception {

        String subject = title;
        String body = content;
        String to = emailAddress;
        String host = config.getEmailHost();
        String from = config.getEmailFrom();
        String nick = config.getEmailFromName();
        String port = config.getEmailPort();

        EmailAutherticator auth = new EmailAutherticator();
        auth.setUsername(config.getEmailAddress());
        auth.setPassword(config.getEmailPassword());

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");

        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.port", port);
        props.setProperty("mail.smtp.socketFactory.port", port);

        Session session = Session.getDefaultInstance(props, auth);
        MimeMessage message = new MimeMessage(session);
        message.setContent("Hello", "text/plain");
        log.debug("mail：subject={}", subject);
        message.setSubject(subject, "utf-8");// 设置邮件主题
        message.setSentDate(new Date());// 设置邮件发送时间
        Address address = new InternetAddress(from, nick, "utf-8");

        message.setFrom(address);// 设置邮件发送者的地址
        Address toaddress = new InternetAddress(to);// 设置邮件接收者的地址
        message.addRecipient(Message.RecipientType.TO, toaddress);
        // 创建一个包含HTML内容的MimeBodyPart
        Multipart mainPart = new MimeMultipart();
        BodyPart html = new MimeBodyPart();
        html.setContent(body, "text/html; charset=utf-8");
        mainPart.addBodyPart(html);
        // 将MiniMultipart对象设置为邮件内容
        message.setContent(mainPart);
        //发送消息
       Transport.send(message);
    }

}
