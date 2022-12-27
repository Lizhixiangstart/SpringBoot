package com.example.boot09featuresprofile.listenet;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/27
 * @Time: 19:04
 * @Description:
 * @Version:
 */
public class MyApplicationListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("MyApplicationListener...onApplicationEvent...");

    }
}