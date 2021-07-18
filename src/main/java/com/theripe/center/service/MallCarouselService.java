package com.theripe.center.service;

import com.theripe.center.bean.Carousel;
import com.theripe.center.controller.vo.MallIndexCarouselVO;
import com.theripe.center.utils.PageQueryUtil;
import com.theripe.center.utils.PageResult;

import java.util.List;

/**
 * @Author TheRipe
 * @create 2021/7/16 21:57
 */
public interface MallCarouselService {
    PageResult getCarouselPage(PageQueryUtil pageQueryUtil);

    String saveCarousel(Carousel carousel);

    String updateCarousel(Carousel carousel);

    boolean deleteBatch(Integer[] ids);

    Carousel getCarouselById(Integer id);
    /*
    返回固定数量的轮播图对象（用于首页调用）
     */
    List<MallIndexCarouselVO> getCarouselForIndex(int number);
}
