package com.ljw.blog.portal.service.impl;

import com.ljw.blog.common.model.BLabel;
import com.ljw.blog.portal.mapper.LabelMapper;
import com.ljw.blog.portal.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: lujunwei
 * @Date: 10:45 2019/3/31
 * @Desc:
 */
@RestController
public class LabelServiceImpl implements LabelService {

    @Autowired
    private LabelMapper labelMapper;

    @Override
    public List<BLabel> labelQuery(BLabel bLabel) {
        return labelMapper.labelQuery(bLabel);
    }
}
