package com.mzl.service.impl;

import com.mzl.mapper.UserMapper;
import com.mzl.pojo.PageBean;
import com.mzl.pojo.User;
import com.mzl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.nio.cs.ext.MacArabic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName :   UserServiceImpl
 * @Description: TODO
 * @Author: 21989
 * @CreateDate: 2020/6/5 16:31
 * @Version: 1.0
 */
@Service
//事务管理
@Transactional
public class UserServiceImpl implements UserService {

    // 注入依赖
    @Autowired
    private UserMapper userMapper;

    //用用户名和密码查询用户
    @Override
    public User queryUserByUser(User user) {
        return userMapper.queryUserByUser(user);
    }

    //用用户名查询用户
    @Override
    public User queryUserByUsername(String username) {
        return userMapper.queryUserByUsername(username);
    }

    //添加用户
    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }

    //修改用户密码
    @Override
    public void updatePasswordByUsername(User user) {
        userMapper.updatePasswordByUsername(user);
    }

    //分页查询用户列表
    @Override
    public PageBean<User> findUsers(User user, Integer currentPage) {
        //如果currentPage为空，设置为0
        if (currentPage == null){
            currentPage = 0;
        }

        //每页记录数
        int pageRecord = 10;

        //查询总记录数
        int allRecord = userMapper.findUsersCount(user);
        System.out.println(allRecord);

        //总页数
        int allPage = 0;
        if (allRecord % pageRecord == 0){
            allPage = allRecord / pageRecord;
        }else {
            allPage = allRecord / pageRecord + 1;
        }

        //开始位置
        int startPosition = currentPage * pageRecord;
        System.out.println(startPosition);

        //用map封装分页查询的条件
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startPosition", startPosition);
        map.put("pageRecord", pageRecord);
        map.put("user", user);

        //分页查询用户
        List<User> pageList = userMapper.findUsers(map);
        System.out.println(pageList);

        //把数据封装在pagebean对象中，返回给用户列表页面
        //创建分页对象
        PageBean<User> pageBean = new PageBean<User>();
        pageBean.setPageRecord(pageRecord);
        pageBean.setAllRecord(allRecord);
        pageBean.setPageList(pageList);
        pageBean.setCurrentPage(currentPage);
        pageBean.setStartPosition(startPosition);
        pageBean.setAllPage(allPage);

        System.out.println(pageBean);

        return pageBean;
    }

    //查询要修改的用户原来信息
    @Override
    public User queryUserById(Integer uid) {
        return userMapper.queryUserById(uid);
    }

    //编辑全部用户信息
    @Override
    public void editUserAll(User user) {
        userMapper.editUserAll(user);
    }

    //进行修改用户信息
    @Override
    public void editUser(User user) {
        userMapper.editUser(user);
    }


}

