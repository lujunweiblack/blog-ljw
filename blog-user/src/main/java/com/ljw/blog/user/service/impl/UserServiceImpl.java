package com.ljw.blog.user.service.impl;

import com.ljw.blog.user.mapper.UserMapper;
import com.ljw.blog.common.model.SysUser;
import com.ljw.blog.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: lujunwei
 * @time: 13:36 2019/3/20
 * @des:
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public SysUser queryById(Long id) {
        return userMapper.queryById(id);
    }
}
