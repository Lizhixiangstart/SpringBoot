package com.atguigu.boot.bean;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
/*
* 只有在容器中的组件才能使用SpringBoot提供的功能，因此
* 使用@ConfigurationPropertied之间要先将该类配置到SPring容器中
* */
//作用范围只在application.properties中
@PropertySource("classpath:application.properties")
/*
* 从properties中读取配置文件，注入到实例Bean中
* 方式1：使用@ConfigurationProperties(prefix = "mycar")
* 方式2：使用ssm框架中的@PropertiesRescurce+@Value
* */
@Data
@ToString
@Component
@ConfigurationProperties(prefix = "mycar")
public class Car {
//    @Value("${mycar.brand}")
    private String brand;

//    @Value("${mycar.price}")
    private Integer price;



    public Car() {
    }

    public Car(String brand, Integer price) {
        this.brand = brand;
        this.price = price;
    }
}
