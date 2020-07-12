package com.mzl.controller;

import com.alibaba.fastjson.JSON;
import com.mzl.pojo.DayCount;
import com.mzl.pojo.MonthAnalysis;
import com.mzl.service.FinacialAnalysisService;
import com.mzl.service.ShouzhiRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.crypto.MacSpi;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName :   FinancialAnalysisController
 * @Description: 财务分析
 * @Author: 21989
 * @CreateDate: 2020/7/5 10:49
 * @Version: 1.0
 */
@Controller
@RequestMapping("/financialAnalysis")
public class FinancialAnalysisController {

    //注入依赖
    @Autowired
    private FinacialAnalysisService finacialAnalysisService;
    @Autowired
    private ShouzhiRecordService shouzhiRecordService;

    //去财务分析页面
    @RequestMapping("toFinancialAnalysis.action")
    public String toFinancialAnalysis(){
        return "/jsp/financialAnalysis.jsp";
    }

    //月分析，选择的月和上一个月的比较分析
    @RequestMapping("monthAnalysis.action")
    @ResponseBody
    public String monthAnalysis(String currentTime, String lastTime, String  uid){
        //封装请求参数
        Map<String,String> paramMap = new HashMap<String, String>();
        paramMap.put("currentTime", currentTime);
        paramMap.put("user_id", uid);

        System.out.println(currentTime);
        System.out.println(lastTime);
        System.out.println(uid);

        //这个月收入的记录数
        int incomeRecordCount = finacialAnalysisService.findMonthIncomeRecordCount(paramMap);
        //这个月支出的记录数
        int spendsRecordCount = finacialAnalysisService.findMonthSpendRecordCount(paramMap);
        //这个月收入总金额
        int incomeMoney = finacialAnalysisService.findMonthIncomeMoney(paramMap);
        //这个月的支出总额
        int spendsMoney = finacialAnalysisService.findMonthSpendMoney(paramMap);

        System.out.println("这个月:");
        System.out.println(incomeRecordCount);
        System.out.println(spendsRecordCount);
        System.out.println(incomeMoney);
        System.out.println(spendsMoney);

        //总金额（收入 + 支出）
        int allMoney = incomeMoney + spendsMoney;

        //封装这个月分析的数据
        MonthAnalysis monthAnalysis = new MonthAnalysis();
        monthAnalysis.setIncomeRecordCount(incomeRecordCount);
        monthAnalysis.setSpendsRecordCount(spendsRecordCount);
        monthAnalysis.setIncomeMoney(incomeMoney);
        monthAnalysis.setSpendsMoney(spendsMoney);
        monthAnalysis.setAllMoney(allMoney);

        //上个月的数据
        Map<String, String> paramMap1 = new HashMap<String, String>();
        paramMap1.put("currentTime", lastTime);
        paramMap1.put("user_id", uid);

        //上个月的收入记录数
        int incomeRecordCount1 = finacialAnalysisService.findMonthIncomeRecordCount(paramMap1);
        //上个月的支出记录数
        int spendsRecordCount1 = finacialAnalysisService.findMonthSpendRecordCount(paramMap1);
        //上个月的收入金额
        int incomeMoney1 = finacialAnalysisService.findMonthIncomeMoney(paramMap1);
        //上个月的支出金额
        int spendsMoney1 = finacialAnalysisService.findMonthSpendMoney(paramMap1);
        //上个月的支出总金额
        int allMoney1 = incomeMoney1 + spendsMoney1;

        System.out.println("上个月:");
        System.out.println(incomeRecordCount1);
        System.out.println(spendsRecordCount1);
        System.out.println(incomeMoney1);
        System.out.println(spendsMoney1);

        //封装月分析数据
        MonthAnalysis monthAnalysis1 = new MonthAnalysis();
        monthAnalysis1.setIncomeRecordCount(incomeRecordCount1);
        monthAnalysis1.setSpendsRecordCount(spendsRecordCount1);
        monthAnalysis1.setIncomeMoney(incomeMoney1);
        monthAnalysis1.setSpendsMoney(spendsMoney1);
        monthAnalysis1.setAllMoney(allMoney1);

        //把这个月和上个月的数据封装成map
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("current", monthAnalysis);  //这个月
        map.put("last", monthAnalysis1);  //上个月

        String jsonString = JSON.toJSONString(map);
        System.out.println("json数据为：" + jsonString);

        return jsonString;  //携带json数据返回主页

    }

    //月的前时间内的分析
    @RequestMapping("/monthCurrentDayAnalysis.action")
    @ResponseBody
    public String monthCurrentDayAnalysis(String currentTimeDay, String lastTimeDay, String uid){
        //本月的数据
        System.out.println("请求的参数：");
        System.out.println(currentTimeDay);
        System.out.println(lastTimeDay);
        System.out.println(uid);

        int last = currentTimeDay.lastIndexOf("-"); //xxxx-xx-xx年-月-日
        System.out.println("last为：" + last);
        String currentStart = currentTimeDay.substring(0, last) + "-01";  //xxxx-xx-01
        System.out.println("currentStart为：" + currentStart);
        System.out.println("end为：" + currentTimeDay);

        //当前月的起始时间,参数的封装
        Map<String, String> currentParamMap = new HashMap<String, String>();
        currentParamMap.put("start", currentStart);
        currentParamMap.put("end", currentTimeDay);
        currentParamMap.put("user_id", uid);

        //这个月收入的各种类型及金额
        List<DayCount> incomes = shouzhiRecordService.findDayInTimeCountIncome(currentParamMap);
        //这个月支出的各种类型及金额
        List<DayCount> spends = shouzhiRecordService.findDayInTimeCountSpend(currentParamMap);

        //使用map把这个月的收入和支出的各种类型封装起来
        Map<String, Object> currentMap = new HashMap<String, Object>();
        currentMap.put("incomes", incomes);
        currentMap.put("spends", spends);

        System.out.println("currentMap:");
        System.out.println(incomes);
        System.out.println(spends);

        //上个月的数据
        int last1 = lastTimeDay.lastIndexOf("-"); //xxxx-xx-xx 年-月-日
        System.out.println("last1为：" + last1);
        String currentStart1 = lastTimeDay.substring(0, last1) + "-01"; //xxxx-xx-01
        System.out.println("currentStart1为：" + currentStart1);
        System.out.println("end1为：" + lastTimeDay);

        //当前月的起始时间,封装参数
        Map<String, String> currentParamMap1 = new HashMap<String, String>();
        currentParamMap1.put("start", currentStart1);
        currentParamMap1.put("end", lastTimeDay);
        currentParamMap1.put("user_id", uid);

        //上个月收入的各种类型及金额
        List<DayCount> incomes1 = shouzhiRecordService.findDayInTimeCountIncome(currentParamMap1);
        //上个月支出的各种类型及金额
        List<DayCount> spends1 = shouzhiRecordService.findDayInTimeCountSpend(currentParamMap1);

        Map<String, Object> lastMap = new HashMap<String, Object>();
        lastMap.put("incomes", incomes1);
        lastMap.put("spends", spends1);

        System.out.println("lastMap:");
        System.out.println(incomes1);
        System.out.println(spends1);

        //把这个月的map数据和上个月的map数据封装在一个大的map中，转为json
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("current", currentMap);
        map.put("last", lastMap);

        //转为json数据
        String jsonString = JSON.toJSONString(map);
        System.out.println("当前月和上一个月：" + jsonString);

        return jsonString; // 携带json数据返回给主页

    }




}
