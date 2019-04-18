package com.ljw.blog.manage.ctrl;

import com.ljw.blog.common.constant.SysRoleCon;
import com.ljw.blog.common.model.ResultBean;
import com.ljw.blog.common.model.SysRole;
import com.ljw.blog.common.model.SysUser;
import com.ljw.blog.common.vo.UserObj;
import com.ljw.blog.manage.api.RoleApi;
import com.ljw.blog.manage.api.UserApi;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.ljw.blog.common.constant.SysRoleCon.ROLE_SYS_ADMIN;
import static com.ljw.blog.common.constant.SysRoleCon.ROLE_USER;

/**
 * @author: lujunwei
 * @time: 9:41 2019/4/18
 * @des:
 */
@RestController
@RequestMapping("/manage/user")
@CrossOrigin
public class UserCtrl {

    @Autowired
    private UserApi userApi;

    @Autowired
    private RoleApi roleApi;

    /**
     * @author: lujunwei
     * @param: [SysUser]
     * @return: String
     * @time: 9:50 2019/4/18
     * @des: This is a function
     */
    @PostMapping("/login")
    public String sysUserLogin(@RequestBody SysUser sysUser) {
        SysUser querySysUser = userApi.findUserByUser(sysUser);
        if (querySysUser == null) {
            return ResultBean.resultInit(ResultBean.FAIL, "不存在的用户");
        }
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (!bCryptPasswordEncoder.matches(sysUser.getPassWord(),querySysUser.getPassWord())) {
            return ResultBean.resultInit(ResultBean.FAIL, "用户名或密码错误");
        }

        List<SysRole> rolesByUser = roleApi.findRoleByUserId(querySysUser.getId());
        List<SysRole> sysRoles = new ArrayList<>();
        UserObj userObj = new UserObj();
        for (SysRole sysRole : rolesByUser) {
            //当前查询只是筛选当前登录用户是否是管理员(本人)  后期还会开发多权限
            if (ROLE_SYS_ADMIN.equals(sysRole.getCode())) {
                sysRoles.add(sysRole);
                break;
            }
        }
        //普通用户
        if (sysRoles.size() == 0) {
            SysRole sysRole = new SysRole();
            sysRole.setCode(ROLE_USER);
            sysRoles.add(sysRole);
        }
        BeanUtils.copyProperties(querySysUser, userObj);
        userObj.setSysRoles(sysRoles);
        return ResultBean.resultInit(ResultBean.SUCCESS, "登陆成功", userObj);
    }

//    @PostMapping("/register")
//    public String sysUserRegister(@RequestBody SysUser sysUser) {
//        SysUser querySysUser = userApi.findUserByUserName(sysUser.getUserCode());
//        if (querySysUser != null) {
//            return ResultBean.resultInit(ResultBean.SUCCESS, "已存在的用户");
//        }
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        sysUser.setPassWord(bCryptPasswordEncoder.encode(sysUser.getPassWord()));
//        return ResultBean.resultInit(ResultBean.SUCCESS, "注册成功", userObj);
//    }
}
