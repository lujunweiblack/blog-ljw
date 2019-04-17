package com.ljw.blog.portal.api;

import com.ljw.blog.common.model.BLabel;

import java.util.List;

/**
 * @Author: lujunwei
 * @Date: 10:45 2019/3/31
 * @Desc:
 */
public interface LabelApi {
    List<BLabel> labelQuery(BLabel bLabel);
}
