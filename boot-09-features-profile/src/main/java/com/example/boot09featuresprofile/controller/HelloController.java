package com.example.boot09featuresprofile.controller;

import com.example.boot09featuresprofile.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/26
 * @Time: 20:06
 * @Description:
 * @Version:
 */
@RestController
public class HelloController {
    @Value("${person.name:李四")
    private String name;

    @Value("${MAVEN_HOME}")
    private String msg;

    @Value("${os.name}")
    private String osName;

    @GetMapping("/msg")
    public String getMsg(){
        return msg+"===>"+osName;
    }

    @Resource
    private Person person;
    @GetMapping("/")
    public Person hello(){
        return person;
    }
}