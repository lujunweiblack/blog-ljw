package com.ljw.blog.manage.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.DispatcherType;

/**
 * @Author: lujunwei
 * @Date: 15:34 2019/5/1
 * @Desc:
 */
@Configuration
public class BeanRegisterConfig {
    @Bean
    public FilterRegistrationBean createFilterBean() {
        //过滤器注册类
        FilterRegistrationBean registration = new FilterRegistrationBean(new JwtFilter());
        registration.addUrlPatterns("/*");
        registration.setDispatcherTypes(DispatcherType.REQUEST);
        return registration;
    }
}
