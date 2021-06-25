package com.theripe.center.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author TheRipe
 * @create 2021/6/24 16:57
 */
@Data
public class GoodsCategory {
    private Long categoryId;
    private Byte categoryLevel;
    private Long parentId;
    private String categoryName;
    private Integer categoryRank;
    private Byte isDeleted;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    private Integer createUser;
    private Integer updateUser;

    @Override
    public String toString() {
        return "GoodsCategory{" +
                "categoryId=" + categoryId +
                ", categoryLevel=" + categoryLevel +
                ", parentId=" + parentId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryRank=" + categoryRank +
                ", isDeleted=" + isDeleted +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createUser=" + createUser +
                ", updateUser=" + updateUser +
                '}';
    }
}
