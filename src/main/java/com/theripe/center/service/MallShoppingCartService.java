package com.theripe.center.service;

import com.theripe.center.bean.ShoppingCartItem;
import com.theripe.center.controller.vo.MallShoppingCartItemVO;

import java.util.List;

/**
 * @Author TheRipe
 * @create 2021/7/20 9:18
 */
public interface MallShoppingCartService {
    /**
     * 保存商品至购物车中
     */
    String saveMallCartItem(ShoppingCartItem mallShoppingCartItem);

    /**
     * 修改购物车中的属性

     */
    String updateMallCartItem(ShoppingCartItem mallShoppingCartItem);

    /**
     * 获取购物项详情
     */
    ShoppingCartItem getMallCartItemById(Long mallShoppingCartItemId);

    /**
     * 删除购物车中的商品

     */
    Boolean deleteById(Long shoppingCartItemId, Long userId);

    /**
     * 获取我的购物车中的列表数据

     */
    List<MallShoppingCartItemVO> getMyShoppingCartItems(Long MallUserId);
}
