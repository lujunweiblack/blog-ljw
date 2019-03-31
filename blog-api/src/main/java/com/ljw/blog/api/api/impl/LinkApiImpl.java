package com.ljw.blog.api.api.impl;

import com.ljw.blog.api.api.LinkApi;
import com.ljw.blog.api.mapper.LinkMapper;
import com.ljw.blog.common.model.BLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: lujunwei
 * @Date: 7:02 2019/3/31
 * @Desc:
 */
@RestController
public class LinkApiImpl implements LinkApi {

    @Autowired
    private LinkMapper linkMapper;

    @Override
    public List<BLink> linkQuery(BLink link) {
        return linkMapper.linkQuery(link);
    }
}
