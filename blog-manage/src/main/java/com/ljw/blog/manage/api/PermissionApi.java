package com.ljw.blog.manage.api;


import com.ljw.blog.common.model.SysRole;

import java.util.List;

/**
 * @author: lujunwei
 * @time: 15:06 2019/1/18
 * @des:
 */
public interface PermissionApi {
    List<SysRole> getPermByPermCode(String requestUrl);
}
