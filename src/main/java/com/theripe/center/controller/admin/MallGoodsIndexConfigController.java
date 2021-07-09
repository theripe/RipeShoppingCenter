package com.theripe.center.controller.admin;

import com.theripe.center.common.IndexConfigTypeEnum;
import com.theripe.center.service.MallIndexConfigService;
import com.theripe.center.utils.PageQueryUtil;
import com.theripe.center.utils.Result;
import com.theripe.center.utils.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
    @RequestMapping(value = "/indeConfigs/list",method = RequestMethod.GET)
    @ResponseBody
    public Result list(@RequestParam Map<String,Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常");
        }
        PageQueryUtil pageQueryUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(mallIndexConfigService);
    }
}
