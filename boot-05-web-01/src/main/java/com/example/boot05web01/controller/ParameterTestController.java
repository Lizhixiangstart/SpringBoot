package com.example.boot05web01.controller;

import com.example.boot05web01.bean.Person;
import org.springframework.web.bind.annotation.*;


import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController//@Controller+@ResponseBody
public class ParameterTestController {

    @PostMapping ("/saveuser")
    public Person saveUser(Person person){
        return person;
    }


    @GetMapping("/car/{id}/owner/{username}")
    public Map<String,Object> gerCar(@PathVariable("id") Integer id,
                                     @PathVariable("username")String name,
                                     @PathVariable Map<String,String> pv,
                                     @RequestHeader("User-Agent") String userAgent,
                                     @RequestHeader Map<String,String> haeder,
                                     @RequestParam("age") Integer age,
                                     @RequestParam("interests") String interests,
                                     @RequestParam Map<String,String> params
                                     ){
        Map<String,Object> map = new HashMap<>();

        map.put("id",id);
        map.put("name",name);
        map.put("pv",pv);
        map.put("userAgent",userAgent);
        map.put("headers",haeder);
        map.put("age",age);
        map.put("interests",interests);
        map.put("params",params);
    return  map;
    }

    @PostMapping("/save")//ps:只有post请求才有请求体
    public Map postMethod(@RequestBody String content){
        HashMap<String, Object> map = new HashMap<>();
        map.put("content", URLDecoder.decode(content));
        return map;
    }


    //SpringBoot配置用于支持矩阵变量
    //1.语法：  /cars/sell;low=34;brand=byd,audi,yd
    //2.SpringBoot默认矩阵变量
    //      手动开启：原理。对于路径的处理。URLPathHealper进行解析
    //              setRemoveSemicolonContent（移除分号内容）用于支持矩阵变量
    //3.矩阵变量必须要有URL路径才能解析
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path
    ){
        HashMap<String, Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }

    //  /boss/1;age=20/2;age=10
    //当矩阵变量中有两个相同的变量名的时候可以使用pathVar指定变量是哪个路径下的
    @PostMapping ("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empId") Integer empAge
                    ){
        HashMap<String, Object> map = new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;
    }


}
