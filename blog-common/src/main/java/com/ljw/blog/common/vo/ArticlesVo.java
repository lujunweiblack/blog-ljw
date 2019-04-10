package com.ljw.blog.common.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author: lujunwei
 * @time: 16:57 2019/4/10
 * @des:
 */
@Data
public class ArticlesVo {
    private long articleId;
    private String articleTitleName;
    private String articleIntroduction;
    private String authorName;
    private String categoryName;
    private Date publishDate;
    private Integer articleBrowseCount;
    private Integer articleLikeCount;
}
