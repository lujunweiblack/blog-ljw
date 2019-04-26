package com.ljw.blog.manage.mapper;

import com.ljw.blog.common.model.SysRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {

    @Select("SELECT T3.* FROM sys_permission T1, sys_role_permission T2,sys_role T3 WHERE T1.ID = T2.SYS_PERMISSION_ID AND T3.ID = T2.SYS_ROLE_ID AND T1.URL = #{requestUrl}")
    List<SysRole> getPermByPermCode(String requestUrl);
}
