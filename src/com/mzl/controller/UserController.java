package com.mzl.controller;

import com.mzl.pojo.User;
import com.mzl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @ClassName :   UserController
 * @Description: 用户控制器
 * @Author: 21989
 * @CreateDate: 2020/6/5 16:24
 * @Version: 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //用户登录
    @RequestMapping("login.action")
    public String login(User user, HttpServletRequest request, String checkCode){
        System.out.println("用户名和密码："+user.getUsername()+" "+user.getPassword());
        System.out.println(checkCode);

        //获取checkcode会话
        String checkCode1 = (String) request.getSession().getAttribute("checkCode");
        System.out.println(checkCode1);

        //判断验证码是否正确(忽略大小写)
        if (checkCode.equalsIgnoreCase(checkCode1)){//验证码相同
            //获得用户名和密码，判断是否存在
            User findUser = userService.queryUserByUser(user);
            if (findUser != null){
                System.out.println("查找的用户名和密码："+findUser.getUsername()+"::"+findUser.getPassword());
            }
            System.out.println("");
            //1.存在，保存到session中  ； 然后   跳转到主页面
            if (findUser != null){
                HttpSession session = request.getSession();
                session.setAttribute("user", findUser);
                //通过父类型，从而查询出该父类型的所有子类型，从而进行显示
                //List<String> son=shouzhiCategoryService.findSonCategoryByParent(parent_category);
                //查询账单明细
                return "redirect:/shouzhiRecord/findShouzhiRecord.action";

                //return "/jsp/main.jsp";//跳转到主页
            }else {
                //2.不存在，返回登录失败信息
                String msg="用户名或者密码输入错误，请重新输入";
                request.setAttribute("msg", msg);
                //跳转到登录页面
                return "/index.jsp";
            }
        }else {//验证码不同，输入验证码错误
            String msg = "验证码输入错误，请重新输入";
            request.setAttribute("msg", msg);
            //跳转到到登录页面
            return "/index.jsp";
        }
    }

    //用户注册（添加用户）
    @RequestMapping("regist.action")
    public String regist(User user, String repassword, String emailCode, HttpServletRequest request){
        System.out.println("emailCode:" + emailCode);
        //获取验证码session（真正正确生成的验证码）
        String emailCode1 = (String) request.getSession().getAttribute("emailCode");
        System.out.println("emailCode1:" + emailCode1);

        //先判断验证码是否正确（忽略大小写）
        if(emailCode.equalsIgnoreCase(emailCode1)){//验证码正确
            //判断是否存在
            //通过用户名查询用户是否存在
            User findUser = userService.queryUserByUsername(user.getUsername());

            if (findUser != null){
                //存在
                request.setAttribute("msg", "当前用户已经存在，请重新输入用户名");
                request.setAttribute("user", user);//保存原来的输入数据
                request.setAttribute("repassword", repassword);

                //移除原来的验证码session，重新获取,发送一次验证码只能用一次
                request.getSession().removeAttribute("emailCode");

                //跳转返回到注册页面
                return "/regist.jsp";
            }else {
                //插入时，添加自增主键，所以此时的User中是有主键id的，即：有完整的user表的信息
                userService.insertUser(user);
                //直接跳转到主页面【自动登录】
                //注册完，之后保存登录信息
                HttpSession session = request.getSession();
                session.setAttribute("user", user);//保存登录信息

                //return "/jsp/main.jsp";//用户主页

                //跳转到去登录页面
//            return "/index.jsp";

                //移除原来的验证码session，重新获取,发送一次验证码只能用一次
                request.getSession().removeAttribute("emailCode");

                //跳转到去查询查询账单明细
                return "redirect:/shouzhiRecord/findShouzhiRecord.action";
            }
        }else {  //验证码错误
            request.setAttribute("msg", "邮箱验证码输入错误，请重新输入");
            request.setAttribute("user", user);//保存原来的输入数据
            request.setAttribute("repassword", repassword);

//            //移除原来的验证码session，重新获取,发送一次验证码只能用一次
//            request.getSession().removeAttribute("emailCode");

            //跳转返回到注册页面
            return "/regist.jsp";
        }
    }

    //通过用户名判断用户是否存在
    @RequestMapping(value="findUserByNameAndAjax.action",method= RequestMethod.POST)
    public @ResponseBody
    String findUserByNameAndAjax(@RequestBody User user){
        //@ResponseBody 返回将java对象转为json格式的数据
        //@RequestBody 获得json格式的数据转为java对象

        //通过用户名查询用户是否存在
        User findUser = userService.queryUserByUsername(user.getUsername());
        if(findUser != null){
            System.out.println("{\"name\":\"exit\"}");
            //存在
            return "{\"name\":\"exit\"}";//json格式
        }
        else{
            System.out.println("{\"name\":\"notexit\"}");
            return "{\"name\":\"notexit\"}";//不存在
        }
    }

    //修改密码（找回密码）
    @RequestMapping("updatePasswordByUsername.action")
    public  String updatePasswordByUsername(User user,HttpServletRequest request){
        userService.updatePasswordByUsername(user);
        request.setAttribute("msg", "密码修改成功，请登录");
        return "/index.jsp";
    }

    //用户退出
    @RequestMapping("logout.action")
    public String logout(HttpServletRequest request){
        //移除会话
        request.getSession().removeAttribute("user");
        //返回到登录页面
        return "/index.jsp";
    }

    //去用户设置页面
    @RequestMapping("/toUserSetting.action")
    public String toUserSetting(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        //设置user，用于回显用户信息
        request.setAttribute("user", user);
        request.setAttribute("oldusername", user.getUsername());
        return "/jsp/userSetting.jsp";
    }

    //编辑用户信息
    @RequestMapping("/editUser.action")
    public String editUser(User user, HttpServletRequest request, String oldusername){
        System.out.println("oldusername:" + oldusername);
        System.out.println("修改后的user信息：" + user);
        //判断修改后的用户号名是否存在
        String username = user.getUsername();
        System.out.println(username);

        //在页面设置页面已经通过js的ajax实现了用户名判空和判是否已存在，在此次再一次判空和判是否存在，保证数据的正确性
        //用户名不为空
        if (username != "" && username != null){
            if(!username.equals(oldusername)){//新用户名和旧用户名不一样
                //普安用户名是否已经存在
                User findUser = userService.queryUserByUsername(username);
                System.out.println(findUser);
                if (findUser == null){//用户名不存在
                    //进行修改用户信息
                    userService.editUser(user);
                    //重新设置user会话
                    request.getSession().setAttribute("user", user);
                    //重定向到系统的首页，收支记录页面,user的会话信息是已经更新了
                    return "redirect:/shouzhiRecord/findShouzhiRecord.action";
                }else {  //用户名已经存在
                    user.setUsername(findUser.getUsername());
                    //用户回显信息，没有修改成功，返回到用户信息页面
                    request.setAttribute("user", user);
                    request.setAttribute("oldusername", oldusername);
                    request.setAttribute("msg", "该用户已存在，请修改当前用户名");

                    //返回到用户设置页面
                    return "/jsp/userSetting.jsp";
                }
            }else {//新用户名和旧用户名一样
                //直接进行修改
                userService.editUser(user);
                //修改成功后，重新设置user会话
                request.getSession().setAttribute("user", user);
                return "redirect:/shouzhiRecord/findShouzhiRecord.action";
            }
        }else {  //用户名为空
            request.setAttribute("msg", "用户名不能为空");
            request.setAttribute("oldusername", oldusername);
            request.setAttribute("user", user);
            //返回到用户设置页面
            return "/jsp/userSetting.jsp";
        }

    }



}
