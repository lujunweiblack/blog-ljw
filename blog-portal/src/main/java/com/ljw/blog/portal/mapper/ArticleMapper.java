package com.ljw.blog.portal.mapper;

import com.ljw.blog.common.model.BArticle;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ArticleMapper extends Mapper<BArticle> {

    @Select("select * from b_article t where t.article_type = #{articleType} and t.article_state=#{articleState} order by t.article_id desc")
    List<BArticle> articleQuery(BArticle article);

    int articleiNextId(BArticle bArticle);
}
