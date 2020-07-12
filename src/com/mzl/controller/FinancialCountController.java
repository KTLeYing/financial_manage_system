package com.mzl.controller;

import com.alibaba.fastjson.JSON;
import com.mzl.pojo.DayCount;
import com.mzl.pojo.MonthCount;
import com.mzl.pojo.User;
import com.mzl.service.ShouzhiRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.nio.cs.ext.MacArabic;

import java.sql.ResultSetMetaData;
import java.util.*;

/**
 * @ClassName :   FinancialCountController
 * @Description: 财务统计
 * @Author: 21989
 * @CreateDate: 2020/7/3 11:17
 * @Version: 1.0
 */
@Controller
public class FinancialCountController {

    //导入依赖
    @Autowired
    private ShouzhiRecordService shouzhiRecordService;

    //去财务统计的页面
    @RequestMapping("/toFinancialCount.action")
    public String toFinanciaCount(){
        return "/jsp/financialCount.jsp";
    }

    //每月的收入，支出统计
    @RequestMapping("/shouzhiRecord/yearInMonthCount.action")
    @ResponseBody    //json格式数据
    public String yearInMonthCount(String year, String uid){
        System.out.println(year);
        System.out.println(uid);
        //通过yearhe用户id进行查询，该用户这一年每个月的收支情况
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("year", year);
        //		User user = (User) request.getSession().getAttribute("user");
//		paramMap.put("user_id",user.getUid()+"");
        paramMap.put("user_id", uid);

        //每个月的收入，支出统计每个月的收入   月：金额
        List<MonthCount> incomes = shouzhiRecordService.findYearInMonthCountIncome(paramMap);
        System.out.println(incomes);
        //每个月的收入，支出统计每个月的支出   月：金额
        List<MonthCount> spends = shouzhiRecordService.findYearInMonthCountSpend(paramMap);
        System.out.println(spends);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("incomes", incomes);
        map.put("spends", spends);
        //转为json数据
        String jsonString = JSON.toJSONString(map);
        System.out.println("每个月收支统计结果：jsonString:\n" + jsonString);

        return jsonString;  //把json数据自动返回到主页，通过ajax异步请求自动返回
    }

    //一年12个月的不同类型的收入的统计
    @RequestMapping("/shouzhiRecord/yearInCategoryCount.action")
    @ResponseBody  //请求是以json格式的数据来提交请求
    public String yearInCategoryCount(String year, String uid){
        //通过year和用户uid来查询该用户这一年的收支情况
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("year", year);

        //		User user = (User) request.getSession().getAttribute("user");
//		paramMap.put("user_id",user.getUid()+"");

        paramMap.put("user_id", uid);

        //一年中各种收入类型的统计
        List<MonthCount> incomes = shouzhiRecordService.findYearInCategoryCountIncome(paramMap);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("incomes", incomes);
        //转为json数据
        String jsonString = JSON.toJSONString(map);
        System.out.println("各种类型的情况：jsonString:\n" + jsonString);

        return jsonString;  //返回json数据给主页
    }

    //一年中12个月大的不同的支出类型的统计
    @RequestMapping("/shouzhiRecord/yearInCategoryCountSpends.action")
    @ResponseBody   //json数据
    public String yearInCategoryCountSpends(String year, String uid){
        //通过year和uid来查询用户一年中各种支出类型的统计情况
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("year", year);

//        User user = (User)request.getSession().getAttribute("user");
//        paramMap.put("user_id", String.valueOf(user.getUid()));
        paramMap.put("user_id", uid);

        //一年中各种支出类型的统计
        List<MonthCount> spends = shouzhiRecordService.findInCategoryCountSpends(paramMap);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("spends", spends);
        //转为json格式数据
        String jsonString = JSON.toJSONString(map);
        System.out.println("各种类型的情况：jsonString:\n'" + jsonString);

        return jsonString;  //携带json数据返回到主页
    }

    //一个月的不同类型的收入
    @RequestMapping("/shouzhiRecord/monthInCategoryCountIncome.action")
    @ResponseBody
    public String monthInCategoryCountIncome(String currentTime, String uid){
        //处理currentTime
        String[] arr = currentTime.split("-");
        String year = arr[0];
        String month = arr[1];

        System.out.println(year);
        System.out.println(month);

        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("year", year);
        paramMap.put("month", month);
        paramMap.put("user_id", uid);

        //一个月中收入的各种类型统计
        List<DayCount> incomes = shouzhiRecordService.findMonthInCatagoryCountIncome(paramMap);

        //把数据库返回的list数组放到map中
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("incomes", incomes);

        //转为json数据
        String jsonString = JSON.toJSONString(map);
        System.out.println("每天各种收入的类型情况：" + jsonString);

        return jsonString;   //携带json数据返回主页
    }

