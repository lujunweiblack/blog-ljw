package com.ljw.blog.portal.service.impl;

import com.ljw.blog.common.model.BLink;
import com.ljw.blog.portal.mapper.LinkMapper;
import com.ljw.blog.portal.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: lujunwei
 * @Date: 7:02 2019/3/31
 * @Desc:
 */
@RestController
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkMapper linkMapper;

    @Override
    public List<BLink> linkQuery(BLink link) {
        return linkMapper.linkQuery(link);
    }
}
