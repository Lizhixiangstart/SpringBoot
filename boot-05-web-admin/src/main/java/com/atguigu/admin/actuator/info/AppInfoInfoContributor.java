package com.atguigu.admin.actuator.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;

/**
 * @Author: Lizhixiang
 * @Date: 2022/12/26
 * @Time: 16:14
 * @Description:
 * @Version:
 */
@Component
public class AppInfoInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("msg","你好")
                .withDetail("hello","atguigu")
                .withDetails(Collections.singletonMap("world","666"));

    }
}