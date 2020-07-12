package com.mzl.service.impl;

import com.mzl.mapper.FinancialAnalysisMapper;
import com.mzl.service.FinacialAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @ClassName :   FinacialAnalysisServiceImpl
 * @Description: 财务分析实现类
 * @Author: 21989
 * @CreateDate: 2020/7/5 10:53
 * @Version: 1.0
 */
@Service
@Transactional
public class FinacialAnalysisServiceImpl implements FinacialAnalysisService {

    //注入依赖
    @Autowired
    private FinancialAnalysisMapper financialAnalysisMapper;

    //月收入的记录数
    @Override
    public int findMonthIncomeRecordCount(Map<String, String> paramMap) {
        return financialAnalysisMapper.findMonthIncomeRecordCount(paramMap);
    }

    //月支出的记录数
    @Override
    public int findMonthSpendRecordCount(Map<String, String> paramMap) {
        return financialAnalysisMapper.findMonthSpendRecordCount(paramMap);
    }

    //月收入总金额
    @Override
    public int findMonthIncomeMoney(Map<String, String> paramMap) {
        return financialAnalysisMapper.findMonthIncomeMoney(paramMap);
    }

    //月的支出总额
    @Override
    public int findMonthSpendMoney(Map<String, String> paramMap) {
        return financialAnalysisMapper.findMonthSpendMoney(paramMap);
    }


}
