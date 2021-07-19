package com.theripe.center.service.impl;

import com.theripe.center.bean.GoodsCategory;
import com.theripe.center.common.ServiceResultEnum;
import com.theripe.center.dao.GoodsCatgegoryMapper;
import com.theripe.center.service.MallCategoryService;
import com.theripe.center.utils.PageQueryUtil;
import com.theripe.center.utils.PageResult;
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
        GoodsCategory goodsCategory = goodsCatgegoryMapper.selectByPrimaryKey(id);
        return goodsCategory;
    }

    @Override
    public PageResult getCategorisPage(PageQueryUtil pageUtil) {
        List<GoodsCategory> goodsCategories = goodsCatgegoryMapper.findGoodSCateGoryList(pageUtil);
        int total = goodsCatgegoryMapper.getTotalGoodsCategories(pageUtil);
        PageResult pageResult = new PageResult(goodsCategories, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        return null;
    }

    @Override
    public String saveCategory(GoodsCategory goodsCategory) {
        GoodsCategory temp = goodsCatgegoryMapper.selectByLevelAndName(goodsCategory.getCategoryLevel(), goodsCategory.getCategoryName());
        if (temp != null) {
            return ServiceResultEnum.SAME_CATEGORY_EXIST.getResult();
        }
        if (goodsCatgegoryMapper.insertSelective(goodsCategory) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }
}
