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
public class BAutograph {
    @Id
    private long autographId;
    private String autographName;
    private String autographContent;
    private Date createDate;
    private Date updateDate;
}