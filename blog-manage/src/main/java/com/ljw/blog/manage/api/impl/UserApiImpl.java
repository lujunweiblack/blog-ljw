package com.ljw.blog.manage.api.impl;

import com.ljw.blog.common.model.SysUser;
import com.ljw.blog.manage.api.UserApi;
import com.ljw.blog.manage.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lujunwei
 * @time: 15:24 2019/1/16
 * @des:
 */
@Service
public class UserApiImpl implements UserApi {

    @Autowired
    private UserMapper userMapper;

    @Override
    public SysUser findUserByUserName(String userName) {

        return userMapper.findUserByUserName(userName);
    }

    @Override
    public SysUser findUserByUser(SysUser sysUser) {
        return userMapper.findUserByUser(sysUser);
    }
}
