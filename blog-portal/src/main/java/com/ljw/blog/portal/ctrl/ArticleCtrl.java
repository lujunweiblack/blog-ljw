package com.ljw.blog.portal.ctrl;


import com.ljw.blog.common.model.BArticle;
import com.ljw.blog.common.model.ResultBean;
import com.ljw.blog.common.vo.ArticlesVo;
import com.ljw.blog.portal.service.ArticleBrowseService;
import com.ljw.blog.portal.service.ArticleLikeService;
import com.ljw.blog.portal.service.ArticleService;
import com.sun.scenario.effect.impl.state.LinearConvolveKernel;
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
    private ArticleService articleService;
    @Autowired
    private ArticleLikeService articleLikeService;
    @Autowired
    private ArticleBrowseService articleBrowseService;

    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public String articleQuery(BArticle article) {
        List<BArticle> bArticles = articleService.articleQuery(article);
        List<ArticlesVo> articlesVos = new ArrayList<>();
        for (BArticle b : bArticles) {
            ArticlesVo articlesVo = new ArticlesVo();
            BeanUtils.copyProperties(b, articlesVo);
            articlesVo.setArticleLikeCount(articleLikeService.articleLikeQueryCount(b.getArticleId()));
            articlesVo.setArticleBrowseCount(articleBrowseService.articleBrowseQueryCount(b.getArticleId()));
            articlesVos.add(articlesVo);
        }
        return ResultBean.resultInit(ResultBean.SUCCESS, articlesVos);
    }
}
