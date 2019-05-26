package com.ljw.blog.common.model;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class BArticleBrowse {
    @Id
    private long browseId;
    private String articleId;
    private String clientIp;
    private String clientId;
    private String clientName;
    private Date createDate;
    private Date updateDate;
}
