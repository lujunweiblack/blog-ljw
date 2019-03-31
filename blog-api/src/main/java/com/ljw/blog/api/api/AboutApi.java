package com.ljw.blog.api.api;

import com.ljw.blog.common.model.BAbout;

import java.util.List;

/**
 * @Author: lujunwei
 * @Date: 6:48 2019/3/31
 * @Desc:
 */
public interface AboutApi {
    List<BAbout> aboutQuery(BAbout about);
}
