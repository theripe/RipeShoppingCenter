package com.theripe.center.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Author TheRipe
 * @create 2021/6/24 17:10
 */
@Data
public class IndexConfig {
    private Long configId;
    private String configName;
    private Byte configType;
    private Long goodsId;
    private String redirectUrl;
    private Integer configRank;
    private Byte isDeleted;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    private Integer createUser;
    private Integer updateUser;

    @Override
    public String toString() {
        return "IndexConfig{" +
                "configId=" + configId +
                ", configName='" + configName + '\'' +
                ", configType=" + configType +
                ", goodsId=" + goodsId +
                ", redirectUrl='" + redirectUrl + '\'' +
                ", configRank=" + configRank +
                ", isDeleted=" + isDeleted +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createUser=" + createUser +
                ", updateUser=" + updateUser +
                '}';
    }
}
