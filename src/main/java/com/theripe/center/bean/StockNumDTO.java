package com.theripe.center.bean;

import lombok.Data;

/**
 * @Author TheRipe
 * @create 2021/6/24 17:41
 */
//修改库存所需实体
@Data
public class StockNumDTO {
    private Long goodsId;
    private Integer goodsCount;

    @Override
    public String toString() {
        return "StockNumDTO{" +
                "goodsId=" + goodsId +
                ", goodsCount=" + goodsCount +
                '}';
    }
}
