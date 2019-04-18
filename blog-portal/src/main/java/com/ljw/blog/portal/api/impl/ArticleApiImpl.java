package com.ljw.blog.portal.api.impl;

import com.ljw.blog.common.model.BArticle;
import com.ljw.blog.portal.mapper.ArticleMapper;
import com.ljw.blog.common.inface.ArticleApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<BArticle> articleQuery(@RequestBody BArticle article) {
        return articleMapper.articleQuery(article);
    }

    @Override
    public long articleInsertByPrimaryKey(@RequestBody BArticle bArticle) {
        return articleMapper.updateByPrimaryKeySelective(bArticle);
    }

    @Override
    public int articleiNextId() {
        BArticle bArticle = new BArticle();
        articleMapper.articleiNextId(bArticle);
        return bArticle.getArticleId();
    }
}
