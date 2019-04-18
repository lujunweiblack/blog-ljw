package com.ljw.blog.manage.mapper;

import com.ljw.blog.common.model.SysRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {

    @Select("select t3.* from sys_permission t1, sys_role_permission t2,sys_role t3 where t1.id = t2.sys_permission_id and t3.id = t2.sys_role_id and t1.url = #{requestUrl}")
    List<SysRole> getPermByPermCode(String requestUrl);
}
