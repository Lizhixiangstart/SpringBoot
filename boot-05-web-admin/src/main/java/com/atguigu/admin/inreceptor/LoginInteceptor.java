package com.atguigu.admin.inreceptor;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




/**
@Author: Lizhixiang
@Date: 2022/12/17
@Time: 17:05
@Description:登录检查
@Version:
*/
@Slf4j
public class LoginInteceptor implements HandlerInterceptor {
    /**
     * 目标方法执行之前
     *
     * 1.配置号拦截器要拦截哪些请求
     * 2.把这些配置放在容器中
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        log.info("拦截的请求路径是{}",requestURI);

        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");

        if (loginUser != null){
            return true;
        }else {
            request.setAttribute("msg","请先登录");
//            response.sendRedirect("/");
            request.getRequestDispatcher("/").forward(request,response);
            return false;
        }
    }

    /**
     * 目标方法执行之后，返回视图之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle",modelAndView);
    }


    /**
     * 整个流程执行完成之后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompleteion{}",ex);
    }
}