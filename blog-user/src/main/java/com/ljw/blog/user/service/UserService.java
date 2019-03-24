package com.ljw.blog.user.service;

import com.ljw.blog.common.model.SysUser;

/**
 * @author: lujunwei
 * @time: 13:36 2019/3/20
 * @des:
 */
public interface UserService {
    SysUser queryById(Long id);
}
