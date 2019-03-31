package com.ljw.blog.common.vo;

import com.ljw.blog.common.model.BAbout;
import com.ljw.blog.common.model.BArticle;
import com.ljw.blog.common.model.BLabel;
import com.ljw.blog.common.model.BLink;
import lombok.Data;

import java.util.List;

/**
 * @Author: lujunwei
 * @Date: 16:47 2019/3/30
 * @Desc:
 */
@Data
public class IndexVo {
    private BAbout bAbout;
    private List<BLink> bLinks;
    private List<BLabel> bLabels;
    private List<BArticle> ordinaryArticles;
    private List<BArticle> bannerWheelArticles;
    private List<BArticle> bannerRightArticles;
    private List<BArticle> specialRecoArticles;
    private List<BArticle> recommendArticles;
    private List<BArticle> clickRankArticles;
}
