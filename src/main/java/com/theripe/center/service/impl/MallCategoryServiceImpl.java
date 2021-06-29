package com.theripe.center.service.impl;

import com.theripe.center.bean.GoodsCategory;
import com.theripe.center.dao.GoodsCatgegoryMapper;
import com.theripe.center.service.MallCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author TheRipe
 * @create 2021/6/26 15:02
 */
@Service
public class MallCategoryServiceImpl implements MallCategoryService {
    @Resource
    private GoodsCatgegoryMapper goodsCatgegoryMapper;

    @Override
    public List<GoodsCategory> selectByLevelAndParentIdsAndNumber(List<Long> parentIds, int categoryLevel) {
        List<GoodsCategory> goodsCategories = goodsCatgegoryMapper.selectByLevelAndParentIdsAndNumber(parentIds,categoryLevel,0);
        return goodsCategories;
    }

    @Override
    public GoodsCategory slectById(Long id) {
        GoodsCategory goodsCategory = goodsCatgegoryMapper.selectById(id);
        return goodsCategory;
    }
}
