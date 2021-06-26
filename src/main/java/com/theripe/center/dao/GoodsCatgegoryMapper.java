package com.theripe.center.dao;

import com.theripe.center.bean.GoodsCategory;
import com.theripe.center.bean.GoodsInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author TheRipe
 * @create 2021/6/26 14:13
 */
public interface GoodsCatgegoryMapper {
   List<GoodsCategory>  selectByLevelAndParentIdsAndNumber(@Param("parentIds") List<Long> parentIds, @Param("categoryLevel") int categoryLevel, @Param("number") int number);
   GoodsCategory selectById(Long id);
   int deleteByPrimaryKey(Long goodsId);

   int insert(GoodsInfo record );

   int insertSelective(GoodsInfo record);
}
