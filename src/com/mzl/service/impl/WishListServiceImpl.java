package com.mzl.service.impl;

import com.mzl.mapper.WishListMapper;
import com.mzl.pojo.PageBean;
import com.mzl.pojo.WishList;
import com.mzl.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName :   WishListServiceImpl
 * @Description: 心愿单
 * @Author: 21989
 * @CreateDate: 2020/7/6 13:00
 * @Version: 1.0
 */
@Service
@Transactional
public class WishListServiceImpl implements WishListService {

    //注入依赖\
    @Autowired
    private WishListMapper wishListMapper;

    //分页查询心愿单当前页
    @Override
    public PageBean<WishList> findAllWishList(int uid, Integer currentPage) {
        if(currentPage == null){
            currentPage = 0;
        }

        //每页的记录数
        int pageRecord = 6;

        System.out.println("hhh");
        System.out.println(uid);
        //查询心愿总记录数
        int allRecord = wishListMapper.findWishListCount(uid);
        System.out.println(allRecord);
        System.out.println("yyy");

        //总页数
        int allPage = 0;
        if (allRecord % pageRecord == 0){
            allPage = allRecord / pageRecord;
        }else {
            allPage = allRecord / pageRecord + 1;
        }

        //开始的位置
        int startPoint = currentPage * pageRecord;

        //分页查询条件
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("uid", uid);
        map.put("startPosition", startPoint);
        map.put("pageRecord", pageRecord);

        //分页查询内容列表
        List<WishList> pageList = wishListMapper.findWishList(map);

        //封装设置心愿单的pagebean
        PageBean<WishList> pageBean = new PageBean<WishList>();
        pageBean.setAllRecord(allRecord);
        pageBean.setAllPage(allPage);
        pageBean.setPageRecord(pageRecord);
        pageBean.setPageList(pageList);
        pageBean.setCurrentPage(currentPage);
        pageBean.setStartPosition(startPoint);

        System.out.println(pageBean);

        return pageBean;
    }

    //获取某人某天的心愿单个数
    @Override
    public int countWishListByTimeAndId(WishList wishList) {
        return wishListMapper.countWishListByTimeAndId(wishList);
    }

    //添加心愿单
    @Override
    public void addWish(WishList wishList) {
        wishListMapper.addWish(wishList);
    }

    //查询心愿信息
    @Override
    public WishList findWishById(int id) {
        return wishListMapper.findWishById(id);
    }

    //更新心愿单
    @Override
    public void editWish(WishList wishList) {
        wishListMapper.editWish(wishList);
    }

    //删除心愿单
    @Override
    public void deleteWish(int id) {
        wishListMapper.deleteWish(id);
    }


}
