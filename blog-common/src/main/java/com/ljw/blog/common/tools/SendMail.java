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
        MailInfo mailInfo = new MailInfo();
        mailInfo.setToAddress("773517966@qq.com");
        mailInfo.setToUserName("陆军委,姜昆,王秀芬,王星星");
        mailInfo.setSubject("特殊邮件通知");
        // mailInfo.setContent("系统管理员\n    您好！您设定的 <定时任务自动备份数据库程序> 已经执行完毕，且已备份成功。\n 服务器备份路径: \n   /usr/share/nginx/html/backupDatabase/rbac_seurity_"+"2019-04-26"+".sql"+"\n   /usr/share/nginx/html/backupDatabase/blog-sbljdeh_"+"2019-04-26"+".sql");
        //mailInfo.setContent("\n   下载查看: <a href=http://lujunwei.com/backupDatabase/rbac_seurity_2019-10-27.sql>rbac_seurity_2019-10-27.sql</a>");
        mailInfo.setContent("<h4><p>系统管理员:<p>\n" +
                "<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您好！为了给予用户更友好的体验，今日因测试原因延误了23:00<font color='red'>定时任务自动备份数据库邮件通知</font>，特此在23:30补发。</p></h4>");
        SendMail.send163(mailInfo);
    }

    //163邮箱
    public static void send163(MailInfo mailInfo) {
        mailInfo.setMailServerHost("smtp.163.com");
        mailInfo.setMailServerPort("465");
        mailInfo.setValidate(true);
        mailInfo.setUserName(USER_NAME);//实际发送者
        mailInfo.setPassword(PASS_WORD);//您的邮箱密码
        mailInfo.setFromAddress(FROM_ADDRESS);//设置发送人邮箱地址
        mailInfo.setToAddress(mailInfo.getToAddress());
        mailInfo.setSubject(mailInfo.getSubject());//设置邮箱标题
        mailInfo.setContent(mailInfo.getContent());//设置邮箱内容
        mailInfo.setToUserName(mailInfo.getToUserName());
        SimpleMailSender sms=new SimpleMailSender();
        sms.sendHtmlMail(mailInfo);//发送文本格式

    }

}
