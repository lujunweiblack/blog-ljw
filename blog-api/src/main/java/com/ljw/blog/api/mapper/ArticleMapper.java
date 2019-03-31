package com.ljw.blog.api.mapper;

import com.ljw.blog.common.model.BArticle;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleMapper {

    @Select("select * from b_article t where article_type = #{articleType}")
    List<BArticle> articleQuery(BArticle article);
}
