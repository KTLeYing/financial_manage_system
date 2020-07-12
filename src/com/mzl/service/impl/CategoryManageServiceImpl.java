package com.mzl.service.impl;

import com.mzl.mapper.CategoryManageMapper;
import com.mzl.pojo.PageBean;
import com.mzl.pojo.ShouzhiCategory;
import com.mzl.service.CategoryManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName :   CategoryManageServiceImpl
 * @Description: 收支类型实现类
 * @Author: 21989
 * @CreateDate: 2020/7/8 15:34
 * @Version: 1.0
 */
@Service
@Transactional
public class CategoryManageServiceImpl implements CategoryManageService {

    //注入依赖
    @Autowired
    private CategoryManageMapper categoryManageMapper;

    //分页查询收支类型
    @Override
    public PageBean<ShouzhiCategory> findCategorys(ShouzhiCategory shouzhiCategory, Integer currentPage) {
        System.out.println(shouzhiCategory);
        System.out.println(currentPage);

        //如果当前页currentPage为空,设为0
        if (currentPage == null){
            currentPage = 0;
        }

        //每页记录数
        int pageRecord = 10;

        //设置类型总记录数
        int allRecord = categoryManageMapper.findCategoryCount(shouzhiCategory);
        System.out.println(allRecord);

        //总页数
        int allPgae = 0;
        if (allRecord % pageRecord == 0){
            allPgae = allRecord / pageRecord;
        }else {
            allPgae = allRecord / pageRecord + 1;
        }

        //开始分页的位置
        int startPosition = currentPage * pageRecord;

        //封装分页查询列表参数
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("startPosition", startPosition);
        paramMap.put("pageRecord", pageRecord);
        paramMap.put("shouzhiCategory", shouzhiCategory);

        //分页查询收支类型列表
        List<ShouzhiCategory> pageList = categoryManageMapper.findCategoryList(paramMap);
        System.out.println(pageList);

        //封装pagebean
        PageBean<ShouzhiCategory> pageBean = new PageBean<ShouzhiCategory>();
        pageBean.setPageList(pageList);
        pageBean.setAllPage(allPgae);
        pageBean.setStartPosition(startPosition);
        pageBean.setCurrentPage(currentPage);
        pageBean.setAllRecord(allRecord);
        pageBean.setPageRecord(pageRecord);

        System.out.println(pageBean);

        return pageBean;
    }

    //查询是否存在该收支类型
    @Override
    public ShouzhiCategory findCategory(ShouzhiCategory shouzhiCategory) {
        return categoryManageMapper.findCategory(shouzhiCategory);
    }

    //添加收支类型
    @Override
    public void addCategory(ShouzhiCategory shouzhiCategory) {
        categoryManageMapper.addCategory(shouzhiCategory);
    }

    //查询该收支类型信息,用于回显
    @Override
    public ShouzhiCategory toEditPage(Integer szcid) {
        return categoryManageMapper.toEditPage(szcid);
    }

    //修改收支子类型
    @Override
    public void editShouzhiCategory(ShouzhiCategory shouzhiCategory) {
        categoryManageMapper.editShouzhiCategory(shouzhiCategory);
    }

    //查询记录表中是否有使用该收支类型
    @Override
    public int countCategory(int szcid) {
        return categoryManageMapper.countCategory(szcid);
    }

    //删除收支类型
    @Override
    public void deleteShouzhiCategory(int szcid) {
        categoryManageMapper.deleteShouzhiCategory(szcid);
    }

    //删除后的总记录数
    @Override
    public int countAllCategory() {
        return categoryManageMapper.countAllCategory();
    }


}
