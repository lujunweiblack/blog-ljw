package com.ljw.blog.manage.mapper;

import com.ljw.blog.common.model.SysRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: lujunwei
 * @time: 16:30 2019/1/18
 * @des:
 */
public interface RoleMapper {

    @Select("SELECT * FROM sys_role T1, sys_user_role T2 WHERE T2.SYS_ROLE_ID = T1.ID AND T2.SYS_USER_ID = #{userId}")
    List<SysRole> findRoleByUserId(long userId);
}
