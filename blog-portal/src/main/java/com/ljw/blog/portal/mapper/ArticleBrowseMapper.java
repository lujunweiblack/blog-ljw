package com.ljw.blog.portal.mapper;

import com.ljw.blog.common.model.BArticleBrowse;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author: lujunwei
 * @time: 17:03 2019/4/10
 * @des:
 */
public interface ArticleBrowseMapper extends Mapper<BArticleBrowse> {

    @Select(" select count(1) from b_article_browse t where t.article_id= #{articleId}")
    Integer articleBrowseQueryCount(long articleId);

    @Select(" select count(1) from b_article_browse t where t.article_id= #{articleId} and t.client_ip = #{clientIp} and t.client_id = #{clientId} and t.client_name = #{clientName} and DATE_FORMAT(t.create_date,'%Y-%m-%d') = DATE_FORMAT(SYSDATE(),'%Y-%m-%d') ")
    Integer articleBrowseDistinct(BArticleBrowse articleBrowse);
}
