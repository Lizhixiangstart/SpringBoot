package com.example.boot09featuresprofile.config;

import com.example.boot09featuresprofile.bean.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


/**
 * @Author: Lizhixiang
 * @Date: 2022/12/26
 * @Time: 20:42
 * @Description:
 * @Version:
 */
@Configuration
public class MyConfig {



    @Profile("prod")
    @Bean
    public Color red(){
        return new Color();
    }

    @Profile("test")
    @Bean
    public Color green(){
        return new Color();
    }
}