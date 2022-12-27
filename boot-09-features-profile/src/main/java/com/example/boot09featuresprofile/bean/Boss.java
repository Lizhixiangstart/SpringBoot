package com.example.boot09featuresprofile.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/26
 * @Time: 20:37
 * @Description:
 * @Version:
 */
@Profile("test")
@ConfigurationProperties(prefix = "person")
@Component
public class Boss implements Person{
    private String name;
    private Integer age;

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}