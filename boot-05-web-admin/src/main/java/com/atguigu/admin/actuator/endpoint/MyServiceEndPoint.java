package com.atguigu.admin.actuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/26
 * @Time: 16:32
 * @Description:
 * @Version:
 */
@Endpoint(id = "myservice")
@Component
public class MyServiceEndPoint {
    @ReadOperation
    public Map getDockerInfo(){
        return Collections.singletonMap("dockerInfo","docker started....");
    }

    @WriteOperation
    public void stopDocker(){
        System.out.println("docker stoped....");
    }
}