package com.mzl.mapper;

import com.mzl.pojo.Admin;

/**
 * @InterfaceName :   AdminMapper
 * @Description: 管理员dao
 * @Author: 21989
 * @CreateDate: 2020/7/7 17:15
 * @Version: 1.0
 */
public interface AdminMapper {

    //用用户名和密码查找用户
    Admin findAdmin(Admin admin);

    //用户的收支记录表记录数
    int countShouzhiRecord(int uid);

    //用户的预算表记录
    int countBudget(int uid);

    //用户的心愿表记录
    int countWishList(int uid);

    //用户的备忘录
    int countMemorandum(int uid);

    //删除用户
    void deleteUser(int uid);

    //查询用户总记录数
    int countUsers();
}
