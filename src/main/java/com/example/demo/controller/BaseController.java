package com.example.demo.controller;

import com.example.demo.consts.Result;
import com.example.demo.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Iterator;
import java.util.Set;

@ControllerAdvice
@RestController
@Slf4j
public class BaseController {
    @ExceptionHandler({Exception.class})// 针对指定错误进行处理
    public Result handleException(Exception e){
        log.info("error: "+e);
        return  ResultUtil.error(400, "error");
    }

    @ExceptionHandler({ValidationException.class})
    public Result handle(ValidationException exception) {
        String message = "params error";
        if(exception instanceof ConstraintViolationException){
            ConstraintViolationException exs = (ConstraintViolationException) exception;

            Set<ConstraintViolation<?>> violations = exs.getConstraintViolations();
            Iterator<ConstraintViolation<?>> constraintViolationIterator = violations.iterator();
            message = constraintViolationIterator.next().getMessage();
            log.info(message);
        }

        return ResultUtil.error(400, message);
    }
}
