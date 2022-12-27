package com.atguigu.admin.config;

import com.atguigu.admin.inreceptor.LoginInteceptor;
import com.atguigu.admin.inreceptor.RedisUrlCountInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
@Author: Lizhixiang
@Date: 2022/12/17
@Time: 17:16
@Description:
@Version:
*/

/*
    使用步骤：
        1.编写一个拦截器实现HandlerInteceptor接口(和springmvc中一样)
        2.拦截器注册到容器中(实现HandlerInceptor的类)
        3.指定拦截规则(需要拦截和需要放行的配置)
@EnableWebMvc:全面接管mvc
 */
@Configuration
//@EnableWebMvc
public class AdminWebConfig implements WebMvcConfigurer {
    /**
     * filter和interceptor几乎拥有相同的功能？
     * 1、Filter是Servlet定义的原生组件。好处：脱离Spring也能使用
     * 2、Interceptor是Spring定义的接口。可以使用Spring的自动装配功能
     */
    @Resource
    RedisUrlCountInterceptor redisUrlCountInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInteceptor())
                .addPathPatterns("/**")// 所有请求都会被拦截，包括静态资源
                .excludePathPatterns("/login","/","/css/**","/fonts/**","/images/**","/js/**","/form/**","/aa/**","/sql/**","/acct/**");//放行的路径


        registry.addInterceptor(redisUrlCountInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login","/","/css/**","/fonts/**","/images/**","/js/**","/form/**","/aa/**","/acct/**");//放行的路径

    }

    /**
     * 定义静态资源行为
     * @param registry
     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/aa/**")
//                /*
//                * 访问aa下的所有请求都去static下面匹配
//                * */
//                .addResourceLocations("classpath:/static/");
//    }
}