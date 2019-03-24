package com.ljw.blog.user.mapper;

import com.ljw.blog.common.model.SysUser;
import org.apache.ibatis.annotations.Select;

/**
 * @author: lujunwei
 * @time: 14:43 2019/3/20
 * @des:
 */
public interface UserMapper {

    @Select("select * from sys_user where id = #{id}")
    SysUser queryById(Long id);
}
