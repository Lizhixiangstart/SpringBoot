package com.example.boot09featuresprofile.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/26
 * @Time: 20:30
 * @Description:
 * @Version:
 */


public interface Person {
    String getName();
    Integer getAge();
}