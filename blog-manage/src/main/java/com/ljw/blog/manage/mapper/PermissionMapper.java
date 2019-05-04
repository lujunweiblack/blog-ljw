package com.ljw.blog.manage.mapper;

import com.ljw.blog.common.model.SysPermission;
import com.ljw.blog.common.model.SysRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {

    @Select("SELECT T3.* FROM sys_permission T1, sys_role_permission T2,sys_role T3 WHERE T1.ID = T2.SYS_PERMISSION_ID AND T3.ID = T2.SYS_ROLE_ID AND T1.URL = #{requestUrl}")
    List<SysRole> getPermByPermCode(String requestUrl);

    @Select("SELECT\n" +
            "\t*\n" +
            "FROM\n" +
            "\tsys_permission t\n" +
            "WHERE\n" +
            "\tt.id IN (\n" +
            "\t\tSELECT\n" +
            "\t\t\tt.sys_permission_id\n" +
            "\t\tFROM\n" +
            "\t\t\tsys_role_permission t\n" +
            "\t\tWHERE\n" +
            "\t\t\tt.sys_role_id IN (\n" +
            "\t\t\t\tSELECT\n" +
            "\t\t\t\t\tt.sys_role_id\n" +
            "\t\t\t\tFROM\n" +
            "\t\t\t\t\tsys_user_role t\n" +
            "\t\t\t\tWHERE\n" +
            "\t\t\t\t\tt.sys_user_id = #{userId}\n" +
            "\t\t\t)\n" +
            "\t)")
    List<SysPermission> getPermByUserId(Integer userId);

    @Select("select * from sys_permission t where t.id=#{pid}")
    SysPermission getPermById(Integer pid);
}
