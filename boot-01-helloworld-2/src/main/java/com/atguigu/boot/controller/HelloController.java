package com.atguigu.boot.controller;

import com.atguigu.boot.bean.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController//@Controller+@ResponseBody
public class HelloController {

    @Resource
    Person person;

    @RequestMapping("/person")
    public Person person(){
        System.out.println(person.getUserName());
        return person;
    }
}
