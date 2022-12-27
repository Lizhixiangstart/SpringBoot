package com.atguigu.admin.exception;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
@Author: Lizhixiang
@Date: 2022/12/19
@Time: 21:03
@Description:
@Version:
*/
@Order(value = Ordered.LOWEST_PRECEDENCE)  //数字越小优先级越高
@Component
public class CustomHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request
                                        , HttpServletResponse response
                                        , Object handler, Exception ex) {
        try {
            response.sendError(511,"出现未知异常");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView();
    }
}