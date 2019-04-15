package com.ljw.blog.manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author: lujunwei
 * @time: 9:54 2019/3/21
 * @des:
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.ljw.blog.manage.mapper")
public class ManageApplication {
    public static void main(String[] args){
        SpringApplication.run(ManageApplication.class, args);
    }
}
