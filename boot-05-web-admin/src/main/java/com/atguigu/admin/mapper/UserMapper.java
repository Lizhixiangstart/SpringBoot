package com.atguigu.admin.mapper;

import com.atguigu.admin.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/23
 * @Time: 22:00
 * @Description:
 * @Version:
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Insert("insert into user(name,age,email) values(#{name},#{age},#{email})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void saveUser(User user);
}
