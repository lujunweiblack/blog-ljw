package com.ljw.blog.portal.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @author: lujunwei
 * @time: 17:03 2019/4/10
 * @des:
 */
public interface ArticleBrowseMapper {

    @Select(" select count(1) from b_article_browse t where t.article_id= #{articleId}")
    Integer articleBrowseQueryCount(long articleId);
}
