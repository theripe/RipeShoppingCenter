package com.theripe.center.dao;

import com.theripe.center.bean.AdminUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author TheRipe
 * @create 2021/6/24 16:49
 */
public interface AdminUsersMapper {
    int insert(AdminUser record);
    int insertSelective(AdminUser record);
    AdminUser login(@Param("userName") String userName, @Param("password") String password);
    AdminUser selectByPrimaryKey(Integer adminUserId);
    int updateByPrimaryKeySelective(AdminUser record);
    int updateByPrimaryKey(AdminUser record);
}
