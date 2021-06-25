package com.theripe.center.controller.admin;

import com.theripe.center.bean.GoodsCategory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author TheRipe
 * @create 2021/6/24 12:11
 */
@RequestMapping("/admin")
@Controller
public class MallGoodsContorller {

    @GetMapping("/goods")
    public String goodsPage(HttpServletRequest request) {
        request.setAttribute("path", "theripe_goods");
        return "admin/theripe_mall_goods";
    }

    @GetMapping("/goods/edit")
    public String editGoods(HttpServletRequest request) {
        request.setAttribute("path","edit");
        return "admin/theripe_mall_goods_edit";
    }
}