    //一个月中的支出各种类型的情况
    @RequestMapping("/shouzhiRecord/monthInCategoryCountSpend.action")
    @ResponseBody
    public String monthInCategoryCountSpend(String currentTime, String uid){
        //分离时间的年和月
        String[] arr = currentTime.split("-");
        String year = arr[0];  //获取年
        String month = arr[1]; //获取月

        System.out.println(year);
        System.out.println(month);

        //封装请求参数在map里面
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("year", year);
        paramMap.put("month", month);
        paramMap.put("user_id", uid);

        //一个月中支出各种类型的情况
        List<DayCount> spends = shouzhiRecordService.findMonthInCategoryCountSpend(paramMap);

        //把数据库返回的数据封装在map中
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("spends", spends);

        //转为json数据
        String jsonString = JSON.toJSONString(map);
        System.out.println("每天各种支出类型情况：" + jsonString);

        return jsonString;
    }

    //一个月中收入和支出的对应各种类型的统计
    @RequestMapping("/shouzhiRecord/monthInCategoryCount.action")
    @ResponseBody
    public String monthInCategoryCount(String currentTime, String uid){
        System.out.println(currentTime);
        System.out.println(uid);
        //分离时间的年月（如：2020-07）
        String[] arr = currentTime.split("-");
        String year = arr[0];  //年份
        String month = arr[1];  //月份

        //封装参数
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("year", year);
        paramMap.put("month", month);
        paramMap.put("user_id", uid);

        //一个月的收入的各种类型
        List<DayCount> incomes = shouzhiRecordService.findMonthInCatagoryCountIncome(paramMap);
        List<DayCount> spends = shouzhiRecordService.findMonthInCategoryCountSpend(paramMap);
        System.out.println(incomes);
        System.out.println(spends);

        //把数据库返回的数据封装成map
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("incomes", incomes);
        map.put("spends", spends);

        //转为json数据
        String jsonString = JSON.toJSONString(map);
        System.out.println("某月的各种收支类型map：" + jsonString);

        return jsonString;  //携带json数据返回到主页
    }

    //每个月中的每天的收入和支出统计
    @RequestMapping("/shouzhiRecord/MonthInDayCount.action")
    @ResponseBody
    public String monthInDayCount(String currentTime, String uid){
        //分离日期
        String[] arr = currentTime.split("-");
        String year = arr[0];  //获取年份
        String month = arr[1]; //获取月份

        //封装请求参数
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("year", year);
        paramMap.put("month", month);
        paramMap.put("user_id", uid);

        //某一年某个月中的所有天的收入统计  天：金额
        List<DayCount> incomes = shouzhiRecordService.findMonthInDayCountIncome(paramMap);
        System.out.println(incomes);
        //某一年某个月中的所有天的支出统计  天：金额
        List<DayCount> spends = shouzhiRecordService.findMonthInDayCountSpend(paramMap);
        System.out.println(spends);

        //封装每天收入、支出的数据库返回的结果
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("incomes", incomes);
        map.put("spends", spends);

        //转为json格式
        String jsonString = JSON.toJSONString(map);
        System.out.println("每天的收支统计情况为：\n" + jsonString);

        return jsonString;   //携带json数据返回主页面
    }

    //某一年某个月某个时间的收入和支出的各种类型的统计
    @RequestMapping("/shouzhiRecord/dayInTimeCount.action")
    @ResponseBody
    public String dayInTimeCount(String start, String end, String uid){
        System.out.println(start);
        System.out.println(end);
        System.out.println(uid);
        //封装请求参数
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("start", start);
        paramMap.put("end", end);
        paramMap.put("user_id", uid);

        //某天的某个时间段的收入统计
        List<DayCount> incomes = shouzhiRecordService.findDayInTimeCountIncome(paramMap);
        System.out.println(incomes);
        //某天的某个时间段的支出统计
        List<DayCount> spends = shouzhiRecordService.findDayInTimeCountSpend(paramMap);
        System.out.println(spends);

        //封装数据库返回的数据
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("incomes", incomes);
        map.put("spends", spends);

        //转为jsonsj
        String jsonString = JSON.toJSONString(map);
        System.out.println("某个时间段收支统计为：\n" + jsonString);

        return jsonString;  //携带json数据返回主页
    }



}
