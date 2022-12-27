package com.atguigu.admin;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/25
 * @Time: 20:20
 * @Description:
 * @Version:
 */
/*Runwith*/
@DisplayName("Junit5功能测试类")
//@SpringBootTest
public class Junit5Test {



    @Resource
    JdbcTemplate jdbcTemplate;


    int cal(int i,int j){
        return i+j;
    }

    @DisplayName("测试前置条件")
    @Test
    void testAssumption(){
        Assumptions.assumeTrue(true,"结果不是true");
        System.out.println("11111");
    }

    @DisplayName("快速失败")
    @Test
    void testFaild(){
        if (2==2)
        fail("测试失败");
    }

    @DisplayName("异常断言")
    @Test
    void testException(){
        assertThrows(ArithmeticException.class,()->{int i= 10/2;},"业务逻辑居然正常运行了");
    }

    @DisplayName("组合断言")
    @Test
    void all(){
        assertAll("测试多个断言",
                ()->assertTrue(true || false,"结果部位true"),
                ()->assertEquals(1,1,"结果不是1")
                );
    }


    @DisplayName("数组断言方法测试")
    @Test
    void array(){
        Assertions.assertArrayEquals(new int[]{2,1},new int[]{1,2},"数组内容不相等");
    }


    /**
     * 断言:前面断言失败,后面的代码都不会执行,方法直接返回
     */
    @DisplayName("测试简单断言")
    @Test
    void testSimpleAssertions(){
        int cal = cal(2, 3);
        //相等
        assertEquals(5,cal,"业务逻辑计算失败");
        Object obj1 = new Object();
        Object obj2 = new Object();
        assertSame(obj1,obj2,"两个对象不一样");
    }

    @DisplayName("测试displayname注解")
    @Test
     void testDisplayName(){
        System.out.println(1);
        System.out.println(jdbcTemplate);
    }

    @Disabled
    @Test
    void testDisabled(){
        System.out.println("该方法失效,不会被执行");
    }

    @Test
    @DisplayName("测试方法2")
    void test2(){
        System.out.println(2);
    }

    @RepeatedTest(value = 3)//value为方法重复执行的次数
    void test3(){
        System.out.println(5);
    }


    /**
     * 规定方法超时时间
     * @throws InterruptedException
     */
    @Timeout(value = 5,unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeout() throws InterruptedException {
        Thread.sleep(600);
    }

    @BeforeEach
    void testBeforeEach(){
        System.out.println("测试就要开始了...");
    }

    @AfterEach
    void testAfterEach(){
        System.out.println("测试就要结束了...");
    }

    @BeforeAll
    static void testBeforeAll(){
        System.out.println("所有测试就要开始了...");
    }

    @AfterAll
    static void testAfterAll(){
        System.out.println("所有测试就要结束了...");
    }

}