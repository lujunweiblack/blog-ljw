package com.ljw.blog.portal.service.impl;

import com.ljw.blog.common.model.BAbout;
import com.ljw.blog.common.model.BArticle;
import com.ljw.blog.common.model.BLabel;
import com.ljw.blog.common.model.BLink;
import com.ljw.blog.common.vo.IndexVo;
import com.ljw.blog.portal.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: lujunwei
 * @Date: 16:01 2019/3/30
 * @Desc:
 */
@RestController
public class IndexServiceImpl implements IndexService {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private AboutService aboutService;
    @Autowired
    private LinkService linkService;
    @Autowired
    private LabelService labelService;

    /**
     * @author: lujunwei
     * @param: []
     * @return: java.lang.String
     * @time: 16:40 2019/3/30
     * @des: This is a function
     */
    @Override
    public IndexVo fillIndex() {
        BArticle article = new BArticle();
        IndexVo indexVo = new IndexVo();
        BAbout about = new BAbout();
        about.setAboutId(20000331);
        List<BAbout> abouts = aboutService.aboutQuery(about);
        List<BLink> links = linkService.linkQuery(null);
        List<BLabel> labels = labelService.labelQuery(null);
        article.setArticleType(0);
        List<BArticle> ordinaryArticles = articleService.articleQuery(article);
        article.setArticleType(1);
        List<BArticle> bannerWheelArticles = articleService.articleQuery(article);
        article.setArticleType(2);
        List<BArticle> bannerRightArticles = articleService.articleQuery(article);
        article.setArticleType(3);
        List<BArticle> specialRecoArticles = articleService.articleQuery(article);
        article.setArticleType(4);
        List<BArticle> recommendArticles = articleService.articleQuery(article);
        article.setArticleType(5);
        List<BArticle> clickRankArticles = articleService.articleQuery(article);
        indexVo.setBAbout(abouts != null && abouts.size() > 0 ? abouts.get(0) : new BAbout());
        indexVo.setBLinks(links);
        indexVo.setBLabels(labels);
        indexVo.setBannerRightArticles(bannerRightArticles);
        indexVo.setBannerWheelArticles(bannerWheelArticles);
        indexVo.setClickRankArticles(clickRankArticles);
        indexVo.setOrdinaryArticles(ordinaryArticles);
        indexVo.setRecommendArticles(recommendArticles);
        indexVo.setSpecialRecoArticles(specialRecoArticles);
        return indexVo;
    }
}
