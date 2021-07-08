package com.theripe.center.service;

import com.theripe.center.bean.IndexConfig;
import com.theripe.center.controller.vo.MallIndexConfigGoodsVO;
import com.theripe.center.utils.PageQueryUtil;
import com.theripe.center.utils.PageResult;

import java.util.List;

/**
 * @Author TheRipe
 * @create 2021/7/8 19:47
 */

public interface MallIndexConfigService {
    PageResult getConfigsPage(PageQueryUtil pageQueryUtil);
    String saveIndexConfig(IndexConfig indexConfig);

    String updateIndexConfig(IndexConfig indexConfig);

    IndexConfig getIndexConfigById(Long id);

    /**
     * 返回固定数量的首页配置商品对象(首页调用)
     *
     * @param number
     * @return
     */
    List<MallIndexConfigGoodsVO> getConfigGoodsesForIndex(int configType, int number);

    Boolean deleteBatch(Long[] ids);

}
