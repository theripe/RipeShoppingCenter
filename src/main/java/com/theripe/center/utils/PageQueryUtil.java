package com.theripe.center.utils;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author TheRipe
 * @create 2021/6/27 11:32
 */
@Data
public class PageQueryUtil  extends LinkedHashMap<String, Object>{
    private int page;
    private int limit;

    public PageQueryUtil(Map<String,Object> parms) {
        this.putAll(parms);
        this.page = Integer.parseInt(parms.get("page").toString());
        this.limit = Integer.parseInt(parms.get("limit").toString());
        this.put("start",(page - 1) * limit);
        this.put("page",page);
        this.put("limit",limit);
    }
    @Override
    public String toString() {
        return "PageUtil{" +
                "page=" + page +
                ", limit=" + limit +
                '}';
    }

}
