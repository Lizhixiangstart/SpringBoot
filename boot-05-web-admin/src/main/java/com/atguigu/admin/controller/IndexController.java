package com.atguigu.admin.controller;

import com.atguigu.admin.bean.Account;
import com.atguigu.admin.bean.City;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.service.AccountService;
import com.atguigu.admin.service.CityService;
import com.atguigu.admin.service.impl.AccountServiceImpl;
import com.atguigu.admin.service.impl.CityServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class IndexController {

    @Resource
    JdbcTemplate jdbcTemplate;

    @Resource
    AccountServiceImpl accountService;

    @Resource
    CityServiceImpl cityService;

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @PostMapping("/city")
    @ResponseBody
    public City saveCity(City city){
        cityService.saveCity(city);
        return city;
    }

    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id")Long id){
        return cityService.getById(id);
    }

    @GetMapping("/acct/{id}")
    @ResponseBody
    public Account getAccountById(@PathVariable("id") Integer id){
        return accountService.getAcctById(id);
    }

    @ResponseBody
    @RequestMapping("/sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account_tb1", Long.class);
        return aLong.toString();
    }

    /*
    * 发请求跳转到登陆页
    * */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){

        if(StringUtils.hasLength(user.getUserName()) && "123456".equals(user.getPassword())){
            //登陆成功重定向到主页,防止表单重复提交
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";
        }else {
            //回到登录页
            model.addAttribute("msg","账号密码错误");
            return "login";
        }

    }

    /*
    * 去main页面
    * */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
        log.info("当前方法是：{}","mainPage");
        //判断是否登录:拦截器、过滤器
       /* Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            return "main";
        } else {
            model.addAttribute("msg", "请重新登录");
            //回到登录页面
            return "login";
        }*/
        System.out.println("main");

        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        String mainCount = opsForValue.get("/main.html");
        String sqlCount = opsForValue.get("/sql");
        model.addAttribute("mainCount",mainCount);
        model.addAttribute("sqlCount",sqlCount);
        return "main";
    }
}
