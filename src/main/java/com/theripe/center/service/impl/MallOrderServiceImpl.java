package com.theripe.center.service.impl;

import com.theripe.center.bean.MallOrder;
import com.theripe.center.controller.vo.MallOrderDetailVO;
import com.theripe.center.controller.vo.MallOrderItemVO;
import com.theripe.center.controller.vo.MallShoppingCartItemVO;
import com.theripe.center.controller.vo.MallUserVO;
import com.theripe.center.dao.MallGoodsMapper;
import com.theripe.center.dao.MallOrderItemMapper;
import com.theripe.center.dao.MallOrderMapper;
import com.theripe.center.dao.MallShoppingCartItemMapper;
import com.theripe.center.service.MallOrderService;
import com.theripe.center.utils.PageQueryUtil;
import com.theripe.center.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author TheRipe
 * @create 2021/7/19 22:57
 */
public class MallOrderServiceImpl implements MallOrderService {
    @Autowired
    MallOrderMapper mallOrderMapper;
    @Autowired
    MallOrderItemMapper mallOrderItemMapper;
    @Autowired
    MallShoppingCartItemMapper mallShoppingCartItemMapper;
    @Autowired
    MallGoodsMapper mallGoodsMapper;
    @Override
    public PageResult getMallOrderPage(PageQueryUtil pageQueryUtil) {
        List<MallOrder> mallOrderList = mallOrderMapper.findMallOrderList(pageQueryUtil);
        int total = mallOrderMapper.getTotalMallOrders(pageQueryUtil);
        PageResult pageResult = new PageResult(mallOrderList,total,pageQueryUtil.getLimit(),pageQueryUtil.getPage());
        return pageResult;
    }

    @Override
    public String updateOrderInfo(MallOrder mallOrder) {
        return null;
    }

    @Override
    public String checkDone(Long[] ids) {
        return null;
    }

    @Override
    public String checkOut(Long[] ids) {
        return null;
    }

    @Override
    public String closeOrder(Long[] ids) {
        return null;
    }

    @Override
    public String saveOrder(MallUserVO mallUserVO, List<MallShoppingCartItemVO> mallShoppingCartItem) {
        return null;
    }

    @Override
    public MallOrderDetailVO getOrderDetailByOrderNo(String orderNo, Long userId) {
        return null;
    }

    @Override
    public MallOrder getMallOrderByOrderNo(String orderNo) {
        return null;
    }

    @Override
    public PageResult getMyOrders(PageQueryUtil pageUtil) {
        return null;
    }

    @Override
    public String cancelOrder(String orderNo, Long userId) {
        return null;
    }

    @Override
    public String finishOrder(String orderNo, Long userId) {
        return null;
    }

    @Override
    public String paySuccess(String orderNo, int payType) {
        return null;
    }

    @Override
    public List<MallOrderItemVO> getOrderItems(Long id) {
        return null;
    }
}
