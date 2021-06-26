package com.theripe.center.controller.admin;

import com.theripe.center.bean.GoodsCategory;
import com.theripe.center.common.CategoryLevelEnum;
import com.theripe.center.service.MallCategoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

/**
 * @Author TheRipe
 * @create 2021/6/24 12:11
 */
@RequestMapping("/admin")
@Controller
public class MallGoodsContorller {
    @Autowired
    private MallCategoryService mallCategoryService;

    @GetMapping("/goods")
    public String goodsPage(HttpServletRequest request) {
        request.setAttribute("path", "theripe_goods");
        return "admin/theripe_mall_goods";
    }

    @GetMapping("/goods/edit")
    public String editGoods(HttpServletRequest request) {
        request.setAttribute("path","edit");
        List<GoodsCategory> firstLevelCategories  = mallCategoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(0L), CategoryLevelEnum.LEVEL_ONE.getLevel());
        if (!CollectionUtils.isEmpty(firstLevelCategories)) {
            List<GoodsCategory> secondLevelCategories = mallCategoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(firstLevelCategories.get(0).getCategoryId()), CategoryLevelEnum.LEVEL_TWO.getLevel());
            if (!CollectionUtils.isEmpty(secondLevelCategories)) {
                List<GoodsCategory> thirdLevelCategories = mallCategoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(secondLevelCategories.get(0).getCategoryId()), CategoryLevelEnum.LEVEL_THREE.getLevel());
                request.setAttribute("firstLevelCategories", firstLevelCategories);
                request.setAttribute("secondLevelCategories", secondLevelCategories);
                request.setAttribute("thirdLevelCategories", thirdLevelCategories);
                request.setAttribute("path","goods-edit");
                return "admin/theripe_mall_goods_edit";
            }
        }
        return "error/error_5xx";

    }
    @GetMapping("/goods/edit/{goodsId}")
    public String edit(HttpServletRequest request, @PathVariable("goodsId") Long id) {
        request.setAttribute("path","edit");
        GoodsCategory goodsCategory = mallCategoryService.slectById(id);
        if(goodsCategory == null) {
            return "error/error_400";
        }
        if (goodsCategory.getCategoryId() > 0) {
            if (goodsCategory.getCategoryId() != null || goodsCategory.getCategoryId() > 0) {
                GoodsCategory goodsCategory1 = mallCategoryService.slectById(goodsCategory.getCategoryId());
                if (goodsCategory1 != null && goodsCategory1.getCategoryLevel() == CategoryLevelEnum.LEVEL_THREE.getLevel()) {
                    List<GoodsCategory> firstLevelCategories = mallCategoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(0L), CategoryLevelEnum.LEVEL_ONE.getLevel());
                    List<GoodsCategory> thirdLevelCategories = mallCategoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(goodsCategory1.getCategoryId()), CategoryLevelEnum.LEVEL_THREE.getLevel());
                    GoodsCategory secondCategory = mallCategoryService.slectById(goodsCategory1.getCategoryId());
                    if (secondCategory != null) {
                        List<GoodsCategory> secondLevelCategories = mallCategoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(secondCategory.getCategoryId()), CategoryLevelEnum.LEVEL_TWO.getLevel());
                        GoodsCategory firstCategory = mallCategoryService.slectById(secondCategory.getCategoryId());
                        if (firstCategory != null) {
                            request.setAttribute("firstLevelCategories", firstLevelCategories);
                            request.setAttribute("secondLevelCategories", secondLevelCategories);
                            request.setAttribute("thirdLevelCategories", thirdLevelCategories);
                            request.setAttribute("firstLevelCategoryId", firstCategory.getCategoryId());
                            request.setAttribute("secondLevelCategoryId", secondCategory.getCategoryId());
                            request.setAttribute("thirdLevelCategoryId", goodsCategory1.getCategoryId());
                        }
                    }

                }
            }
        }
        if (goodsCategory.getCategoryId() == 0) {
            List<GoodsCategory> firstLevelCategories = mallCategoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(0L), CategoryLevelEnum.LEVEL_ONE.getLevel());
            if (!CollectionUtils.isEmpty(firstLevelCategories)) {
                //查询一级分类列表中第一个实体的所有二级分类
                List<GoodsCategory> secondLevelCategories = mallCategoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(firstLevelCategories.get(0).getCategoryId()), CategoryLevelEnum.LEVEL_TWO.getLevel());
                if (!CollectionUtils.isEmpty(secondLevelCategories)) {
                    //查询二级分类列表中第一个实体的所有三级分类
                    List<GoodsCategory> thirdLevelCategories = mallCategoryService.selectByLevelAndParentIdsAndNumber(Collections.singletonList(secondLevelCategories.get(0).getCategoryId()), CategoryLevelEnum.LEVEL_THREE.getLevel());
                    request.setAttribute("firstLevelCategories", firstLevelCategories);
                    request.setAttribute("secondLevelCategories", secondLevelCategories);
                    request.setAttribute("thirdLevelCategories", thirdLevelCategories);
                }
            }
        }
        request.setAttribute("goods", goodsCategory);
        request.setAttribute("path", "goods-edit");
        return "admin/theripe_mall_goods_edit";
    }

}
