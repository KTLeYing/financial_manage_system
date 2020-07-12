package com.mzl.service.impl;

import com.mzl.mapper.MemorandumMapper;
import com.mzl.pojo.Memorandum;
import com.mzl.pojo.PageBean;
import com.mzl.service.MemorandumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName :   MemorandumServiceImpl
 * @Description: 备忘录业务逻辑
 * @Author: 21989
 * @CreateDate: 2020/7/6 17:54
 * @Version: 1.0
 */
@Service
@Transactional
public class MemorandumServiceImpl implements MemorandumService {

    @Autowired
    private MemorandumMapper memorandumMapper;

    //显示所有当前页的备忘录，分页查询
    @Override
    public PageBean<Memorandum> listMemorandum(int uid, Integer currentPage) {
        if(currentPage == null){
            currentPage = 0;
        }
        //每页显示6条记录
        int pageRecord = 6;

        //查询备忘录的总记录数
        int allRecord = memorandumMapper.findMemorandumCount(uid);

        //总页数
        int allPage = 0;
        if (allRecord % pageRecord == 0){
            allPage = allRecord / pageRecord;
        }else {
            allPage = allRecord / pageRecord + 1;
        }

        //开始位置
        int startPosition = currentPage * pageRecord;

        //封装分页查询条件
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uid", uid);
        map.put("startPosition", startPosition);
        map.put("pageRecord", pageRecord);

        //分页查询备忘录列表
        List<Memorandum> pageList = memorandumMapper.findMemorandumList(map);

        //分装pagebean
        PageBean<Memorandum> pageBean = new PageBean<Memorandum>();
        pageBean.setAllPage(allPage);
        pageBean.setPageList(pageList);
        pageBean.setStartPosition(startPosition);
        pageBean.setCurrentPage(currentPage);
        pageBean.setAllRecord(allRecord);
        pageBean.setPageRecord(pageRecord);
        System.out.println(pageBean);

        return pageBean;
    }

    //查询当前的备忘录
    @Override
    public Memorandum oneMemorandum(Memorandum me) {
        return memorandumMapper.oneMemorandum(me);
    }

    //编辑备忘录
    @Override
    public void editMemorandum(Memorandum memorandum) {
        memorandumMapper.editMemorandum(memorandum);
    }

    //添加到备忘录
    @Override
    public void addMemorandum(Memorandum memorandum) {
        memorandumMapper.addMemorandum(memorandum);
    }

    //删除备忘录
    @Override
    public void deleteMemorandum(int mid) {
        memorandumMapper.deleteMemorandum(mid);
    }

    //查询总记录数
    @Override
    public int findMemorandumCount(int uid) {
        return memorandumMapper.findMemorandumCount(uid);
    }


}
