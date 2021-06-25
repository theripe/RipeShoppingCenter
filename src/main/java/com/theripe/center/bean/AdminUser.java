package com.theripe.center.bean;

import lombok.Data;

/**
 * @Author TheRipe
 * @create 2021/6/24 16:50
 */
//管理员用户实体类
@Data
public class AdminUser {
    private Integer adminUserId;
    private String loginUserName;
    private String loginPassword;
    private String nickName;
    private Byte locked;

    @Override
    public String toString() {
        return "AdminUser{" +
                "adminUserId=" + adminUserId +
                ", loginUserName='" + loginUserName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", nickName='" + nickName + '\'' +
                ", locked=" + locked +
                '}';
    }
}
