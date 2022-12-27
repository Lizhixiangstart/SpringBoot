package com.atguigu.admin;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.mapper.UserMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Map;

@SpringBootTest
@Slf4j
class Boot05WebAdminApplicationTests {
    @Resource
    JdbcTemplate template;

    @Resource
    DataSource dataSource;

    @Resource
    UserMapper userMapper;

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    Jedis jedis;

    @Resource
    StringRedisTemplate stringRedisTemplate;



    @Test
    void testStringRedisTemplate() throws JsonProcessingException {
        HashOperations<String, Object, Object> option = stringRedisTemplate.opsForHash();
        User user = new User();
        user.setName("万礼");
        user.setAge(20);
        user.setEmail("123@qq.com");
        user.setUserName("丁真");
        option.put("SpringBoot:user:1","userName",user.getUserName());
        option.put("SpringBoot:user:1","age", String.valueOf(user.getAge()));
        option.put("SpringBoot:user:1","email",user.getEmail());
        System.out.println("存入完成");
        Map<Object, Object> entries = option.entries("SpringBoot:user:1");
        System.out.println("enrties"+entries);
    }


    @Test
    void contextLoads() {
        //template.queryForObject("select * from account_tb1");
//        template.queryForList("select * from account_tb1",);
        Long aLong = template.queryForObject("select count(*) from account_tb1", Long.class);
        log.info("记录总数：{}",aLong);
        log.info("数据源类型:{}",dataSource.getClass());
    }


    @Test
    void testUserMapper(){
        User user = userMapper.selectById(1l);
        log.info("用户信息：{}",user.toString());
    }


    @Test
    void saveUser(){
        User user = new User();
        String name = "小胖";
        user.setAge(20);
        user.setEmail("123@qq.com");
        System.out.println("插入开始");
        for (int i=1;i<=500;i++){
            user.setName(name+i);
            userMapper.saveUser(user);
        }
        System.out.println("插入结束");
    }
}
