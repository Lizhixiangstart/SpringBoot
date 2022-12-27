package com.atguigu.admin.inreceptor;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/25
 * @Time: 17:16
 * @Description:
 * @Version:
 */
@Component
public class RedisUrlCountInterceptor implements HandlerInterceptor {
    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();

        //默认每次访问当前uri就会计数+1
        stringRedisTemplate.opsForValue().increment(requestURI);
        return true;
    }
}