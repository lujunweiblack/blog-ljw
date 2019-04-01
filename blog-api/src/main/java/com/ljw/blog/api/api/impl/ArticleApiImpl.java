package com.ljw.blog.api.api.impl;

import com.ljw.blog.api.api.ArticleApi;
import com.ljw.blog.api.mapper.ArticleMapper;
import com.ljw.blog.common.model.BArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: lujunwei
 * @time: 10:40 2019/4/1
 * @des:
 */
@RestController
public class ArticleApiImpl implements ArticleApi {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<BArticle> articleQuery(BArticle article) {
        return articleMapper.articleQuery(article);
    }
}
