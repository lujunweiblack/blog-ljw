package com.ljw.blog.portal.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @author: lujunwei
 * @time: 17:07 2019/4/10
 * @des:
 */
public interface ArticleLikeMapper {

    @Select(" select count(1) from b_article_like t where t.article_id= #{articleId}")
    Integer articleLikeQueryCount(long articleId);
}
