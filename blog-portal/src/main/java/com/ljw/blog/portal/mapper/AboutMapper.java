package com.ljw.blog.portal.mapper;

import com.ljw.blog.common.model.BAbout;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: lujunwei
 * @Date: 6:48 2019/3/31
 * @Desc:
 */
public interface AboutMapper {
    @Select("select * from b_about t where t.about_id = #{aboutId}")
    List<BAbout> aboutQuery(BAbout about);
}
