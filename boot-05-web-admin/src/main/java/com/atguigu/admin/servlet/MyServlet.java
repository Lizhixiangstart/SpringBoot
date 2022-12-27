package com.atguigu.admin.servlet;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
@Author: Lizhixiang
@Date: 2022/12/20
@Time: 14:39
@Description:
 1.MyServlet-->/my
 2.DispatcherServlet-->/
@Version:
*/
@WebServlet(urlPatterns = "/my")

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("666");
    }
}