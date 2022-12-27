package com.example.boot05web01.controller;

import org.springframework.web.bind.annotation.*;

@RestController//@Controller+@ResponseBody
public class HelloController {

    @RequestMapping("/bug.jpg")
    public String hello(){
        return "外侧你们码";
    }

//    @RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping(value = "/user")
    public String getUser(){
        return "GET-张三";
    }

//    @RequestMapping(value = "/user",method = RequestMethod.POST)
    @PostMapping("/user")
    public String saveUser(){
        return "POST-张三";
    }

//    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    @PutMapping("/user")
    public String putUser(){
        return "PUT-张三";
    }

//    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    @DeleteMapping("/user")
    public String deleteUser(){
        return "Delete-张三";
    }
}
