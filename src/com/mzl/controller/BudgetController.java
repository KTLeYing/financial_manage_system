package com.mzl.controller;

import com.mzl.pojo.Budget;
import com.mzl.pojo.User;
import com.mzl.service.BudgetService;
import com.mzl.service.impl.BudgetServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * @ClassName :   BudgetController
 * @Description: 预算控制器
 * @Author: 21989
 * @CreateDate: 2020/7/5 21:16
 * @Version: 1.0
 */
@Controller
@RequestMapping("/budget")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    //根据当前时间和当前用户id来查询预算，进行显示预算相关的数据
    @RequestMapping("/findBudget.action")
    public String findBudget(HttpServletRequest request, Model model){
        //当前月份(xxxx-xx 年-月)
        String current = getCurrentTime();
        User user = (User) request.getSession().getAttribute("user");
        int uid = user.getUid();  //用户id
        Budget budget = new Budget();
        budget.setUser_id(uid);
        budget.setWtime(current);

        //查找当前月份是否存在预算
        Budget findBudget = budgetService.findBudget(budget);
        model.addAttribute("budget", findBudget);

        return "/jsp/financialBudget.jsp";
    }

    //添加预算
    @RequestMapping("/addBudget.action")
    @ResponseBody
    public String addBudget(Budget budget){
        //当前月份，格式化时间
        budget.setWtime(getCurrentTime());

        //添加预算
        budgetService.addBudget(budget);

        return "OK";
    }

    //编辑预算
    @RequestMapping("/editBudget.action")
    @ResponseBody
    public String editBudget(Budget budget){
        //编辑预算
        budgetService.editBudget(budget);

        return "OK";
    }

    //删除预算
    @RequestMapping("/deleteBudget.action")
    @ResponseBody
    public String deleteBudget(int wid){
        budgetService.deleteBudget(wid);

        return "OK";
    }



    //获取当前时间
    public String getCurrentTime(){
        Date tiem = new Date();
        DateFormat format = new SimpleDateFormat("YYYY-MM");
        String current = format.format(tiem);
        return current;
    }


}
