package com.atguigu.admin.service.impl;

import com.atguigu.admin.bean.Account;
import com.atguigu.admin.mapper.AccountMapper;
import com.atguigu.admin.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/23
 * @Time: 22:38
 * @Description:
 * @Version:
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Resource
    AccountMapper accountMapper;
    @Override
    public Account getAcctById(Integer id){
        return accountMapper.getAccount(id);
    }
}