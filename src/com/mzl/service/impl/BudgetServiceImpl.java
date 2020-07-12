package com.mzl.service.impl;

import com.mzl.mapper.BudgetMapper;
import com.mzl.pojo.Budget;
import com.mzl.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName :   BudgetServiceImpl
 * @Description: 预算实现接口
 * @Author: 21989
 * @CreateDate: 2020/7/5 21:18
 * @Version: 1.0
 */
@Service
@Transactional
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    private BudgetMapper budgetMapper;

    //查找当前月份是否存在预算
    @Override
    public Budget findBudget(Budget budget) {
        return budgetMapper.findBudget(budget);
    }

    //添加预算
    @Override
    public void addBudget(Budget budget) {
        budgetMapper.addBudget(budget);
    }

    //编辑预算
    @Override
    public void editBudget(Budget budget) {
        budgetMapper.editBudget(budget);
    }

    //删除预算
    @Override
    public void deleteBudget(int wid) {
        budgetMapper.deleteBudget(wid);
    }


}
