package com.theripe.center.service.impl;

import com.theripe.center.bean.AdminUser;
import com.theripe.center.dao.AdminUsersMapper;
import com.theripe.center.service.AdminUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author TheRipe
 * @create 2021/6/24 18:18
 */

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Resource
    AdminUsersMapper adminUserMapper;
    @Override
    public AdminUser login(String userName, String password) {

        return adminUserMapper.login(userName, password);
    }
}
