package com.ljw.blog.common.tools;


import com.ljw.blog.common.vo.MailInfo;
import lombok.extern.slf4j.Slf4j;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

/**
 * @author: lujunwei
 * @time: 15:58 2019/4/26
 * @des:
 */
@Slf4j
public class SimpleMailSender {
    /**
     * 以文本格式发送邮件
     *
     * @param mailInfo 代发送的邮件的信息
     */

    public boolean sendTextMail(MailInfo mailInfo) {
        //判断是否需要身份认证
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        if (mailInfo.isValidate()) {
            //如果需要身份认证；则创建一个密码验证器
            authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        //根据邮件会话属性和密码验证器构造一个邮件发送的session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        try {
            //    根据session 创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            //创建邮件发送者地址
            Address from = new InternetAddress(mailInfo.getFromAddress(), "傻不拉几的二哈", "UTF-8");
            //设置邮件消息的发送者
            mailMessage.setFrom(from);

            //创建邮件的接受者地址；并设置到邮件消息中
            //Message.RecipientType.TO表示接收者的类型为TO
            String[] toAddresss = mailInfo.getToAddress().split(",");
            String[] toUserNames = mailInfo.getToUserName().split(",");
            InternetAddress[] internetAddresses = new InternetAddress[toAddresss.length];
            for (int i = 0; i < toAddresss.length; i++) {
                internetAddresses[i] = new InternetAddress(toAddresss[i], toUserNames[i], "UTF-8");
            }

            mailMessage.addRecipients(Message.RecipientType.TO, internetAddresses);

            //设置邮件消息的主题
            mailMessage.setSubject(mailInfo.getSubject());
            //设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            //设置邮件消息的主要内容
            String mailContent = mailInfo.getContent();
            mailMessage.setText(mailContent);
            //发送邮件
            log.info("=============== Start sending mail... ===============");
            log.info("=============== ["+mailInfo.getToAddress()+"] ===============");
            log.info("=============== ["+mailInfo.getToUserName()+"] ===============");
            Transport.send(mailMessage);
            log.info("=============== Successful mail delivery ===============");

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            log.info("=============== Mail Delivery Failed ===============");
        }
        return false;
    }


    /***
     * 以HTML格式发送邮件
     * @param mailInfo
     *     待发送的邮件信息
     */
    public boolean sendHtmlMail(MailInfo mailInfo) {
        //判断是否需要身份认证
        MyAuthenticator authenticator = null;
        Properties pro = mailInfo.getProperties();
        //如果需要身份认证；则创建一个密码验证器
        if (mailInfo.isValidate()) {
            authenticator = new MyAuthenticator(mailInfo.getUserName(), mailInfo.getPassword());
        }
        //根据邮件会话属性和密码验证器构造一个邮件发送的session
        Session sendMailSession = Session.getDefaultInstance(pro, authenticator);
        try {
            //    根据session 创建一个邮件消息
            Message mailMessage = new MimeMessage(sendMailSession);
            //创建邮件发送者地址
            Address from = new InternetAddress(mailInfo.getFromAddress(), "傻不拉几的二哈", "UTF-8");
            //设置邮件消息的发送者
            mailMessage.setFrom(from);

            //创建邮件的接受者地址；并设置到邮件消息中
            //Message.RecipientType.TO表示接收者的类型为TO
            String[] toAddresss = mailInfo.getToAddress().split(",");
            String[] toUserNames = mailInfo.getToUserName().split(",");
            InternetAddress[] internetAddresses = new InternetAddress[toAddresss.length];
            for (int i = 0; i < toAddresss.length; i++) {
                internetAddresses[i] = new InternetAddress(toAddresss[i], toUserNames[i], "UTF-8");
            }

            mailMessage.addRecipients(Message.RecipientType.TO, internetAddresses);
            //设置邮件消息的主题
            mailMessage.setSubject(mailInfo.getSubject());
            //设置邮件消息发送的时间
            mailMessage.setSentDate(new Date());
            //设置邮件消息的主要内容

            //MiniMultipart 类是一个容器 包含MimeBodyPart类型的对象
            Multipart mailPart = new MimeMultipart();
            //创建一个包含HTNL内容的MimeBodyPart
            BodyPart html = new MimeBodyPart();
            //设置HTML内容
            html.setContent(mailInfo.getContent(), "text/html;charset=utf-8");
            mailPart.addBodyPart(html);

            //s设置信件的附件（用本地上的文件作为附件）
            /**
             html=new MimeBodyPart();
             FileDataSource fds=new FileDataSource("");
             DataHandler dh=new DataHandler(fds);
             html.setFileName("");
             html.setDataHandler(dh);
             mailPart.addBodyPart(html);
             **/
            //将MiniMultipart对象设置为邮件内容
            mailMessage.setContent(mailPart);
            mailMessage.saveChanges();

            //发送邮件
            log.info("=============== Start sending mail... ===============");
            log.info("=============== ["+mailInfo.getToAddress()+"] ===============");
            log.info("=============== ["+mailInfo.getToUserName()+"] ===============");
            Transport.send(mailMessage);
            log.info("=============== Successful mail delivery ===============");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
