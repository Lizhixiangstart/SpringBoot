package com.atguigu.admin.service;

import com.atguigu.admin.bean.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/23
 * @Time: 22:36
 * @Description:
 * @Version:
 */

public interface UserService extends IService<User> {

    public void saveUser(User user);
}