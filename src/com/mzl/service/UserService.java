package com.mzl.service;

import com.mzl.pojo.PageBean;
import com.mzl.pojo.User;

/**
 * @InterfaceName :   UserService
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/5 16:31
 * @Version: 1.0
 */
public interface UserService {

    //用用户名和密码查询是否存在用户
    public User queryUserByUser(User user);

    //用用户名查询用户
    public User queryUserByUsername(String username);

    //添加用户（注册）
    public void insertUser(User user);

    //更新用户（用户修改信息）
    public void updatePasswordByUsername(User user);

    //分页查询用户列表
    PageBean<User> findUsers(User user, Integer currentPage);

    //查询要修改的用户原来信息
    User queryUserById(Integer uid);

    //编辑全部用户信息
    void editUserAll(User user);

    //进行修改用户信息
    void editUser(User user);
}
