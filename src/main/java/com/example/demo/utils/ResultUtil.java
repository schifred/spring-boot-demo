package com.example.demo.utils;

import com.example.demo.consts.Result;

public class ResultUtil {

    public static Result success(){
        return success(null);
    }

    public static Result success(Object obj){
        return success(obj, "success");
    }

    public static Result success(Object obj, String msg){
        Result result = new Result();
        result.setCode(200);
        result.setMsg(msg);
        result.setSuccess(true);
        result.setData(obj);
        return result;
    }

    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setSuccess(false);
        result.setData(null);
        return result;
    }
}
