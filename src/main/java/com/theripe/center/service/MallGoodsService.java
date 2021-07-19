package com.theripe.center.service;

import com.theripe.center.bean.GoodsInfo;
import com.theripe.center.utils.PageQueryUtil;
import com.theripe.center.utils.PageResult;

import java.util.List;

/**
 * @Author TheRipe
 * @create 2021/7/19 16:50
 */
public interface MallGoodsService {
        /**
         * 后台分页
         *
         * @param pageUtil
         * @return
         */
        PageResult getMallGoodsPage(PageQueryUtil pageUtil);

        /**
         * 添加商品
         *
         * @param goods
         * @return
         */
        String saveMallGoods(GoodsInfo goods);

        /**
         * 批量新增商品数据
         *
         * @param MallGoodsList
         * @return
         */
        void batchSaveMallGoods(List<GoodsInfo> MallGoodsList);

        /**
         * 修改商品信息
         *
         * @param goods
         * @return
         */
        String updateMallGoods(GoodsInfo goods);

        /**
         * 获取商品详情
         *
         * @param id
         * @return
         */
        GoodsInfo getMallGoodsById(Long id);

        /**
         * 批量修改销售状态(上架下架)
         *
         * @param ids
         * @return
         */
        Boolean batchUpdateSellStatus(Long[] ids,int sellStatus);

        /**
         * 商品搜索
         *
         * @param pageUtil
         * @return
         */
        PageResult searchMallGoods(PageQueryUtil pageUtil);
}
