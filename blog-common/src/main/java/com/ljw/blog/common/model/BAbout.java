package com.ljw.blog.common.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @Author: lujunwei
 * @Date: 6:21 2019/3/31
 * @Desc:
 */
@Data
public class BAbout {
    @Id
    private long aboutId;
    private Long autographId;
    private String aboutName;
    private String oneselfName;
    private String oneselfNickName;
    private String oneselfIntelligence;
    private String oneselfBrief;
    private String oneselfBriefIntroduction;
    private String headUrl;
    private String backgroundUrl;
    private String sinaUrl;
    private String sinaName;
    private String tencentUrl;
    private String tencentName;
    private String qqUrl;
    private String qqName;
    private String emailUrl;
    private String emailName;
    private String wxName;
    private String wxImgUrl;
    private Date createDate;
    private Date updateDate;
}