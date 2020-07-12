package com.mzl.service.impl;

import com.mzl.mapper.AdminMapper;
import com.mzl.pojo.Admin;
import com.mzl.service.AdminService;
import com.sun.scenario.effect.impl.prism.PrImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName :   AdminServiceImpl
 * @Description: 管理员业务逻辑
 * @Author: 21989
 * @CreateDate: 2020/7/7 17:14
 * @Version: 1.0
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    //注入依赖
    @Autowired
    private AdminMapper adminMapper;

    //用用户名和密码查找用户
    @Override
    public Admin findAdmin(Admin admin) {
        return adminMapper.findAdmin(admin);
    }

    //用户的收支记录表记录数
    @Override
    public int countShouzhiRecord(int uid) {
        return adminMapper.countShouzhiRecord(uid);
    }

    //用户的预算表记录
    @Override
    public int countBudget(int uid) {
        return adminMapper.countBudget(uid);
    }

    //用户的心愿表记录
    @Override
    public int countWishList(int uid) {
        return adminMapper.countWishList(uid);
    }

    //用户的备忘录
    @Override
    public int countMemorandum(int uid) {
        return adminMapper.countMemorandum(uid);
    }

    //删除用户
    @Override
    public void deleteUser(int uid) {
        adminMapper.deleteUser(uid);
    }

    //查询用户总记录数
    @Override
    public int countUsers() {
        return adminMapper.countUsers();
    }
}
