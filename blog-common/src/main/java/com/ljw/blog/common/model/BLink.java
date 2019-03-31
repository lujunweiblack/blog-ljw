package com.ljw.blog.common.model;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class BLink {
    @Id
    private long linkId;
    private String linkName;
    private String linkUrl;
    private Integer linkState;
    private Date createDate;
    private Date updateDate;
}