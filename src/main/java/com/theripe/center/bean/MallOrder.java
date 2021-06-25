package com.theripe.center.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author TheRipe
 * @create 2021/6/24 17:13
 */
@Data
public class MallOrder {
     private Long orderId;
     private String orderNo;
     private Long userId;
     private Integer totalPrice;
     private Byte payStatus;
     private Byte payType;
     private Date payTime;
     private Byte orderStatus;
     private String extraInfo;
     private String userAddress;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @Override
    public String toString() {
        return "MallOrder{" +
                "orderId=" + orderId +
                ", orderNo='" + orderNo + '\'' +
                ", userId=" + userId +
                ", totalPrice=" + totalPrice +
                ", payStatus=" + payStatus +
                ", payType=" + payType +
                ", payTime=" + payTime +
                ", orderStatus=" + orderStatus +
                ", extraInfo='" + extraInfo + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
