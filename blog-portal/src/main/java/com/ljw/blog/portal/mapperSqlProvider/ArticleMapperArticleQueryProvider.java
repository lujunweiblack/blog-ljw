package com.ljw.blog.portal.mapperSqlProvider;

import com.ljw.blog.common.model.BArticle;

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
        sql.append("select * from b_article t where t.article_type = #{articleType} ");
        if (bArticle.getArticleState() != null && !"".equals(bArticle.getArticleState())) {
            sql.append(" and t.article_state = #{articleState} ");
        }
        sql.append("order by t.article_id desc");
        return sql.toString();
    }
}
