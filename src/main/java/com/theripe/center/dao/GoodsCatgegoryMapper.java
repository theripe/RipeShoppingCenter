package com.theripe.center.dao;

import com.theripe.center.bean.GoodsCategory;
import com.theripe.center.bean.GoodsInfo;
import com.theripe.center.utils.PageQueryUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author TheRipe
 * @create 2021/6/26 14:13
 */
public interface GoodsCatgegoryMapper {
   List<GoodsCategory>  selectByLevelAndParentIdsAndNumber(@Param("parentIds") List<Long> parentIds, @Param("categoryLevel") int categoryLevel, @Param("number") int number);
   GoodsCategory selectByPrimaryKey(Long id);
   int deleteByPrimaryKey(Long goodsId);
   int insert(GoodsCategory record );
   int insertSelective(GoodsCategory record);
   GoodsCategory selectByLevelAndName(@Param("categoryLevel") Byte categoryLevel, @Param("categoryName") String categoryName) ;
   int updateByPrimaryKey(GoodsCategory record);
   int updateByPrimaryKeySelective(GoodsCategory record);
   List<GoodsCategory> findGoodsCategoryList(PageQueryUtil pageUtil);
   int getTotalGoodsCategories(PageQueryUtil pageUtil);
   int deleteBatch(Integer[] ids);
}
