package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.exception.UserTooManyException;
import com.atguigu.admin.service.UserService;
import com.atguigu.admin.service.impl.UserServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/*
* 负责处理Table相关的页面跳转
* */
@Controller
public class TableController {

    @Resource
    UserService userService;





    /**
     * 将用户信息存入user表中重定向到dynamic_table
     * @return
     */
    @PostMapping("/save_user")
    public String  saveUser(User user){
        userService.saveUser(user);
        System.out.println(user);
        return "redirect:/dynamic_table";
    }



    @GetMapping("/insert_user")
    public String insertUser(){
        return "table/insert_user";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id")Long id
            , @RequestParam(value = "pn",defaultValue = "1") Integer pn
            , RedirectAttributes redirectAttributes
                             ){
        userService.removeById(id);


        /*
        * 删除操作完成后重定向会当前页面有两种方式：
        *   1.拼接字符串的方式将pn参数插入request请求中
        *   2.使用RedirectAttributes自动插入pn参数
        * */
        redirectAttributes.addAttribute("pn",pn);
//        return "redirect:/dynamic_table?pn="+pn;
        return "redirect:/dynamic_table";
    }

    /**
     * 不带请求参数或参数类型错误会出现badrequest错误(一般为浏览器参数错误)
     * @param
     * @return
     * @throws Exception
     */
    @GetMapping("/basic_table")/*@RequestParam("a")int a*/
    public String basic_table(HttpServletResponse response) throws IOException {//spring底层异常，由DefalutHandlerException处理
        //人为制造一个异常
        //int i = 10/0;
       // response.sendError(500,"我测你们码");
        return "table/basic_table";
    }


    /**
     *
     * @param model
     * @param pn   当前页面
     * @return
     */
    @GetMapping("/dynamic_table")
    public String  dynamic_table(Model model,@RequestParam(value = "pn",defaultValue = "1") Integer pn){


        /*//表格内容的遍历
        List<User> users = Arrays.asList(new User("张三", "123456"), new User("李四", "123444"),
                new User("王五", "141515"), new User("赵六", "11551"),
                new User("田七", "1515737"));
        model.addAttribute("users",users);
//        if (users.size()>3){
//            //被@ResponseStatus修饰的异常，由ResponseStatusExceptionResolver处理
//            throw new UserTooManyException();
//        }*/

        //从数据库中查询出员工渲染进页面中
       /* List<User> users = userService.list();
        model.addAttribute("users",users);*/

        //分页查询数据
        Page<User> userPage = new Page<User>(pn, 5);
        //分页查询的结构
        Page<User> page = userService.page(userPage, null);
        model.addAttribute("page",page);

        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){
        System.out.println("editable_table");
        return "table/editable_table";
    }

    @GetMapping("/pricing_table")
    public String pricing_table(){
        return "/table/pricing_table";
    }
}
