package com.theripe.center.service.impl;

import com.theripe.center.bean.AdminUser;
import com.theripe.center.dao.AdminUserMapper;
import com.theripe.center.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author TheRipe
 * @create 2021/6/24 18:18
 */

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Resource
    AdminUserMapper adminUserMapper;
    @Override
    public AdminUser login(String userName, String password) {

        return adminUserMapper.login(userName, password);
    }
}
