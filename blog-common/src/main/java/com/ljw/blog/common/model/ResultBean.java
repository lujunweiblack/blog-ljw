package com.ljw.blog.common.model;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: lujunwei
 * @time: 15:17 2019/1/18
 * @des:
 */
public class ResultBean implements Serializable {

    public final static String SUCCESS = "10200";
    public final static String FAIL = "10400";
    public final static String UN_AUTHORIZED = "10300";
    public final static String NOT_LOGGED_IN = "10000";
    public final static String AUTHENTICATION_FAILED = "10500";
    public static final String ERROR = "500";

    private final static String CODE = "code";
    private final static String MSG = "msg";
    private final static String RESULT = "result";
    private final static String JWT_TOKEN = "jwtToken";


    public static String resultInit(String code) {
        Map<String, Object> res = new HashMap<>();
        res.put(CODE, code);
        return JSONObject.toJSONString(res);
    }
    public static String resultInit(String code, String msg) {
        Map<String, Object> res = new HashMap<>();
        res.put(MSG, msg);
        res.put(CODE, code);
        return JSONObject.toJSONString(res);
    }

    public static String resultInit(String code, Object result) {
        Map<String, Object> res = new HashMap<>();
        res.put(RESULT, result);
        res.put(CODE, code);
        return JSONObject.toJSONString(res);
    }

    public static String resultInit(String code,String msg,Object result) {
        Map<String, Object> res = new HashMap<>();
        res.put(RESULT, result);
        res.put(MSG, msg);
        res.put(CODE, code);
        return JSONObject.toJSONString(res);
    }

    public static String resultInit(String code, String msg,String jwtToken) {
        Map<String, Object> res = new HashMap<>();
        res.put(JWT_TOKEN, jwtToken);
        res.put(MSG, msg);
        res.put(CODE, code);
        return JSONObject.toJSONString(res);
    }

    public static String resultInit(String code, String msg,Object result,String jwtToken) {
        Map<String, Object> res = new HashMap<>();
        res.put(JWT_TOKEN, jwtToken);
        res.put(RESULT, result);
        res.put(MSG, msg);
        res.put(CODE, code);
        return JSONObject.toJSONString(res);
    }
}
