package com.ljw.blog.common.vo;

import lombok.Data;

import java.util.Properties;

/**
 * @author: lujunwei
 * @time: 15:53 2019/4/26
 * @des:
 */
@Data
public class MailInfo {

    //发送邮件的服务器的IP和端口
    private String mailServerHost;
    private String mailServerPort = "25";
    //邮件发送者的地址
    private String fromAddress;
    //邮件接收者的地址
    private String toAddress;
    //邮件接收者的姓名
    private String toUserName;
    //登陆邮件发送服务器的用户名和密码
    private String userName;
    private String password;
    //是否需要身份验证
    private boolean validate = false;
    //邮件发送主题
    private String subject;
    //邮件的文本内容
    private String content;
    //邮件附件的文件名
    private String[] attachFileNames;

    /**
     * 获得邮件会话属性
     */
    public Properties getProperties() {
        Properties p = new Properties();
        p.put("mail.smtp.host", this.mailServerHost);
        p.put("mail.smtp.port", this.mailServerPort);
        p.put("mail.smtp.auth", validate ? "true" : "false");
        p.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        p.setProperty("mail.smtp.socketFactory.port", "465");
        p.setProperty("mail.smtp.port", "465");
        return p;
    }

}