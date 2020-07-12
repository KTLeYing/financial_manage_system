package com.mzl.utils;

import org.springframework.mail.javamail.MimeMailMessage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

/**
 * @ClassName :   EmailCodeUtil
 * @Description: 邮箱验证码工具类
 * @Author: 21989
 * @CreateDate: 2020/7/11 10:26
 * @Version: 1.0
 */
public class EmailCodeUtil {
    /**
     *  创建一封邮件(发件人、收件人、邮件内容)
     * @param session
     * @param sendMail
     * @param receiveMail
     * @param html
     * @return
     * @throws MessagingException
     * @throws IOException
     * cc:抄送
     * Bcc:密送
     * To:发送
     */

    //发件人的邮箱，你自己的
    private String emailFrom = "2198902814@qq.com";
    //发件人的授权码
    private String emailPassword = "jrbqchuoppzaecdg";
    //发送邮件服务地址
    private String emailSMTPHost = "smtp.qq.com";
    //收件人的邮箱
    private String emailTo = "";


    //发送邮件对象，发送创建好的邮件内容
    public String sendEmail(String emailTo) throws IOException, MessagingException {
        //赋值收件人的邮箱
        this.emailTo = emailTo;
        //创建配置参数，用于连接邮件服务器的参数配置
        Properties properties = new Properties();
        //开启debug模式
        properties.setProperty("mail.debug", "true");
        //发送邮件需要身份验证
        properties.setProperty("mail.smtp.auth", "true");
        //设置服务器主机名
        properties.setProperty("mail.smtp.host", emailSMTPHost);
        //设置端口号，qq邮箱给出了两个端口号，但是465端口号不能用，可以使用587端口号
        properties.setProperty("mail.smtp.port", "587");
        //用户身份验证
        //此处是发件人的邮箱地址
        properties.setProperty("mail.user", emailFrom);
        //此处的发件的服务器密码
        properties.setProperty("mail.password", emailPassword);
        //发送邮件协议的名称
        properties.setProperty("mail.transport.protocol", "smtp");

        //构建授权信息，用于smtp的身份验证
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                //用户名和密码
                String userName = properties.getProperty("mail.user");
                String passowrd = properties.getProperty("mail.password");
                return new PasswordAuthentication(userName, passowrd);
            }
        };

        //根据邮件配置创建邮箱服务器会话， 用于和邮箱服务器交互
        Session session = Session.getInstance(properties, authenticator);
        //设置debug，查看发送的过程的bug信息
        session.setDebug(true);

        //s随机获位验证码
        String code = RandomUtil.getRandom();
        System.out.println("邮件验证码为：" + code);
        //创建HTML个式发送的邮件内容
        String htmlContent = HtmlTextUtil.htmlContent(code);
        System.out.println(htmlContent);
        //创建获取邮件对象，并处理邮件
        MimeMessage mimeMessage = createMimeMessage(session, emailFrom, emailTo, htmlContent);

        //根据session获取传输对象
        Transport transport = session.getTransport();
        //使用用户名和密码连接服务器，和发件人的真正邮箱必须一致，不然会发送不了，失败
        transport.connect(emailFrom, emailPassword);
        //发送邮件，发送到所有的收件人邮箱时
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        //发送邮件后，关闭传输对象
        transport.close();

        //返回内部真正的邮箱验证码
        return code;
    }

    //创建邮件对象，处理邮件的内容
    public MimeMessage createMimeMessage(Session session, String emailFrom, String emailTo, String htmlContent) throws MessagingException, IOException{
        //创建一封邮件对象
        MimeMessage mimeMessage = new MimeMessage(session);
        //设置发件人
        mimeMessage.setFrom(new InternetAddress(emailFrom, "【财务管理系统】", "UTF-8"));
        //设置收件人
        mimeMessage.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(emailTo, "", "UTF-8"));
        //设置邮件主题
        mimeMessage.setSubject("邮箱验证码", "UTF-8");
        //邮箱正文内容（此次使用HTML的格式内容）
        mimeMessage.setContent(htmlContent, "text/html; charset=UTF-8");
        //设置发送的时间
        mimeMessage.setSentDate(new Date());
        //保存设置
        mimeMessage.saveChanges();

        //将邮件保存到本地文件
//        OutputStream outputStream = new FileOutputStream("D://MyEmail" + UUID.randomUUID().toString() + ".eml");
//        mimeMessage.writeTo(outputStream);
//        outputStream.flush();
//        outputStream.close();

        return mimeMessage;
    }

}
