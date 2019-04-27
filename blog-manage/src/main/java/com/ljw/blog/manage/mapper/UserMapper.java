package com.ljw.blog.manage.mapper;

import com.ljw.blog.common.model.SysUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    @Select("SELECT T1.email,T1.user_name FROM  sys_user T1,sys_user_role T2 where T1.id=T2.sys_user_id AND T2.sys_role_id in (2207)")
    List<SysUser> findUserByRoleId();
}
