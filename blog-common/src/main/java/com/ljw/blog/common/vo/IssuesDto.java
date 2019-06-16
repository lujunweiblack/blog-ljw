package com.ljw.blog.common.vo;

import lombok.Data;

/**
 * @Author: lujunwei
 * @Date: 19:37 2019/6/15
 * @Desc:
 */
@Data
public class IssuesDto {
    private String title;
    private String body;
    private String[] labels;
}
