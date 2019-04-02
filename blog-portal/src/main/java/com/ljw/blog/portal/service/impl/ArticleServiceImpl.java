package com.ljw.blog.portal.service.impl;
import com.ljw.blog.common.model.BArticle;
import com.ljw.blog.portal.mapper.ArticleMapper;
import com.ljw.blog.portal.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: lujunwei
 * @time: 10:40 2019/4/1
 * @des:
 */
@RestController
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<BArticle> articleQuery(BArticle article) {
        return articleMapper.articleQuery(article);
    }
}
