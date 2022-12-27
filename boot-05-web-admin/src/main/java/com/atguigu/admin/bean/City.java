package com.atguigu.admin.bean;

import lombok.Data;
import org.springframework.stereotype.Repository;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/23
 * @Time: 18:37
 * @Description:
 * @Version:
 */
@Data
@Repository
public class City {
    private Long id;
    private String name;
    private String state;
    private String country;
}