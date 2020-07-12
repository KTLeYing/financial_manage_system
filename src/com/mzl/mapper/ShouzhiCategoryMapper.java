package com.mzl.mapper;

import com.mzl.pojo.ShouzhiCategory;

import java.util.List;

/**
 * @InterfaceName :   ShouzhiCategoryMapper
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/18 18:30
 * @Version: 1.0
 */
public interface ShouzhiCategoryMapper {

    //通过父类型，从而查询出该父类型的所有子类型
    List<ShouzhiCategory> findShouzhiCategoryByParent(String parent_category);

    //通过父类型，从而查询出该父类型的所有子类型，从而进行显示
    List<String> findSonCategoryByParent(String parent_category);

    //根据收支子类型，获得收支分类id  对象
    ShouzhiCategory findCategoryBySonCategory(String son_category);

    //添加收支类型
    void addShouzhiCategory(ShouzhiCategory shouzhiCategory);
}
