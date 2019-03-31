package com.ljw.blog.api.api;

import com.ljw.blog.common.model.BLink;

import java.util.List;

/**
 * @Author: lujunwei
 * @Date: 6:30 2019/3/31
 * @Desc:
 */
public interface LinkApi {
    List<BLink> linkQuery(BLink link);
}
