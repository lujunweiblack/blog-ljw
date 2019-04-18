package com.ljw.blog.manage.api.impl;

import com.ljw.blog.common.model.SysRole;
import com.ljw.blog.manage.api.RoleApi;
import com.ljw.blog.manage.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: lujunwei
 * @time: 16:20 2019/1/18
 * @des:
 */
@Service
public class RoleApiImpl implements RoleApi {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<SysRole> findRoleByUserId(long userId) {
        return roleMapper.findRoleByUserId(userId);
    }
}
