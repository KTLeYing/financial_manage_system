package com.mzl.mapper;

import com.mzl.pojo.Memorandum;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName :   MemorandumMapper
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/7/6 17:55
 * @Version: 1.0
 */
public interface MemorandumMapper {

    //查询备忘录的总记录数
    int findMemorandumCount(int uid);

    //分页查询备忘录列表
    List<Memorandum> findMemorandumList(Map<String, Object> map);

    //查询当前的备忘录
    Memorandum oneMemorandum(Memorandum me);

    //编辑备忘录
    void editMemorandum(Memorandum memorandum);

    //添加到备忘录
    void addMemorandum(Memorandum memorandum);

    //删除备忘录
    void deleteMemorandum(int mid);
}
