package com.ljw.blog.manage.service;

import com.ljw.blog.common.model.BArticle;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author: lujunwei
 * @time: 13:41 2019/3/20
 * @des:
 */
@FeignClient("blog-portal")
public interface ArticleService {

    @GetMapping("/portal/api/article")
    List<BArticle> articleQuery(@Param("article") BArticle article);
    //一种是加入依赖关系 - 耦合性高 ,但是代码不会冗余, 缺点就是 ctrl和请求的微服务模块的路径必须一致
    //一种是不需要依赖微服务模块, 代码会有冗余, 但是请求路径可自定义,不需要于ctrl一致
}

