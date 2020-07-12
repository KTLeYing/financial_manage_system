package com.mzl.service;

import com.mzl.pojo.Budget;

/**
 * @InterfaceName :   BudgetService
 * @Description: 预算接口
 * @Author: 21989
 * @CreateDate: 2020/7/5 21:17
 * @Version: 1.0
 */
public interface BudgetService {

    //查找当前月份是否存在预算
    Budget findBudget(Budget budget);

    //添加预算
    void addBudget(Budget budget);

    //编辑预算
    void editBudget(Budget budget);

    //删除预算
    void deleteBudget(int wid);
}
