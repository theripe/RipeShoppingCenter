package com.theripe.center.bean;

import lombok.Data;

/**
 * @Author TheRipe
 * @create 2021/6/24 16:54
 */

//用户实体类
@Data
public class MallUser {
    private Long userId;
    private String nickName;
    private String loginName;
    private String passwordMd5;
    private String introduceSign;
    private String address;
    private Byte isDeleted;
    private Byte lockedFlag;

    @Override
    public String toString() {
        return "MallUser{" +
                "userId=" + userId +
                ", nickName='" + nickName + '\'' +
                ", loginName='" + loginName + '\'' +
                ", passwordMd5='" + passwordMd5 + '\'' +
                ", introduceSign='" + introduceSign + '\'' +
                ", address='" + address + '\'' +
                ", isDeleted=" + isDeleted +
                ", lockedFlag=" + lockedFlag +
                '}';
    }
}
