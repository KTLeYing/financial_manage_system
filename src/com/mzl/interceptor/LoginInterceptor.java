package com.mzl.interceptor;

import com.mzl.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName :   LoginInterceptor
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/5 14:59
 * @Version: 1.0
 */
//登录拦截器
public class LoginInterceptor implements HandlerInterceptor {

    private List<String> exceptUrls;//放行的资源列

    public void setExceptUrls(List<String> exceptUrls) {
        this.exceptUrls = exceptUrls;
    }

    public List<String> getExceptUrls() {
        return exceptUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        // System.out.println("Interceptor1 preHandle........");
        // 执行的时机是在Handler执行之前执行此方法
        // 返回值：如果返回true，就放行，不拦截，正常执行Handler进行处理
        // 返回值：如果返回false，那就拦截，Handler就不能正常处理了(Handler就是后端的控制器接口controller)

        // 请求资源路径
        String requestUri = httpServletRequest.getRequestURI();
//		   /financialManage/memorandum/listMemorandum.action
		System.out.println("requestUri(请求资源路径，端口号后面的，即8080以后):"+requestUri);// 请求资源路径

		//   /financialManage
		System.out.println("request.getContextPath()（即项目名或项目的war的Exploded包名）:"+ httpServletRequest.getContextPath());//项目名

        if (requestUri.startsWith(httpServletRequest.getContextPath())) {// /financialManage
            requestUri = requestUri.substring(
                    httpServletRequest.getContextPath().length(), requestUri.length());
            System.out.println("处理后的requestUri请资源路径（项目名或项目的war的Exploded名后名的路径）:" + requestUri);
        }


//		  <value>/user/**</value>
//        <value>/index.jsp</value>
//        <value>/regist.jsp </value>

        // 放行exceptUrls中配置的url
        for (String url : exceptUrls) {
            System.out.println("被放行的原路径：" + url);
            if (url.endsWith("/**")) {
                if (requestUri.startsWith(url.substring(0, url.length() - 3))) {
                    System.out.println("放行的根路径（带/**）：" + url.substring(0, url.length() - 3));
                    return true;//放行
                }
            }
            else if (requestUri.startsWith(url)) {//与放行资源匹配
                System.out.println("放行的路径1（全路径）：" + url);
                return true;//放行
            }
        }

        // 1) 拦截用户请求，判断用户是否登录
        HttpSession session = httpServletRequest.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            return true;// 2) 如果用户已经登录。放行
        }
        System.out.println("你的请求将被拦截，因为你还没登录，请先去完成登录...");
        // 3) 如果用户未登录，跳转到登录页面，跳转的过程中有可能被拦截，所以得做一个判断
        httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/index.jsp");//登录页面
        return false;//拦截
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        // Handler执行之后，在返回ModelAndView之前，对modelAndView做些手脚
        // System.out.println("Interceptor1 postHandle........");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        // 返回ModelAndView之后
        // Handler执行过程中出现异常，可以在此处理异常
        // System.out.println("Interceptor1 afterCompletion........");
    }

}
