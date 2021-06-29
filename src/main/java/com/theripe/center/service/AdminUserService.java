package com.theripe.center.service;

import com.theripe.center.bean.AdminUser;
import org.apache.ibatis.annotations.Param;

/**
 * @Author TheRipe
 * @create 2021/6/24 17:55
 */
public interface AdminUserService {
    AdminUser login(@Param("userName") String userName, @Param("password") String password);

    AdminUser getUserById(Integer loginUserId);

    Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword);

    Boolean updateName(Integer loginUserId, String loginUserName, String nickName);

    int insertAdmin(AdminUser adminUser);
}
