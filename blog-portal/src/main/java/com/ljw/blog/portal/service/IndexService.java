package com.ljw.blog.portal.service;

import com.ljw.blog.api.api.IndexApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author: lujunwei
 * @Date: 15:56 2019/3/30
 * @Desc:
 */
@FeignClient("blog-api")
public interface IndexService extends IndexApi {
}
