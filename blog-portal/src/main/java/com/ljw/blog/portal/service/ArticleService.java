package com.ljw.blog.portal.service;

import com.ljw.blog.api.api.ArticleApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: lujunwei
 * @time: 13:41 2019/3/20
 * @des:
 */
@FeignClient("blog-api")
public interface ArticleService extends ArticleApi {
    //一种是加入依赖关系 - 耦合性高 ,但是代码不会冗余, 缺点就是 ctrl和请求的微服务模块的路径必须一致
    //一种是不需要依赖微服务模块, 代码会有冗余, 但是请求路径可自定义,不需要于ctrl一致
}
