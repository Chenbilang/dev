package com.example.demo22.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * 默认输出页面
 * @author chenbilng
 */
public class DefaultResponse {

    public static Map<String,Object> toResponse(String meg){
        Map<String,Object> rtn=new HashMap<>();
        rtn.put("success", true);
        rtn.put("message", meg);
        return rtn;
    }
}
