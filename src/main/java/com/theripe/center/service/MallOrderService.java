package com.theripe.center.service;

import com.theripe.center.bean.MallOrder;
import com.theripe.center.controller.vo.MallOrderDetailVO;
import com.theripe.center.controller.vo.MallOrderItemVO;
import com.theripe.center.controller.vo.MallShoppingCartItemVO;
import com.theripe.center.controller.vo.MallUserVO;
import com.theripe.center.utils.PageQueryUtil;
import com.theripe.center.utils.PageResult;

import java.util.List;

/**
 * @Author TheRipe
 * @create 2021/7/19 16:52
 */
public interface MallOrderService {
    //后台分页
    PageResult getMallOrderPage(PageQueryUtil pageQueryUtil);

    //订单信息修改
    String updateOrderInfo(MallOrder mallOrder);

    //配货
    String checkDone(Long[] ids);

    //出库
    String checkOut(Long[] ids);

    //关闭订单
    String closeOrder(Long[] ids);

    //保存订单
    String saveOrder(MallUserVO mallUserVO, List<MallShoppingCartItemVO> mallShoppingCartItem);

    //获取订单详情

    MallOrderDetailVO getOrderDetailByOrderNo(String orderNo, Long userId);

    //获取订单详情

    MallOrder getMallOrderByOrderNo(String orderNo);

    //获取订单列表

     PageResult getMyOrders(PageQueryUtil pageUtil);

    //手动取消订单
    String cancelOrder(String orderNo, Long userId);

    //确认收货
    String finishOrder(String orderNo, Long userId);

    String paySuccess(String orderNo, int payType);

    List<MallOrderItemVO> getOrderItems(Long id);

}
