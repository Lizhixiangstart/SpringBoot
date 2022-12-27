package com.example.boot09featuresprofile.listenet;

import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/27
 * @Time: 19:03
 * @Description:
 * @Version:
 */
public class ApplicationContextInitializer implements org.springframework.context.ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ApplicationContextInitializer...initialize...");
    }
}