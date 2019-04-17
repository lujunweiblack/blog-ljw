package com.ljw.blog.portal.api.impl;

import com.ljw.blog.portal.mapper.ArticleLikeMapper;
import com.ljw.blog.portal.api.ArticleLikeApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lujunwei
 * @time: 17:06 2019/4/10
 * @des:
 */
@Service
public class ArticleLikeApiImpl implements ArticleLikeApi {

    @Autowired
    private ArticleLikeMapper articleLikeMapper;
    @Override
    public Integer articleLikeQueryCount(long articleId) {
        return articleLikeMapper.articleLikeQueryCount(articleId);
    }
}
