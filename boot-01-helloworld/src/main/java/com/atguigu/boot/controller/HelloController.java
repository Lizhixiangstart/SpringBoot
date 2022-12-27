package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@ResponseBody
@Slf4j
@Controller
public class HelloController {

    @Resource
    Car car;


    @RequestMapping("/car")
    public Car car(){
        return car;
    }

    @RequestMapping("hello")
    public String handle01(@RequestParam(value = "name" ,defaultValue = "理塘丁真",required = false)String name){
        log.info("请求进来了。。。");
        return "Hello Spring Boot2"+"你好"+name;

    }
}
