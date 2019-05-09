package com.ljw.blog.manage.mapperSqlProvider;

import com.ljw.blog.common.model.SysUser;
import com.ljw.blog.common.tools.DataTools;

/**
 * @author: lujunwei
 * @time: 15:27 2019/5/8
 * @des:
 */
public class UserMapperUserQueryProvider {

    public String findUserByUser(SysUser sysUser){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM sys_user t WHERE 1=1 ");
        if (DataTools.dataIsNotNullAndEmpty(sysUser.getUserName())) {
            sql.append(" and t.USER_CODE = #{userName} ");
        }
        if (DataTools.dataIsNotNullAndEmpty(sysUser.getId())) {
            sql.append(" and t.id = #{id} ");
        }
        return sql.toString();
    }
}
