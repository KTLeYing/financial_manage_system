package com.mzl.service;

import com.mzl.pojo.PageBean;
import com.mzl.pojo.WishList;

/**
 * @InterfaceName :   WishListService
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/7/6 13:00
 * @Version: 1.0
 */
public interface WishListService {

    //分页查询心愿单当前页
    PageBean<WishList> findAllWishList(int uid, Integer currentPage);

    //获取某人某天的心愿单个数
    int countWishListByTimeAndId(WishList wishList);

    //添加心愿单
    void addWish(WishList wishList);

    //查询心愿信息
    WishList findWishById(int id);

    //更新心愿单
    void editWish(WishList wishList);

    //删除心愿单
    void deleteWish(int id);
}
