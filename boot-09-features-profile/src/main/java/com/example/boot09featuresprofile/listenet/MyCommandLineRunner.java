package com.example.boot09featuresprofile.listenet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/27
 * @Time: 19:12
 * @Description:
 * @Version:
 */
@Component
public class MyCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("MyCommandLineRunner...run...");
    }
}