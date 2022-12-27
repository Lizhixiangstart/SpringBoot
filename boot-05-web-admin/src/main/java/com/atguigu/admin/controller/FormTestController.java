package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

/**
@Author: Lizhixiang
@Date: 2022/12/17
@Time: 21:46
@Description:文件上传测试
@Version:
*/
@Controller
@Slf4j
public class FormTestController {
    @GetMapping("/form_layouts")
    public String form_layout(){
        return "form/form_layouts";
    }

    /**
     * MultipartFile自动封装上传的文件
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email
            , @RequestParam("username") String username
            , @RequestPart("headerImg") MultipartFile headerImg
            , @RequestPart("photos") MultipartFile[] photos
                         ) throws IOException {
        log.info("上传的信息:email={},username={},headerImg={},photos={}",
                email,username,headerImg.getSize(),photos.length
                );

        if (!headerImg.isEmpty()){
            //保存文件到指定位置
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("F:\\cache\\"+originalFilename));
        }

        if (photos.length>0){
            for (MultipartFile photo : photos){
                if (!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("F:\\cache\\"+originalFilename));
                }
            }
        }

        return "redirect:main.html";
    }
}