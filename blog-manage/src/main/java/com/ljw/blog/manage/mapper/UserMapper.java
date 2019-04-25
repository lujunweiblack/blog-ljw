package com.ljw.blog.manage.mapper;

import com.ljw.blog.common.model.SysUser;
import org.apache.ibatis.annotations.Select;

/**
 * @author: lujunwei
 * @time: 15:27 2019/1/16
 * @des:
 */
public interface UserMapper {

    @Select("SELECT * FROM sys_user WHERE USER_CODE = #{userName}")
    SysUser findUserByUserName(String userName);

    @Select("SELECT * FROM sys_user WHERE USER_CODE = #{userName}")
    SysUser findUserByUser(SysUser sysUser);
}
