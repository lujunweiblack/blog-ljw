package com.ljw.blog.portal.service;

import com.ljw.blog.common.vo.IndexVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author: lujunwei
 * @Date: 15:56 2019/3/30
 * @Desc:
 */
@FeignClient("blog-api")
public interface IndexService{

    @GetMapping("index")
    IndexVo fillIndex();

}
