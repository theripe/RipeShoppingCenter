package com.theripe.center.controller.admin;

import com.theripe.center.bean.GoodsCategory;
import com.theripe.center.service.MallCategoryService;
import com.theripe.center.utils.Result;
import com.theripe.center.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author TheRipe
 * @create 2021/6/26 17:40
 */
@RequestMapping("/admin")
public class GoodsCategoryController {
    @Resource
    private MallCategoryService mallCategoryService;

    @RequestMapping(value = "/categories/listForSelect", method = RequestMethod.GET)
    @ResponseBody
    public Result listForSelect(@RequestParam("categoryId") Long categoryId) {
        if (categoryId == null  || categoryId < 1) {
            return ResultGenerator.genFailResult("缺少参数!");
        }
        GoodsCategory category = mallCategoryService;
      return null;
    }
}
