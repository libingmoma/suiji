package com.example.demo.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class FastJsonUtils {

    public static final String SUCCESS_MSG = "request success";

    private static final SerializerFeature[] features = {SerializerFeature.WriteMapNullValue,
            SerializerFeature.WriteNullStringAsEmpty,
            SerializerFeature.WriteNullListAsEmpty,
            SerializerFeature.WriteNullNumberAsZero,
            SerializerFeature.WriteNullBooleanAsFalse,
            SerializerFeature.WriteDateUseDateFormat,
            SerializerFeature.DisableCircularReferenceDetect};

    /**
     * 返回成功json结果
     */
    public static String resultSuccess(Integer code, String msg, Object data) {
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", code);
        rs.put("msg", StringUtils.isNotEmpty(msg) ? msg : SUCCESS_MSG);
        rs.put("data", data == null ? new Object() : data);
        rs.put("error", "");
        return toString(rs);
    }

    /**
     * 返回失败json结果
     */
    public static String resultError(Integer code, String error, Object data) {
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", code);
        rs.put("data", data == null ? new Object() : data);
        rs.put("error", StringUtils.isNotEmpty(error) ? error : "");
        return toString(rs);
    }

    /**
     * 返回分页列表json结果
     */
    public static String resultList(Integer code, String msg, Integer pageNo, Integer pageSize, Object data) {
        Map<String, Object> rs = new HashMap<>();
        rs.put("code", code);
        rs.put("msg", StringUtils.isNotEmpty(msg) ? msg : SUCCESS_MSG);
        rs.put("data", data == null ? new Object() : data);
        rs.put("pageNo", pageNo == null ? 0 : pageNo);
        rs.put("pageSize", pageSize == null ? 10 : pageSize);
        return toString(rs);
    }

    /**
     * json转字符串
     */
    public static String toString(Object data) {
        return JSON.toJSONString(data, features);
    }


    /**
     * json转map
     */
    public static Map<String,Object> getAllInfo(String jsonStr){

        Map<String,Object> map = JSON.parseObject(jsonStr, Map.class);

        return map==null?new HashMap():map;

    }

}
