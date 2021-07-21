package com.theripe.center.service.impl;

import com.theripe.center.bean.GoodsCategory;
import com.theripe.center.bean.GoodsInfo;
import com.theripe.center.common.CategoryLevelEnum;
import com.theripe.center.common.ServiceResultEnum;
import com.theripe.center.controller.vo.MallSearchGoodsVO;
import com.theripe.center.dao.GoodsCatgegoryMapper;
import com.theripe.center.dao.MallGoodsMapper;
import com.theripe.center.service.MallGoodsService;
import com.theripe.center.utils.BeanUtil;
import com.theripe.center.utils.PageQueryUtil;
import com.theripe.center.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author TheRipe
 * @create 2021/7/19 16:59
 */
@Service
public class MallGoodsServiceImpl implements MallGoodsService {

    @Autowired
    MallGoodsMapper mallGoodsMapper;
    @Autowired
    GoodsCatgegoryMapper goodsCatgegoryMapper;
    @Override
    public PageResult getMallGoodsPage(PageQueryUtil pageUtil) {
        List<GoodsInfo> goodsList = mallGoodsMapper.findGoodsList(pageUtil);
        int total = mallGoodsMapper.getTotalMallGoods(pageUtil);
        PageResult pageResult = new PageResult(goodsList,total,pageUtil.getLimit(),pageUtil.getPage());
        return pageResult;
    }

    @Override
    public String saveMallGoods(GoodsInfo goods) {
        GoodsCategory category = goodsCatgegoryMapper.selectByPrimaryKey(goods.getGoodsCategoryId());
        //商品分类不存在或者不为三级分类的商品
        if (category == null || category.getCategoryLevel().intValue() != CategoryLevelEnum.LEVEL_THREE.getLevel()) {
            return ServiceResultEnum.GOODS_CATEGORY_ERROR.getResult();
        }
        //商品信息已存在
        if (mallGoodsMapper.selectByCategoryIdAndName(goods.getGoodsName(),goods.getGoodsCategoryId()) != null) {
            return ServiceResultEnum.SAME_GOODS_EXIST.getResult();
        }

        if (mallGoodsMapper.insertSelective(goods) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();


    }

    @Override
    public void batchSaveMallGoods(List<GoodsInfo> MallGoodsList) {
        if (!CollectionUtils.isEmpty(MallGoodsList)) {
            mallGoodsMapper.batchInsert(MallGoodsList);
        }

    }

    @Override
    public String updateMallGoods(GoodsInfo goods) {
        GoodsCategory goodsCategory = goodsCatgegoryMapper.selectByPrimaryKey(goods.getGoodsCategoryId());
        // 分类不存在或者不是三级分类，则该参数字段异常
        if (goodsCategory == null || goodsCategory.getCategoryLevel().intValue() != CategoryLevelEnum.LEVEL_THREE.getLevel()) {
            return ServiceResultEnum.GOODS_CATEGORY_ERROR.getResult();
        }
        GoodsInfo temp = mallGoodsMapper.selectByPrimaryKey(goods.getGoodsId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        GoodsInfo temp2 = mallGoodsMapper.selectByCategoryIdAndName(goods.getGoodsName(), goods.getGoodsCategoryId());
        if (temp2 != null && !temp2.getGoodsId().equals(goods.getGoodsId())) {
            //name和分类id相同且不同id 不能继续修改
            return ServiceResultEnum.SAME_GOODS_EXIST.getResult();
        }
        goods.setUpdateTime(new Date());
        if (mallGoodsMapper.updateByPrimaryKeySelective(goods) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public GoodsInfo getMallGoodsById(Long id) {
        return mallGoodsMapper.selectByPrimaryKey(id);
    }


    @Override
    public Boolean batchUpdateSellStatus(Long[] ids, int sellStatus) {
       return mallGoodsMapper.batchUpdateSellStatus(ids,sellStatus) > 0;
    }

    @Override
    public PageResult searchMallGoods(PageQueryUtil pageUtil) {
        List<GoodsInfo> goodList = mallGoodsMapper.findMallGoodsListBySearch(pageUtil);
        int total = mallGoodsMapper.getTotalMallGoodsBySearch(pageUtil);
        List<MallSearchGoodsVO> goodsVOS  = new ArrayList<>();
        if (!CollectionUtils.isEmpty(goodList)) {
            goodsVOS = BeanUtil.copyList(goodList,MallSearchGoodsVO.class);
            for (MallSearchGoodsVO goodsVO : goodsVOS) {
                String name = goodsVO.getGoodsName();
                String goodTntro = goodsVO.getGoodsIntro();
                if (name.length()> 28) {
                    name  = goodsVO.getGoodsName().substring(0, 28) + "...";
                    goodsVO.setGoodsName(name);
                }
                if (goodTntro.length() > 30) {
                    goodTntro = goodsVO.getGoodsIntro().substring(0, 30) + "...";
                    goodsVO.setGoodsIntro(goodTntro);
                }

            }
        }
        PageResult pageResult = new PageResult(goodsVOS,total,pageUtil.getLimit(),pageUtil.getPage());
        return pageResult;
    }
}
