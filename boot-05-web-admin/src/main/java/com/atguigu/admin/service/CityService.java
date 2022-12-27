package com.atguigu.admin.service;

import com.atguigu.admin.bean.City;


/**
 * @Author: Lizhixiang
 * @Date: 2022/12/23
 * @Time: 18:42
 * @Description:
 * @Version:
 */

public interface CityService {

    public City getById(Long id);

    public void saveCity(City city);
}