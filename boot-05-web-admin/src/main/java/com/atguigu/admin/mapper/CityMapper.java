package com.atguigu.admin.mapper;

import com.atguigu.admin.bean.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;


/**
 * @Author: Lizhixiang
 * @Date: 2022/12/23
 * @Time: 18:39
 * @Description:
 * @Version:
 */
@Mapper
public interface CityMapper {
    @Select("select * from city where id = #{id}")
    public City getById(Long id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Select("insert into city(name,state,country) values(#{name},#{state},#{country})")
    public void insert(City city);

}
