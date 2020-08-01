package com.example.demo.aop.log;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class BaseLogAspect {
    public void methodBefore(JoinPoint joinPoint){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();

        String[] paramNames = signature.getParameterNames();
        Map<String, String> paramsMap = new HashMap<>(paramNames.length);
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < paramNames.length; i++){
            paramsMap.put(paramNames[i], JSON.toJSONString(args[i]));
        }

        log.info("===============请求内容===============");
        log.info("请求地址: {}", request.getRequestURL().toString());
        log.info("请求方式: {}", request.getMethod());
        log.info("请求类方法: {}", signature);
        log.info("请求类方法参数: {}", paramsMap);
        log.info("===============请求内容===============");
    }


    public void methodAfterReturing(JoinPoint joinPoint, Object rvt){
        log.info("===============响应内容===============");
        log.info("响应内容: ", JSON.toJSONString(rvt));
        log.info("===============响应内容===============");
    }
}
