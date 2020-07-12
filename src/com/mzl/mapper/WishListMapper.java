package com.mzl.mapper;

import com.mzl.pojo.WishList;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName :   WishListMapper
 * @Description: 心愿单的dao层
 * @Author: 21989
 * @CreateDate: 2020/7/6 13:03
 * @Version: 1.0
 */
public interface WishListMapper {

    //查询心愿总记录数
    int findWishListCount(int uid);

    //分页查询内容列表
    List<WishList> findWishList(Map<String, Object> map);

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
