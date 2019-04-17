package com.ljw.blog.manage.api;

import com.ljw.blog.common.inface.ArticleApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: lujunwei
 * @time: 13:41 2019/3/20
 * @des:
 */
@FeignClient("blog-portal")
public interface ArticleFeignClientApi extends ArticleApi {
}

