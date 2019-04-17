package com.ljw.blog.portal.api.impl;

import com.ljw.blog.common.model.BLabel;
import com.ljw.blog.portal.mapper.LabelMapper;
import com.ljw.blog.portal.api.LabelApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: lujunwei
 * @Date: 10:45 2019/3/31
 * @Desc:
 */
@RestController
public class LabelApiImpl implements LabelApi {

    @Autowired
    private LabelMapper labelMapper;

    @Override
    public List<BLabel> labelQuery(BLabel bLabel) {
        return labelMapper.labelQuery(bLabel);
    }
}
