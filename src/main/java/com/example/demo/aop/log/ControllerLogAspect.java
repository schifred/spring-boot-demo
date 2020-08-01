package com.example.demo.aop.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
@Order(1)
public class ControllerLogAspect extends BaseLogAspect {
    @Before("execution(public * com.example.demo.controller..*.*(..))")
    public void methodBefore(JoinPoint joinPoint){
        super.methodBefore(joinPoint);
    }

    @AfterReturning(returning = "rvt", pointcut="execution(public * com.example.demo.controller..*.*(..))")
    public void methodAfterReturing(JoinPoint joinPoint, Object rvt){
        super.methodAfterReturing(joinPoint, rvt);
    }
}
