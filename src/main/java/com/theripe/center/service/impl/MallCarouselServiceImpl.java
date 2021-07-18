package com.theripe.center.service.impl;

import com.theripe.center.bean.Carousel;
import com.theripe.center.common.ServiceResultEnum;
import com.theripe.center.controller.vo.MallIndexCarouselVO;
import com.theripe.center.dao.CarouselMapper;
import com.theripe.center.service.MallCarouselService;
import com.theripe.center.utils.BeanUtil;
import com.theripe.center.utils.PageQueryUtil;
import com.theripe.center.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author TheRipe
 * @create 2021/7/16 21:58
 */
@Service
public class MallCarouselServiceImpl implements MallCarouselService {

    @Resource
    private CarouselMapper carouselMapper;
    @Override
    public PageResult getCarouselPage(PageQueryUtil pageQueryUtil) {
        List<Carousel> carouselList = carouselMapper.findCarouselList(pageQueryUtil);
        int total = carouselMapper.getTotalCarousels(pageQueryUtil);
        PageResult pageResult = new PageResult(carouselList, total, pageQueryUtil.getLimit(), pageQueryUtil.getPage());
        return pageResult;
    }

    @Override
    public String saveCarousel(Carousel carousel) {
        if (carouselMapper.insertSelective(carousel) > 0 ){
            return ServiceResultEnum.SUCCESS.getResult();
        } else {
            return ServiceResultEnum.DB_ERROR.getResult();
        }
    }

    @Override
    public String updateCarousel(Carousel carousel) {
        Carousel temp = carouselMapper.selectByPrimaryKey(carousel.getCarouselId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }

        temp.setCarouselRank(carousel.getCarouselRank());
        temp.setRedirectUrl(carousel.getRedirectUrl());
        temp.setCarouselUrl(carousel.getCarouselUrl());
        temp.setUpdateTime(new Date());

        if (carouselMapper.updateByPrimaryKeySelective(temp) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        } else  {
            return ServiceResultEnum.DB_ERROR.getResult();
        }

    }

    @Override
    public boolean deleteBatch(Integer[] ids) {
        if (ids.length < 1) {
            return false;
        } else {
            return carouselMapper.deleteBatch(ids) > 0;
        }
    }

    @Override
    public Carousel getCarouselById(Integer id) {
        Carousel carousel = carouselMapper.selectByPrimaryKey(id);
        return carousel;
    }

    @Override
    public List<MallIndexCarouselVO> getCarouselForIndex(int number) {
        List<MallIndexCarouselVO> res = new ArrayList<>();
        List<Carousel> list = carouselMapper.findCarouselsByNum(number);
        if (!CollectionUtils.isEmpty(list)) {
            res = BeanUtil.copyList(list, MallIndexCarouselVO.class);
        }
        return res;
    }
}
