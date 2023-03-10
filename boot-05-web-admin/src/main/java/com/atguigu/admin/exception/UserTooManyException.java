package com.atguigu.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
@Author: Lizhixiang
@Date: 2022/12/19
@Time: 19:40
@Description:
@Version:
*/
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户数量太多")
public class UserTooManyException extends RuntimeException{
    public UserTooManyException(String message) {
        super(message);
    }

    public UserTooManyException() {
    }
}