package com.ljw.blog.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author: lujunwei
 * @time: 13:28 2019/3/20
 * @des:
 */

@MapperScan("com.ljw.blog.user.mapper")
@SpringBootApplication
@EnableDiscoveryClient // 开启EurekaClient功能
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
