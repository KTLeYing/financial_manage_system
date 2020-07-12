package com.mzl.mapper;

import java.util.Map;

/**
 * @InterfaceName :   FinancialAnalysisMapper
 * @Description: 财务分析
 * @Author: 21989
 * @CreateDate: 2020/7/5 11:19
 * @Version: 1.0
 */
public interface FinancialAnalysisMapper {

    //月收入的记录数
    int findMonthIncomeRecordCount(Map<String, String> paramMap);

    //月支出的记录数
    int findMonthSpendRecordCount(Map<String, String> paramMap);

    //月收入总金额
    int findMonthIncomeMoney(Map<String, String> paramMap);

    //月的支出总额
    int findMonthSpendMoney(Map<String, String> paramMap);
}
