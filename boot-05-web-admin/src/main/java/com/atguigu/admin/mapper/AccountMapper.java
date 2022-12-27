package com.atguigu.admin.mapper;

import com.atguigu.admin.bean.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/23
 * @Time: 14:35
 * @Description:
 * @Version:
 */
@Mapper
public interface AccountMapper {
    /**
     * 根据id获取account对象
     * @param id
     * @return
     */

    public Account getAccount(Integer id);
}
