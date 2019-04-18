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

    @Select("SELECT * FROM sys_role t1, sys_user_role t2 where t2.sys_role_id = t1.id and t2.sys_user_id = #{userId}")
    List<SysRole> findRoleByUserId(long userId);
}
