package com.theripe.center.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author TheRipe
 * @create 2021/6/24 17:35
 */
@Data
public class GoodsInfo {
    private Long goodsId;
    private String goodsName;
    private String goodsIntro;
    private Long goodsCategoryId;
    private String goodsCoverImg;
    private String goodsCarousel;
    private Integer originalPrice;
    private Integer sellingPrice;
    private Integer stockNum;
    private String tag;
    private Byte goodsSellStatus;
    private Integer createUser;
    private Integer updateUser;
    private String goodsDetailContent;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsIntro='" + goodsIntro + '\'' +
                ", goodsCategoryId=" + goodsCategoryId +
                ", goodsCoverImg='" + goodsCoverImg + '\'' +
                ", goodsCarousel='" + goodsCarousel + '\'' +
                ", originalPrice=" + originalPrice +
                ", sellingPrice=" + sellingPrice +
                ", stockNum=" + stockNum +
                ", tag='" + tag + '\'' +
                ", goodsSellStatus=" + goodsSellStatus +
                ", createUser=" + createUser +
                ", updateUser=" + updateUser +
                ", goodsDetailContent='" + goodsDetailContent + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
