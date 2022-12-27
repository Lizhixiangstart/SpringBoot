package com.atguigu.admin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
@Author: Lizhixiang
@Date: 2022/12/19
@Time: 16:26
@Description:处理WebController异常
@Version:
*/
@Slf4j
@ControllerAdvice//底层使用了Componment会被自动注入ioc容器中
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class})//value为数组，同于指定能够处理哪些异常
    public String handleArithException(Exception e){
      log.error("异常是：{}",e);
        return "login";//视图地址
    }
}
