package com.example.boot05web01.controller;

import com.example.boot05web01.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class ResponseController {

    /*
    * 1.如果是浏览器发送请求：返回xml【application/xml】       jaacksonXmlConverter
    * 2.如果是ajax发送请求：返回json【application/json】       jacksonJsonConverter
    * 3.如果硅谷app发请求，返回自定义数据【applition/x-guigu】   xxxConverter
    *           属性值1;属性值2;
    * 步骤：
    * 1.添加自定义MessageConverter进入系统底层
    * 2.系统底层就能统计出所有的MessageConverter能进行哪些操作
    * 3.客户端内容协商
    * */
    @ResponseBody
    @GetMapping("/test/person")
    public Person person(){
        Person person = new Person();
        person.setUserName("张三");
        person.setAge(28);
        person.setBirth(new Date());
        return person;
    }

}
