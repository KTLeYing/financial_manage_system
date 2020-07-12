package com.mzl.service;

import com.mzl.pojo.Memorandum;
import com.mzl.pojo.PageBean;

/**
 * @InterfaceName :   MemorandumService
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/7/6 17:53
 * @Version: 1.0
 */
public interface MemorandumService {

    //显示所有当前页的备忘录，分页查询
    PageBean<Memorandum> listMemorandum(int uid, Integer currentPage);

    //查询当前的备忘录
    Memorandum oneMemorandum(Memorandum me);

    //编辑备忘录
    void editMemorandum(Memorandum memorandum);

    //添加到备忘录
    void addMemorandum(Memorandum memorandum);

    //删除备忘录
    void deleteMemorandum(int mid);

    //查询总记录数
    int findMemorandumCount(int uid);
}
