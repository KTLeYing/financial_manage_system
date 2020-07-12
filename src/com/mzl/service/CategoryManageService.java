package com.mzl.service;

import com.mzl.pojo.PageBean;
import com.mzl.pojo.ShouzhiCategory;

/**
 * @InterfaceName :   CategoryManageService
 * @Description: 收支类型管理
 * @Author: 21989
 * @CreateDate: 2020/7/8 15:34
 * @Version: 1.0
 */
public interface CategoryManageService {

    //分页查询收支类型
    PageBean<ShouzhiCategory> findCategorys(ShouzhiCategory shouzhiCategory, Integer currentPage);

    //查询是否存在该收支类型
    ShouzhiCategory findCategory(ShouzhiCategory shouzhiCategory);

    //添加收支类型
    void addCategory(ShouzhiCategory shouzhiCategory);

    //查询该收支类型信息,用于回显
    ShouzhiCategory toEditPage(Integer szcid);

    //修改收支子类型
    void editShouzhiCategory(ShouzhiCategory shouzhiCategory);

    //查询记录表中是否有使用该收支类型
    int countCategory(int szcid);

    //删除收支类型
    void deleteShouzhiCategory(int szcid);

    //删除后的总记录数
    int countAllCategory();
}
