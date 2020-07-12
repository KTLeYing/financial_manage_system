package com.mzl.controller;

import com.mzl.utils.EmailCodeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName :   EmailCodeController
 * @Description: 邮箱验证码控制器(用于发送邮箱验证码)
 * @Author: 21989
 * @CreateDate: 2020/7/11 10:27
 * @Version: 1.0
 */
@Controller
public class EmailCodeController {

    //发送邮箱验证码
    @RequestMapping("/emailCode.action")
    public String emailCode(String email, HttpServletRequest request) throws IOException, MessagingException {
        System.out.println(email);
        //创建邮箱验证码的session会话对象
        HttpSession session = request.getSession();
        //发送新的验证码前，先移除之前的验证码session,保证每个验证码只能使用一次
        session.removeAttribute("emailCode");

        //开始处理发送邮件
        EmailCodeUtil emailCodeUtil = new EmailCodeUtil();
        String emailCode = emailCodeUtil.sendEmail(email);
        System.out.println(emailCode);

        //设置新的邮箱验证码session
        session.setAttribute("emailCode", emailCode);

        return "";
    }


}
