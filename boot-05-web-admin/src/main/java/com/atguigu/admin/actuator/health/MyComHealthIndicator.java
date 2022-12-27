package com.atguigu.admin.actuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/26
 * @Time: 15:55
 * @Description:
 * 在Health端点中开启新的选项需要先继承AbstractHealthIndicator
 * 且类名必须为xxxHealthIndicator，health监控项中的名称为xxx(小写)
 * @Version:
 */
@Component
public class MyComHealthIndicator extends AbstractHealthIndicator {
    /**
     * 真实的检查方法
     * @param builder
     * @throws Exception
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        //mongodb;获取连接进行测试
        HashMap<String, Object> map = new HashMap<>();
        if (1==1){
            //builder.up();
            builder.status(Status.UP);
            map.put("count",1);
            map.put("ms",100);
        }else {
            builder.down();
            map.put("err","连接超时");
            map.put("ms",3000);
        }

        builder.withDetail("code",100).withDetails(map);
    }
}