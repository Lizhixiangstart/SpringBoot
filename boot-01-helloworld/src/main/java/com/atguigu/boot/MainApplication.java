package com.atguigu.boot;

import ch.qos.logback.core.db.DBHelper;
import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import com.atguigu.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/*
* @SpringBootApplication  标识当前是一个SpringBoot程序
* */
@SpringBootApplication(scanBasePackages = ("com.atguigu"))

/*
* @SpringBootApplication(scanBasePackages = ("com.atguigu")) =
* @SpringBootConfiguration@EnableAutoConfiguration@ComponentScan("com.atguigu")
* */

public class MainApplication {
    public static void main(String[] args) {
        //1.返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        //2.查看容器里面的组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        //从容器中获取组件
        User user01 = (User) run.getBean("user");
        System.out.println(user01);
        Pet tomcat = (Pet) run.getBean("pet");
        System.out.println(tomcat);

        //组测组件默认是单实例的使用@Scope("singleton|prototype")指定实例对象是单例还是多例
        User user011 = (User) run.getBean("user");
        System.out.println("User组件实例："+(user011==user01));
        Pet pet1 = run.getBean("pet", Pet.class);
        System.out.println("Pet组件实例："+(tomcat==pet1));

        //如果Configuration(proxyBeanMethods = true)，代理对象调用方法。SpringBoot总会检查这个组件是否再容器中有
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println("MyConfig"+bean);
        User user = bean.user01();
        User user1 = bean.user01();
        System.out.println("user == user1："+(user==user1));
        User user2 = run.getBean("user", User.class);
        Pet pet = run.getBean("pet", Pet.class);
        System.out.println("用户宠物是否是容器宠物:"+(user2.getPet()==pet));

        //从容器中获取组件
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        System.out.println("===================");
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        String[] beanNamesForType1 = run.getBeanNamesForType(DBHelper.class);
        System.out.println("===================");
        for (String s : beanNamesForType1) {
            System.out.println(s);
        }

        boolean pet2 = run.containsBean("pet");
        System.out.println("容器中是否有pet组件："+pet2);
        Pet pet3 = run.getBean("pet", Pet.class);
        System.out.println(pet3);

        boolean user3 = run.containsBean("user");
        System.out.println("容器中是否有user组件："+user3);
        User user4 = run.getBean("user", User.class);
        System.out.println(user4);

        System.out.println("查看bean.xml文件中的Bean是否会被装配到SPring容器中");
        boolean isHaha = run.containsBean("haha");
        boolean isHehe = run.containsBean("hehe");
        System.out.println("isHaha:"+isHaha);
        System.out.println("isHehe:"+isHehe);

    }
}
