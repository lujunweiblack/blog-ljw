package com.ljw.blog.common.model;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class BArticleLike {
    @Id
    private long likeId;
    private String articleId;
    private Integer likeState;
    private Date createDate;
    private Date updateDate;
}
