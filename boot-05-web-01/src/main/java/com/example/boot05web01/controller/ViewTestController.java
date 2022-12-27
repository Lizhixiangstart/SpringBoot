package com.example.boot05web01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ViewTestController {

    @GetMapping("/atguigu")
    public String atguigu(Model model){
        //model中的数据会被存放在请求域中；request.setAttribute("a",a)
        model.addAttribute("msg","你好,atguigu");
        model.addAttribute("link","http://www.baidu.com");
        return "success";
    }
}
