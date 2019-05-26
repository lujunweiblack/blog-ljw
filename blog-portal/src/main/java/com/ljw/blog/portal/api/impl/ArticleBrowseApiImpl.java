package com.ljw.blog.portal.api.impl;

import com.ljw.blog.common.model.BArticleBrowse;
import com.ljw.blog.portal.mapper.ArticleBrowseMapper;
import com.ljw.blog.portal.api.ArticleBrowseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author: lujunwei
 * @time: 17:02 2019/4/10
 * @des:
 */
@Service
public class ArticleBrowseApiImpl implements ArticleBrowseApi {

    @Autowired
    private ArticleBrowseMapper articleBrowseMapper;

    @Override
    public Integer articleBrowseQueryCount(long articleId) {
        return articleBrowseMapper.articleBrowseQueryCount(articleId);
    }
    @Override
    public int articleBrowseInsert(BArticleBrowse articleBrowse) {
        Date date = new Date();
        articleBrowse.setUpdateDate(date);
        articleBrowse.setCreateDate(date);
        return articleBrowseMapper.insert(articleBrowse);
    }

    @Override
    public Integer articleBrowseDistinct(BArticleBrowse articleBrowse) {
        return articleBrowseMapper.articleBrowseDistinct(articleBrowse);
    }
}
