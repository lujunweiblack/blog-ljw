package com.ljw.blog.portal.ctrl;


import com.ljw.blog.common.inface.ArticleApi;
import com.ljw.blog.common.model.BArticle;
import com.ljw.blog.common.model.ResultBean;
import com.ljw.blog.common.vo.ArticlesVo;
import com.ljw.blog.portal.api.ArticleBrowseApi;
import com.ljw.blog.portal.api.ArticleLikeApi;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lujunwei
 * @time: 13:41 2019/3/20
 * @des:
 */
@RestController
@RequestMapping(value = "/portal")
public class ArticleCtrl {

    @Autowired
    private ArticleApi articleApi;
    @Autowired
    private ArticleLikeApi articleLikeApi;
    @Autowired
    private ArticleBrowseApi articleBrowseApi;

    /**
     * @author: lujunwei
     * @param: [article]
     * @return: java.lang.String
     * @time: 12:58 2019/4/17
     * @des: This is a function
     */
    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public String articleQuery(BArticle article) {
        List<BArticle> bArticles = articleApi.articleQuery(article);
        List<ArticlesVo> articlesVos = new ArrayList<>();
        for (BArticle b : bArticles) {
            ArticlesVo articlesVo = new ArticlesVo();
            BeanUtils.copyProperties(b, articlesVo);
            articlesVo.setArticleLikeCount(articleLikeApi.articleLikeQueryCount(b.getArticleId()));
            articlesVo.setArticleBrowseCount(articleBrowseApi.articleBrowseQueryCount(b.getArticleId()));
            articlesVos.add(articlesVo);
        }
        return ResultBean.resultInit(ResultBean.SUCCESS, articlesVos);
    }
}
