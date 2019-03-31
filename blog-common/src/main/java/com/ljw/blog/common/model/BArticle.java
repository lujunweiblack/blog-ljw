package com.ljw.blog.common.model;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class BArticle {
    @Id
    private long articleId;
    private String articleTitleName;
    private String articleDetailUrl;
    private String articleIntroduction;
    private Integer articleState;
    private Integer articleType;
    private String browsePic01;
    private String browsePic02;
    private String browsePic03;
    private int authorId;
    private String authorName;
    private int categoryId;
    private int categoryName;
    private Date publishDate;
    private Date createDate;
    private Date updateDate;
}
