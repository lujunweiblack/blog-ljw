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
    private int authorId;
    private String authorName;
    private int categoryId;
    private String categoryName;
    private Date publishDate;
    private String backupField01;
    private String backupField02;
    private String backupField03;
    private Date createDate;
    private Date updateDate;
}
