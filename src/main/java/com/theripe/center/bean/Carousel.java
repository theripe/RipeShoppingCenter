package com.theripe.center.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author TheRipe
 * @create 2021/6/24 17:03
 */
@Data
public class Carousel {
    private Integer carouselId;
    private String carouseUrl;
    private String redirectUrl;
    private Integer carouseRank;
    private Byte isDeleted;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    private Integer createUser;
    private Integer updateUser;

    @Override
    public String toString() {
        return "Carousel{" +
                "carouselId=" + carouselId +
                ", carouseUrl='" + carouseUrl + '\'' +
                ", redirectUrl='" + redirectUrl + '\'' +
                ", carouseRank=" + carouseRank +
                ", isDeleted=" + isDeleted +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createUser=" + createUser +
                ", updateUser=" + updateUser +
                '}';
    }
}
