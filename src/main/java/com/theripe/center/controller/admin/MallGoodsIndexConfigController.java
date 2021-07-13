package com.theripe.center.controller.admin;

import com.theripe.center.bean.IndexConfig;
import com.theripe.center.common.IndexConfigTypeEnum;
import com.theripe.center.common.ServiceResultEnum;
import com.theripe.center.service.MallIndexConfigService;
import com.theripe.center.utils.PageQueryUtil;
import com.theripe.center.utils.Result;
import com.theripe.center.utils.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Objects;

/**
 * @Author TheRipe
 * @create 2021/7/8 19:32
 */
@Controller
@RequestMapping("/admin")
public class MallGoodsIndexConfigController {

    @Resource
    MallIndexConfigService mallIndexConfigService;
    @GetMapping("/indexConfigs")
    public String indexConfigsPage(HttpServletRequest request, @RequestParam("configType") int configType) {
        IndexConfigTypeEnum indexConfigTypeEnum = IndexConfigTypeEnum.getIndexConfigTypeEnumByType(configType);
        if(indexConfigTypeEnum.equals(IndexConfigTypeEnum.DEFAULT)) {
            return "error/error_5x";
        }
        request.setAttribute("path", indexConfigTypeEnum.getName());
        request.setAttribute("configType",configType);
        return "admin/theripe_mall_index_config";

    }
    //列表
    @RequestMapping(value = "/indeConfigs/list",method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String,Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常");
        }
        PageQueryUtil pageQueryUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(mallIndexConfigService.getConfigsPage(pageQueryUtil));
    }

    /*
    添加
     */
    @RequestMapping(value = "/indexConfigs/save",method = RequestMethod.POST)
    @ResponseBody
    public Result save(@RequestBody IndexConfig indexConfig) {
        if (Objects.isNull(indexConfig.getConfigType()) || StringUtils.isEmpty(indexConfig.getConfigName()) || Objects.isNull(indexConfig.getConfigRank())) {
            return ResultGenerator.genFailResult("参数异常");
        }
        String result = mallIndexConfigService.saveIndexConfig(indexConfig);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }
    /**
     * 修改
     */
    @RequestMapping(value = "/indexConfigs/update", method = RequestMethod.POST)
    @ResponseBody
    public Result update(@RequestBody IndexConfig indexConfig) {
        if (Objects.isNull(indexConfig.getConfigType())
                || Objects.isNull(indexConfig.getConfigId())
                || StringUtils.isEmpty(indexConfig.getConfigName())
                || Objects.isNull(indexConfig.getConfigRank())) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        String result = mallIndexConfigService.updateIndexConfig(indexConfig);
        if (ServiceResultEnum.SUCCESS.getResult().equals(result)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult(result);
        }
    }

    /**
     * 详情
     */
    @GetMapping("/indexConfigs/info/{id}")
    @ResponseBody
    public Result info(@PathVariable("id") Long id) {
        IndexConfig config = mallIndexConfigService.getIndexConfigById(id);
        if (config == null) {
            return ResultGenerator.genFailResult("未查询到数据");
        }
        return ResultGenerator.genSuccessResult(config);
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/indexConfigs/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result delete(@RequestBody Long[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (mallIndexConfigService.deleteBatch(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }


}
