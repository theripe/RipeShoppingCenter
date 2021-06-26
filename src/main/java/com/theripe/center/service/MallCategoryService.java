package com.theripe.center.service;

import com.theripe.center.bean.GoodsCategory;

import java.util.List;

/**
 * @Author TheRipe
 * @create 2021/6/26 15:01
 */
public interface MallCategoryService {
    List<GoodsCategory> selectByLevelAndParentIdsAndNumber(List<Long> parentIds, int categoryLevel);
    GoodsCategory slectById(Long id);
}
