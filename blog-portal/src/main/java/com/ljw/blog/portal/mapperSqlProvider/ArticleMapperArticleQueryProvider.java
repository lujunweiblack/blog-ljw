package com.ljw.blog.portal.mapperSqlProvider;

import com.ljw.blog.common.model.BArticle;
import com.ljw.blog.common.tools.DataTools;

/**
 * @author: lujunwei
 * @time: 13:57 2019/4/18
 * @des: 动态sql编写
 */
public class ArticleMapperArticleQueryProvider {

    /**
     * @author: lujunwei
     * @param:
     * @return: 
     * @time: 14:01 2019/4/18
     * @des: This is a function
     */
    public String articleQuery(BArticle bArticle) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from b_article t where 1=1 ");
        if (DataTools.dataIsNotNullAndEmpty(bArticle.getArticleState())) {
            sql.append(" and t.article_state = #{articleState} ");
        }
        if (DataTools.dataIsNotNullAndEmpty(bArticle.getArticleType())) {
            sql.append(" and t.article_type = #{articleType} ");
        }
        if (DataTools.dataIsNotNullAndEmpty(bArticle.getArticleId())) {
            sql.append(" and t.article_id = #{articleId} ");
        }
        if (DataTools.dataIsNotNullAndEmpty(bArticle.getArticleTitleName())) {
            bArticle.setArticleTitleName("%"+bArticle.getArticleTitleName()+"%");
            sql.append(" and t.article_title_name like #{articleTitleName} ");
        }
        sql.append("order by t.article_id desc");
        return sql.toString();
    }

    /**
     * @author: lujunwei
     * @param:
     * @return:
     * @time: 14:01 2019/4/18
     * @des: This is a function
     */
    public String articleiAlreadyNextId(BArticle bArticle) {
        StringBuilder sql = new StringBuilder();
        sql.append("select t.article_id from b_article t where 1=1 and t.create_date is null");
        return sql.toString();
    }
}
