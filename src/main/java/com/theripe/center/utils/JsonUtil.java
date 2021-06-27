package com.theripe.center.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Author TheRipe
 * @create 2021/6/27 11:25
 */
public class JsonUtil {

    public static  Object jsonToObj(Class objClass, String jsonStr) throws JsonProcessingException {
        ObjectMapper  mapper = new ObjectMapper();
        return mapper.readValue(jsonStr, objClass);
    }

    public static String objToJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }
}
