package com.theripe.center.service.impl;

import com.theripe.center.bean.IndexConfig;
import com.theripe.center.common.ServiceResultEnum;
import com.theripe.center.controller.vo.MallIndexConfigGoodsVO;
import com.theripe.center.dao.IndexConfigMapper;
import com.theripe.center.dao.MallGoodsMapper;
import com.theripe.center.service.MallIndexConfigService;
import com.theripe.center.utils.PageQueryUtil;
import com.theripe.center.utils.PageResult;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Author TheRipe
 * @create 2021/7/8 20:00
 */
public class MallIndexConfigServiceImpl implements MallIndexConfigService {
    @Resource
    IndexConfigMapper indexConfigMapper;
    @Resource
    MallGoodsMapper mallGoodsMapper;
    @Override
    public PageResult getConfigsPage(PageQueryUtil pageQueryUtil) {
        List<IndexConfig> indexConfigs = indexConfigMapper.findIndexConfigList(pageQueryUtil);
        int total = indexConfigMapper.getTotalIndexConfigs(pageQueryUtil);
        PageResult pageResult = new PageResult(indexConfigs, total, pageQueryUtil.getLimit(), pageQueryUtil.getPage());
        return pageResult;
    }

    @Override
    public String saveIndexConfig(IndexConfig indexConfig) {
        if (mallGoodsMapper.selectByPrimaryKey(indexConfig.getGoodsId()) == null) {
            return ServiceResultEnum.GOODS_NOT_EXIST.getResult();
        }
        if (indexConfigMapper.selectByTypeAndGoodsId(indexConfig.getConfigType(),indexConfig.getGoodsId()) != null) {
            return ServiceResultEnum.SAME_INDEX_CONFIG_EXIST.getResult();
        }
        if (indexConfigMapper.insertSelective(indexConfig) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public String updateIndexConfig(IndexConfig indexConfig) {
        if (mallGoodsMapper.selectByPrimaryKey(indexConfig.getGoodsId()) == null) {
            return ServiceResultEnum.GOODS_NOT_EXIST.getResult();
        }
        IndexConfig temp = indexConfigMapper.selectByPrimaryKey(indexConfig.getConfigId());
        if (temp == null) {
            return ServiceResultEnum.DATA_NOT_EXIST.getResult();
        }
        IndexConfig temp2 = indexConfigMapper.selectByTypeAndGoodsId(indexConfig.getConfigType(), indexConfig.getGoodsId());
        if (temp2 != null && !temp2.getConfigId().equals(indexConfig.getConfigId())) {
            //goodsId相同且不同id 不能继续修改
            return ServiceResultEnum.SAME_INDEX_CONFIG_EXIST.getResult();
        }
        indexConfig.setUpdateTime(new Date());
        if (indexConfigMapper.updateByPrimaryKeySelective(indexConfig) > 0) {
            return ServiceResultEnum.SUCCESS.getResult();
        }
        return ServiceResultEnum.DB_ERROR.getResult();
    }

    @Override
    public IndexConfig getIndexConfigById(Long id) {
        return null;
    }

    @Override
    public List<MallIndexConfigGoodsVO> getConfigGoodsesForIndex(int configType, int number) {
        return null;
    }

    @Override
    public Boolean deleteBatch(Long[] ids) {
        return null;
    }
}
