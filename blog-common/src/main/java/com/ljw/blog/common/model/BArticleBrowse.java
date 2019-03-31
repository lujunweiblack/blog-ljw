package com.ljw.blog.common.model;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class BArticleBrowse {
    @Id
    private long browseId;
    private String articleId;
    private Date createDate;
    private Date updateDate;
}
