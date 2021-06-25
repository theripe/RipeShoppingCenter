package com.theripe.center.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author TheRipe
 * @create 2021/6/24 17:21
 */
@Data
public class OrderItem {
    private Long OrderItemId;
    private Long orderId;
    private Long goodsId;
    private String goodsName;
    private String goodsCoverImg;
    private Integer sellingPrice;
    private Integer goodsCount;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    @Override
    public String toString() {
        return "OrderItem{" +
                "OrderItemId=" + OrderItemId +
                ", orderId=" + orderId +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsCoverImg='" + goodsCoverImg + '\'' +
                ", sellingPrice=" + sellingPrice +
                ", goodsCount=" + goodsCount +
                ", createTime=" + createTime +
                '}';
    }
}
