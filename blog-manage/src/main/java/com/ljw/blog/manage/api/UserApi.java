package com.ljw.blog.manage.api;


import com.ljw.blog.common.model.SysUser;

/**
 * @author: lujunwei
 * @time: 15:24 2019/1/16
 * @des:
 */
public interface UserApi {

    SysUser findUserByUserName(String userName);

    SysUser findUserByUser(SysUser sysUser);
}
