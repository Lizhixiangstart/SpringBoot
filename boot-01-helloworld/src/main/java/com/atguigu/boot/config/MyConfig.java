package com.atguigu.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Car;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration(proxyBeanMethods = true)//代表这是一个配置类   ==>   配置文件
/*
* 1.配置类里面使用@Bean注解再方法上给容器注册组件，默认也是是单实例的(singleton)
* 2.配置类本身也是组件
* 3.proxyBeanMethods:代理bean的方法
*       Full(proxyBeanMethod=true),【保证@Bean方法被调用多少次返回的组件都是单实例的】
*       Lite(proxyBeanMethod=false),【每个@Bean方法被调用多少次返回的组件都是新创建的】
*
* 4.@Import(User.class,DBHelper.class)
*       给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
* */
@ConditionalOnMissingBean (name = "pet")
@ImportResource("classpath:beans.xml")
//1.开启Car的属性配置功能
//2.把Car这个组件自动注册到容器中
@EnableConfigurationProperties(Car.class)
/*
* EnableConfigurationProperties可以声明第三方类，ConfigurationProperties只能作用域我们自定义类上
* */
@Import({User.class, DBHelper.class})
public class MyConfig {

    //外部无论对配置类中的组件注册方法调用多少次，都是从容器中获取
    //容器中添加组件，以方法名为组件id，返回值类型就是组件类型，返回值就是组件在容器中的实例
//    @Scope("singleton")
    @Bean("pet")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }


    @Bean("user")
    public User user01(){
        User zhangsan = new User("张三", 18);
        //User组件依赖Pet组件(Full模式)
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }

//    @Bean
//    public CharacterEncodingFilter filter(){
//        return null;
//    }


}
