package com.ljw.blog.api.api.impl;

import com.ljw.blog.api.api.*;
import com.ljw.blog.common.model.BAbout;
import com.ljw.blog.common.model.BArticle;
import com.ljw.blog.common.model.BLabel;
import com.ljw.blog.common.model.BLink;
import com.ljw.blog.common.vo.IndexVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: lujunwei
 * @Date: 16:01 2019/3/30
 * @Desc:
 */
@RestController
public class IndexApiImpl implements IndexApi {

    @Autowired
    private ArticleApi articleApi;
    @Autowired
    private AboutApi aboutApi;
    @Autowired
    private LinkApi linkApi;
    @Autowired
    private LabelApi labelApi;

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
        List<BAbout> abouts = aboutApi.aboutQuery(about);
        List<BLink> links = linkApi.linkQuery(null);
        List<BLabel> labels = labelApi.labelQuery(null);
        article.setArticleType(0);
        List<BArticle> ordinaryArticles = articleApi.articleQuery(article);
        article.setArticleType(1);
        List<BArticle> bannerWheelArticles = articleApi.articleQuery(article);
        article.setArticleType(2);
        List<BArticle> bannerRightArticles = articleApi.articleQuery(article);
        article.setArticleType(3);
        List<BArticle> specialRecoArticles = articleApi.articleQuery(article);
        article.setArticleType(4);
        List<BArticle> recommendArticles = articleApi.articleQuery(article);
        article.setArticleType(5);
        List<BArticle> clickRankArticles = articleApi.articleQuery(article);
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
