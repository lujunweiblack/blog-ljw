package com.ljw.blog.portal.service.impl;

import com.ljw.blog.portal.mapper.ArticleBrowseMapper;
import com.ljw.blog.portal.service.ArticleBrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lujunwei
 * @time: 17:02 2019/4/10
 * @des:
 */
@Service
public class ArticleBrowseServiceImpl implements ArticleBrowseService {

    @Autowired
    private ArticleBrowseMapper articleBrowseMapper;

    @Override
    public Integer articleBrowseQueryCount(long articleId) {
        return articleBrowseMapper.articleBrowseQueryCount(articleId);
    }
}
