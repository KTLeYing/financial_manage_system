package com.mzl.service.impl;

import com.mzl.mapper.ShouzhiCategoryMapper;
import com.mzl.pojo.ShouzhiCategory;
import com.mzl.service.ShouzhiCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName :   ShouzhiCategoryServiceImpl
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/18 17:18
 * @Version: 1.0
 */
@Transactional
@Service
public class ShouzhiCategoryServiceImpl implements ShouzhiCategoryService {

    @Autowired
    private ShouzhiCategoryMapper shouzhiCategoryMapper;

    //查询收入或者支出子类型   --通过父分类，从而查询其下的所有子分类
    @Override
    public List<ShouzhiCategory> findShouzhiCategoryByParent(String parent_category) {
        return shouzhiCategoryMapper.findShouzhiCategoryByParent(parent_category);
    }

    //通过父类型，从而查询出该父类型的所有子类型，从而进行显示
    @Override
    public List<String> findSonCategoryByParent(String parent_category) {
        List<String> resultList = shouzhiCategoryMapper.findSonCategoryByParent(parent_category);
        return resultList;
    }

    //根据收支子类型，获得收支分类id  对象
    @Override
    public ShouzhiCategory findCategoryBySonCategory(String son_category) {
        return shouzhiCategoryMapper.findCategoryBySonCategory(son_category);
    }

    //添加收支类型
    @Override
    public void addShouzhiCategory(ShouzhiCategory shouzhiCategory) {
        shouzhiCategoryMapper.addShouzhiCategory(shouzhiCategory);
    }
}
