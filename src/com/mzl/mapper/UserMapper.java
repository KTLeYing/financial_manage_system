package com.mzl.mapper;

import com.mzl.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName :   AdminMapper
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/5 16:36
 * @Version: 1.0
 */
public interface UserMapper {

    //通过用户名和密码查询用户是否存在
    public User queryUserByUser(User user);

    //通过用户名查询用户是否存在
    public User queryUserByUsername(String username);

    //用户注册
    public void insertUser(User user);

    //修改用户密码
    public void updatePasswordByUsername(User user);

    //查询总记录数
    int findUsersCount(User user);

    //查询总记录数
    List<User> findUsers(Map<String, Object> map);

    //查询要修改的用户原来信息
    User queryUserById(Integer uid);

    //编辑全部用户信息
    void editUserAll(User user);

    //进行修改用户信息
    void editUser(User user);
}
