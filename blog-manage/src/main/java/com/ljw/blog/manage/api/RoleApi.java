package com.ljw.blog.manage.api;


import com.ljw.blog.common.model.SysRole;

import java.util.List;

/**
 * @author: lujunwei
 * @time: 15:03 2019/1/18
 * @des:
 */
public interface RoleApi {
    List<SysRole> findRoleByUserId(long userId);
}
