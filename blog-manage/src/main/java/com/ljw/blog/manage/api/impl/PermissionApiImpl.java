package com.ljw.blog.manage.api.impl;

import com.ljw.blog.common.model.SysRole;
import com.ljw.blog.manage.api.PermissionApi;
import com.ljw.blog.manage.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionApiImpl implements PermissionApi {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<SysRole> getPermByPermCode(String requestUrl) {
        return permissionMapper.getPermByPermCode(requestUrl);
    }
}
