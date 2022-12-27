package com.atguigu.admin.service.impl;

import com.atguigu.admin.bean.City;
import com.atguigu.admin.mapper.CityMapper;
import com.atguigu.admin.service.CityService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/23
 * @Time: 22:39
 * @Description:
 * @Version:
 */
@Service
public class CityServiceImpl implements CityService {
    @Resource
    CityMapper cityMapper;

    Counter counter;

    public CityServiceImpl(MeterRegistry meterRegistry){
        Counter counter = meterRegistry.counter("cityService.saveCity.count");
    }
    public City getById(Long id){
        return cityMapper.getById(id);
    }

    public void saveCity(City city){
        counter.increment();
        cityMapper.insert(city);
    }
}