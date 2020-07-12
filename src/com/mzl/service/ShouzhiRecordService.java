package com.mzl.service;

import com.mzl.pojo.*;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName :   ShouzhiRecordService
 * @Description: 收支记录接口
 * @Author: 21989
 * @CreateDate: 2020/6/18 17:16
 * @Version: 1.0
 */
public interface ShouzhiRecordService {

    //查询账单明细
    PageBean<ShouzhiRecord> findShouzhiRecord(int currentPage, User user, ShouzhiRecord shouzhiRecord);

    //根据id查询收支记录信息
    ShouzhiRecord findShouzhiRecordById(Map<String, Integer> map);

    //修改用户收支信息
    void editShouzhiRecord(ShouzhiRecord shouzhiRecord);

    //删除用户收支信息（一条）
    void deleteOneShouzhiRecord(int id);

    //批量删除用户收支信息
    void deleteBatchShouzhiRecord(String id);

    //通过收支类别id 查询是收入 还是 支出
    String findParentCategoryById(int szcid);

    //添加收入记账
    void addShouzhiRecord(ShouzhiRecord shouzhiRecord);

    //每个月的收入，支出统计每个月的收入
    List<MonthCount> findYearInMonthCountIncome(Map<String, String> paramMap);

    //每个月的收入，支出统计每个月的支出   月：金额
    List<MonthCount> findYearInMonthCountSpend(Map<String, String> paramMap);

    //一年中各种收入类型的统计
    List<MonthCount> findYearInCategoryCountIncome(Map<String, String> paramMap);

    //一年中各种支出类型的统计
    List<MonthCount> findInCategoryCountSpends(Map<String, String> paramMap);

    //一个月中收入的各种类型统计
    List<DayCount> findMonthInCatagoryCountIncome(Map<String, String> paramMap);

    //一个月中支出各种类型的情况
    List<DayCount> findMonthInCategoryCountSpend(Map<String, String> paramMap);

    //某一年某个月中的所有天的收入统计  天：金额
    List<DayCount> findMonthInDayCountIncome(Map<String, String> paramMap);

    //某一年某个月中的所有天的支出统计  天：金额
    List<DayCount> findMonthInDayCountSpend(Map<String, String> paramMap);

    //某天的某个时间段的收入统计
    List<DayCount> findDayInTimeCountIncome(Map<String, String> paramMap);

    //某天的某个时间段的支出统计
    List<DayCount> findDayInTimeCountSpend(Map<String, String> paramMap);
}
