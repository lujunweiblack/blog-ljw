package com.ljw.blog.portal.api.impl;

import com.ljw.blog.common.model.BArticle;
import com.ljw.blog.common.tools.DataTools;
import com.ljw.blog.portal.mapper.ArticleMapper;
import com.ljw.blog.common.inface.ArticleApi;
import org.apache.commons.lang.StringUtils;
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
        //先查询文章表中是否存在已经生成的主键
        Integer articleId = articleMapper.articleiAlreadyNextId(bArticle);
        if (DataTools.dataIsNotNullAndEmpty(articleId )) {
            return articleId;
        } else {
            articleMapper.articleiNextId(bArticle);
            return bArticle.getArticleId();
        }
    }
}
