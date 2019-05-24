package com.ljw.blog.portal.api;

import com.ljw.blog.common.model.BArticleBrowse;

/**
 * @author: lujunwei
 * @time: 16:55 2019/4/10
 * @des:
 */
public interface ArticleBrowseApi {
    Integer articleBrowseQueryCount(long articleId);

    int articleBrowseInsert(BArticleBrowse articleBrowse);

    Integer articleBrowseDistinct(BArticleBrowse articleBrowse);
}

