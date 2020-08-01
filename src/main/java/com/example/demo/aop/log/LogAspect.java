package com.example.demo.aop.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@Order(1)
public class LogAspect extends BaseLogAspect {
    //申明一个切点 里面是 execution表达式
    @Pointcut("@annotation(com.example.demo.aop.log.Log)")
    private void log(){}

    @Before("@annotation(com.example.demo.aop.log.Log)")
    public void methodBefore(JoinPoint joinPoint){
        super.methodBefore(joinPoint);
    }


    @AfterReturning(returning = "rvt",pointcut = "log()")
    public void methodAfterReturing(JoinPoint joinPoint, Object rvt){
        super.methodAfterReturing(joinPoint, rvt);
    }
}
