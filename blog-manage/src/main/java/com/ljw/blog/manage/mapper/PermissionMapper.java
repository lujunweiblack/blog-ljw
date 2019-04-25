package com.ljw.blog.manage.mapper;

import com.ljw.blog.common.model.SysRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {

    @Select("SELECT T3.* FROM sys_permission T1, SYS_ROLE_PERMISSION T2,SYS_ROLE T3 WHERE T1.ID = T2.SYS_PERMISSION_ID AND T3.ID = T2.SYS_ROLE_ID AND T1.URL = #{requestUrl}")
    List<SysRole> getPermByPermCode(String requestUrl);
}
