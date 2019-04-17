package com.ljw.blog.common.model;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class BArticle{
    @Id
    private Integer articleId;
    private String articleTitleName;
    private String articleDetailUrl;
    private String articleIntroduction;
    private Integer articleState;
    private Integer articleType;
    private Integer authorId;
    private String authorName;
    private Integer categoryId;
    private String categoryName;
    private Date publishDate;
    private String backupFieldOne;
    private String backupFieldTwo;
    private Date createDate;
    private Date updateDate;
}
