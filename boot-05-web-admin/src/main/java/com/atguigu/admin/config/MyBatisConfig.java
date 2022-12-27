package com.atguigu.admin.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/24
 * @Time: 14:38
 * @Description:MyBatis分页插件(SpringBoot实现方式)
 * @Version:
 */
@Configuration
public class MyBatisConfig {
    @Bean
    public MybatisPlusInterceptor paginationInnerInterceptor(){
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        //设置请求的页面大于最大页后操作，true调回到首页，false继续请求，默认false
        //paginationInterceptor.setOverflow(false)
        //设置最大单页限制数量，默认500 条 -1 不受限制
        //paginationInterceptor.setLimit(500);
        //开启count的join优化，只针对部分Left join

        //这是分页拦截器
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
        paginationInnerInterceptor.setOverflow(true);
        paginationInnerInterceptor.setMaxLimit(500L);//分页最多显示多少条查询结果
        mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);
        return mybatisPlusInterceptor;
    }
}