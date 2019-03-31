package com.ljw.blog.api.api.impl;

import com.ljw.blog.api.api.AboutApi;
import com.ljw.blog.api.mapper.AboutMapper;
import com.ljw.blog.common.model.BAbout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: lujunwei
 * @Date: 7:02 2019/3/31
 * @Desc:
 */
@RestController
public class AboutApiImpl implements AboutApi {

    @Autowired
    private AboutMapper aboutMapper;

    @Override
    public List<BAbout> aboutQuery(BAbout about) {
        return aboutMapper.aboutQuery(about);
    }
}
