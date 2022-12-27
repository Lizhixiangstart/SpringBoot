package com.atguigu.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor//无参构造器
@AllArgsConstructor//全参构造器
@ToString
@Data
public class Pet {
    private String name;


}
