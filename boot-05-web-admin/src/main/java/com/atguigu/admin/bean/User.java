package com.atguigu.admin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
/**
 * User类属性由两部分组成，userName、password为web中使用
 * 另一部分对应数据库中user表
 *
 */
@TableName("user")
public class User {
    @TableField(exist = false)//用于判断当前字段是否存在于表中，默认为true
    private String userName;
    @TableField(exist = false)
    private String password;


    //以下是数据库的字段
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
