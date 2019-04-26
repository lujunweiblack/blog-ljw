package com.ljw.blog.common.tools;

import com.ljw.blog.common.vo.MailInfo;

/**
 * @author: lujunwei
 * @time: 15:57 2019/4/26
 * @des:
 */
public class SendMail {

    private final static String USER_NAME = "lujunwei_black@163.com";
    private final static String PASS_WORD = "xtjyie3344";
    private final static String FROM_ADDRESS = "lujunwei_black@163.com";

    public static void main(String[] args) {
        SendMail.send_163();
    }

    //163邮箱
    public static void send_163() {
        //这个类主要是设置邮件
        MailInfo mailInfo=new MailInfo();
        mailInfo.setMailServerHost("smtp.163.com");
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);
        mailInfo.setUserName(USER_NAME);//实际发送者
        mailInfo.setPassword(PASS_WORD);//您的邮箱密码
        mailInfo.setFromAddress(FROM_ADDRESS);//设置发送人邮箱地址
        mailInfo.setToAddress("lujunwei@hyron.onaliyun.com,773517966@qq.com");
        mailInfo.setToUserName("陆军委,博主");
        mailInfo.setSubject("定时任务自动备份数据库邮件通知");
        mailInfo.setContent("系统管理员\n    您好！您的设定的 <定时任务自动备份数据库程序> 已经执行完毕，且已备份成功。\n 服务器备份路径: \n   /usr/share/nginx/html/backupDatabase/rbac_seurity_"+"2019-04-26"+".sql"+"\n   /usr/share/nginx/html/backupDatabase/blog-sbljdeh_"+"2019-04-26"+".sql");

        //这个类主要是用来发送邮件
        SimpleMailSender sms=new SimpleMailSender();
        sms.sendTextMail(mailInfo);//发送文本格式
        //sms.sendHtmlMail(mailInfo);//发送html格式:如果需要以html格式发送则需要处理好附件上传地址问题

    }

    //163邮箱
    public static void send163(MailInfo mailInfo) {
        mailInfo.setMailServerHost("smtp.163.com");
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);
        mailInfo.setUserName(USER_NAME);//实际发送者
        mailInfo.setPassword(PASS_WORD);//您的邮箱密码
        mailInfo.setFromAddress(FROM_ADDRESS);//设置发送人邮箱地址
        mailInfo.setToAddress(mailInfo.getToAddress());
        mailInfo.setSubject(mailInfo.getSubject());//设置邮箱标题
        mailInfo.setContent(mailInfo.getContent());//设置邮箱内容
        SimpleMailSender sms=new SimpleMailSender();
        sms.sendTextMail(mailInfo);//发送文本格式

    }

}
