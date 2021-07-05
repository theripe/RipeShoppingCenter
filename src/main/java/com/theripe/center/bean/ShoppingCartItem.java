package com.theripe.center.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author TheRipe
 * @create 2021/6/24 17:40
 */

//购物车
    @Data
public class ShoppingCartItem {
    private Long cartItemId;
    private Long userId;
    private Long goodsId;
    private Integer goodsCount;
    private Byte isDeleted;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @Override
    public String toString() {
        return "ShoopingCartItem{" +
                "cartItemId=" + cartItemId +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                ", goodsCount=" + goodsCount +
                ", isDeleted=" + isDeleted +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
