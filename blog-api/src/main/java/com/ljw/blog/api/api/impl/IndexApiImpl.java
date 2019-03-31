package com.ljw.blog.api.api.impl;

import com.ljw.blog.api.api.AboutApi;
import com.ljw.blog.api.api.ArticleApi;
import com.ljw.blog.api.api.IndexApi;
import com.ljw.blog.api.api.LinkApi;
import com.ljw.blog.common.model.BAbout;
import com.ljw.blog.common.model.BArticle;
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
        article.setArticleType(0);
        List<BArticle> ordinaryArticle = articleApi.articleQuery(article);
        article.setArticleType(1);
        List<BArticle> bannerWheelArticle = articleApi.articleQuery(article);
        article.setArticleType(2);
        List<BArticle> bannerRightArticle = articleApi.articleQuery(article);
        article.setArticleType(3);
        List<BArticle> specialRecoArticle = articleApi.articleQuery(article);
        article.setArticleType(4);
        List<BArticle> recommendArticle = articleApi.articleQuery(article);
        article.setArticleType(5);
        List<BArticle> clickRankArticle = articleApi.articleQuery(article);
        indexVo.setBAbout(abouts != null && abouts.size() > 0 ? abouts.get(0) : new BAbout());
        indexVo.setBLink(links != null && links.size() > 0 ? links.get(0) : new BLink());
        indexVo.setBannerRightArticle(bannerRightArticle);
        indexVo.setBannerWheelArticle(bannerWheelArticle);
        indexVo.setClickRankArticle(clickRankArticle);
        indexVo.setOrdinaryArticle(ordinaryArticle);
        indexVo.setRecommendArticle(recommendArticle);
        indexVo.setSpecialRecoArticle(specialRecoArticle);
        return indexVo;
    }
}
