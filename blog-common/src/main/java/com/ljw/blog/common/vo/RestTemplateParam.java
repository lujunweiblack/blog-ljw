package com.ljw.blog.common.vo;

import lombok.Data;
import org.springframework.http.HttpHeaders;

/**
 * @Author: lujunwei
 * @Date: 19:48 2019/6/15
 * @Desc:
 */
@Data
public class RestTemplateParam {
    private String url;
    private HttpHeaders headers;
    private Object param;
}
