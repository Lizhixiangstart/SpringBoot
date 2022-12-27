package com.atguigu.admin.bean;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
@Author: Lizhixiang
@Date: 2022/12/23
@Time: 14:36
@Description:
@Version:
*/
@Data
@Repository
public class Account {
    private Integer id;
    private String userId;
    private String money;
}