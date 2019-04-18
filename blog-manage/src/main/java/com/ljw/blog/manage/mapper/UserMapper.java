package com.ljw.blog.manage.mapper;

import com.ljw.blog.common.model.SysUser;
import org.apache.ibatis.annotations.Select;

/**
 * @author: lujunwei
 * @time: 15:27 2019/1/16
 * @des:
 */
public interface UserMapper {

    @Select("select * from sys_user where user_code = #{userName}")
    SysUser findUserByUserName(String userName);

    @Select("select * from sys_user where user_code = #{userName}")
    SysUser findUserByUser(SysUser sysUser);
}
