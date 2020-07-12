package com.mzl.mapper;

import com.mzl.pojo.DayCount;
import com.mzl.pojo.MonthCount;
import com.mzl.pojo.ShouzhiRecord;
import com.mzl.pojo.ShouzhiRecordQueryVo;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName :   ShouzhiRecordMapper
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/18 17:41
 * @Version: 1.0
 */
public interface ShouzhiRecordMapper {

    // 查询用户的收支明细记录数
    int findShouzhiRecordCount(Map<String, Object> map);

    //收支明细每页内容
    List<ShouzhiRecord> findCurrenPageRecordList(ShouzhiRecordQueryVo queryVo);

    //根据id查询收支记录信息
    ShouzhiRecord findShouzhiRecordById(Map<String, Integer> map);

    //修改用户收支信息
    void editShouzhiRecord(ShouzhiRecord shouzhiRecord);

    //删除用户收支信息（一条）
    void deleteOneShouzhiRecord(int id);

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
    List<MonthCount> findYearInCategoryCountSpends(Map<String, String> paramMap);

    //一个月中收入的各种类型统计
    List<DayCount> findMonthInCategoryIncome(Map<String, String> paramMap);

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
