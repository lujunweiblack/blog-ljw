package com.ljw.blog.common.model;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class BLabel {
    @Id
    private long labelId;
    private String labelName;
    private Integer labelState;
    private Date createDate;
    private Date updateDate;
}