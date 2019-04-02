package com.ljw.blog.portal.service.impl;

import com.ljw.blog.common.model.BAbout;
import com.ljw.blog.portal.mapper.AboutMapper;
import com.ljw.blog.portal.service.AboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: lujunwei
 * @Date: 7:02 2019/3/31
 * @Desc:
 */
@RestController
public class AboutServiceImpl implements AboutService {

    @Autowired
    private AboutMapper aboutMapper;

    @Override
    public List<BAbout> aboutQuery(BAbout about) {
        return aboutMapper.aboutQuery(about);
    }
}
