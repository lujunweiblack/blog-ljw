package com.ljw.blog.api.mapper;

import com.ljw.blog.common.model.BLink;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: lujunwei
 * @Date: 6:30 2019/3/31
 * @Desc:
 */
public interface LinkMapper {
    @Select("select * from b_link t where t.link_state = 0")
    List<BLink> linkQuery(BLink link);
}
