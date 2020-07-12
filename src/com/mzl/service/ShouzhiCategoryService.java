package com.mzl.service;

import com.mzl.pojo.ShouzhiCategory;

import java.util.List;

/**
 * @InterfaceName :   ShouzhiCategoryService
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/18 17:18
 * @Version: 1.0
 */
public interface ShouzhiCategoryService {

    //查询收入或者支出子类型   --通过父分类，从而查询其下的所有子分类
    List<ShouzhiCategory> findShouzhiCategoryByParent(String parent_category);

    //通过父类型，从而查询出该父类型的所有子类型，从而进行显示
    List<String> findSonCategoryByParent(String parent_category);

    //根据收支子类型，获得收支分类id  对象
    ShouzhiCategory findCategoryBySonCategory(String son_category);

    //添加收支类型
    void addShouzhiCategory(ShouzhiCategory shouzhiCategory);
}
