package com.ljw.blog.api.api;

import com.ljw.blog.common.model.BArticle;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author: lujunwei
 * @time: 9:54 2019/3/21
 * @des:
 */
public interface ArticleApi {
    @GetMapping(value = "/article")
    List<BArticle> articleQuery(@RequestParam("article") BArticle article);
}
