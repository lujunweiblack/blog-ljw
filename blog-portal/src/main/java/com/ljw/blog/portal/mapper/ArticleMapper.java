package com.ljw.blog.portal.mapper;

import com.ljw.blog.common.model.BArticle;
import com.ljw.blog.common.vo.BArticleVo;
import com.ljw.blog.portal.mapperSqlProvider.ArticleMapperArticleQueryProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ArticleMapper extends Mapper<BArticle> {

    @SelectProvider(type = ArticleMapperArticleQueryProvider.class, method = "articleQuery")
    List<BArticle> articleQuery(BArticle article);

    Integer articleiNextId(BArticle bArticle);

    @SelectProvider(type = ArticleMapperArticleQueryProvider.class, method = "articleiAlreadyNextId")
    Integer articleiAlreadyNextId(BArticle bArticle);

    @Update("update b_article t set t.publish_date = #{publishDate},t.article_state = #{articleState},t.update_date=#{updateDate} WHERE t.article_id = #{articleId}")
    int articleInsertByPrimaryKeyAndSql(BArticle bArticle);

    @SelectProvider(type = ArticleMapperArticleQueryProvider.class, method = "articleQueryPage")
    List<BArticle> articleQueryPage(BArticleVo articlevo);
}
