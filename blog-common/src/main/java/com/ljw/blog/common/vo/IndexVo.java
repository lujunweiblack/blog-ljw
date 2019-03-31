package com.ljw.blog.common.vo;

import com.ljw.blog.common.model.BAbout;
import com.ljw.blog.common.model.BArticle;
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
    private BLink bLink;
    private List<BArticle> ordinaryArticle;
    private List<BArticle> bannerWheelArticle;
    private List<BArticle> bannerRightArticle;
    private List<BArticle> specialRecoArticle;
    private List<BArticle> recommendArticle;
    private List<BArticle> clickRankArticle;
}
