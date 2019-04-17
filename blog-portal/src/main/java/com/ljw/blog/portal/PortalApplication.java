package com.ljw.blog.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author: lujunwei
 * @time: 9:54 2019/3/21
 * @des:
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableFeignClients
@MapperScan("com.ljw.blog.portal.mapper")
public class PortalApplication {
    public static void main(String[] args){
        SpringApplication.run(PortalApplication.class, args);
    }
}
