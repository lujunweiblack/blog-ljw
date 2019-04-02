package com.ljw.blog.portal.service;

import com.ljw.blog.common.model.BAbout;

import java.util.List;

/**
 * @Author: lujunwei
 * @Date: 6:48 2019/3/31
 * @Desc:
 */
public interface AboutService {
    List<BAbout> aboutQuery(BAbout about);
}
