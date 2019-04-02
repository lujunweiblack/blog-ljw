package com.ljw.blog.portal.mapper;

import com.ljw.blog.common.model.BLabel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: lujunwei
 * @Date: 10:46 2019/3/31
 * @Desc:
 */
public interface LabelMapper {
    @Select("select * from b_label t where t.label_state = 0")
    List<BLabel> labelQuery(BLabel bLabel);
}
