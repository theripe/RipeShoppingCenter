package com.theripe.center.service.impl;

import com.theripe.center.bean.AdminUser;
import com.theripe.center.dao.AdminUsersMapper;
import com.theripe.center.service.AdminUserService;
import com.theripe.center.utils.MD5Util;
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
//给密码加密
        String passwordMd5 = MD5Util.MD5Encode(password,"UTF-8");
        return adminUserMapper.login(userName, passwordMd5);
    }

    @Override
    public AdminUser getUserById(Integer loginUserId) {
        return adminUserMapper.selectByPrimaryKey(loginUserId);
    }

    @Override
    public Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword) {
        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
        if (adminUser != null) {
            String originalPasswordMd5 = MD5Util.MD5Encode(originalPassword,"UTF-8");
            String  newPasswordMd5 = MD5Util.MD5Encode(newPassword, "UTF-8");
            if(originalPasswordMd5.equals(adminUser.getLoginPassword())){
                adminUser.setLoginPassword(newPasswordMd5);
                if(adminUserMapper.updateByPrimaryKeySelective(adminUser) > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean updateName(Integer loginUserId, String loginUserName, String nickName) {

        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
        //当前用户非空才可以进行更改
        if (adminUser != null) {
            //设置新名称并修改
            adminUser.setLoginUserName(loginUserName);
            adminUser.setNickName(nickName);
            if (adminUserMapper.updateByPrimaryKeySelective(adminUser) > 0) {
                //修改成功则返回true
                return true;
            }
        }
        return false;
    }

    @Override
    public int insertAdmin(AdminUser adminUser) {
        AdminUser user  = new AdminUser();
        int i = adminUserMapper.insertSelective(adminUser);
       return  i;
    }


}
