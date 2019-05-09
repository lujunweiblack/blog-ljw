package com.ljw.blog.common.inface;

import com.ljw.blog.common.model.BArticle;
import com.ljw.blog.common.vo.BArticleVo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author: lujunwei
 * @time: 13:41 2019/3/20
 * @des:
 */
public interface ArticleApi {

    @GetMapping(value = "/portal/api/article",consumes = MediaType.APPLICATION_JSON_VALUE)
    List<BArticle> articleQuery(BArticle article);

    @PostMapping(value = "/portal/api/article", consumes = MediaType.APPLICATION_JSON_VALUE)
    long articleInsertByPrimaryKey(BArticle bArticle);

    @PostMapping(value = "/portal/api/articleiNextId", consumes = MediaType.APPLICATION_JSON_VALUE)
    int articleiNextId();

    @PostMapping(value = "/portal/api/article/sql", consumes = MediaType.APPLICATION_JSON_VALUE)
    int articleInsertByPrimaryKeyAndSql(BArticle bArticle);

    @GetMapping(value = "/portal/api/article/page",consumes = MediaType.APPLICATION_JSON_VALUE)
    String articleQueryPage(BArticleVo articlevo);
}

