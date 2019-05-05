package com.ljw.blog.manage.ctrl;

import com.ljw.blog.common.model.ResultBean;
import com.ljw.blog.common.model.SysPermission;
import com.ljw.blog.common.model.SysUser;
import com.ljw.blog.common.tools.DataTools;
import com.ljw.blog.common.vo.LoginVo;
import com.ljw.blog.common.vo.MenuVo;
import com.ljw.blog.common.vo.UserObj;
import com.ljw.blog.manage.api.PermissionApi;
import com.ljw.blog.manage.api.UserApi;
import com.ljw.blog.manage.tools.JWTUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author: lujunwei
 * @time: 9:41 2019/4/18
 * @des:
 */
@RestController
@RequestMapping("/manage/user")
public class UserCtrl {

    @Autowired
    private UserApi userApi;

    @Autowired
    private PermissionApi permissionApi;

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
        if (!bCryptPasswordEncoder.matches(sysUser.getPassWord(), querySysUser.getPassWord())) {
            return ResultBean.resultInit(ResultBean.FAIL, "用户名或密码错误");
        }

        //根据用户id获取此用户的所有可操作性的菜单信息
        List<SysPermission> sysPermissions = permissionApi.getPermByUserId(querySysUser.getId());
        List<MenuVo> menuVo = DataTools.getMenuByPermissions(sysPermissions);

        LoginVo loginVo = new LoginVo();
        UserObj userObj = new UserObj();
        BeanUtils.copyProperties(querySysUser,userObj);
        userObj.setToken(JWTUtils.generateToken(querySysUser));
        loginVo.setUserObj(userObj);
        loginVo.setMenuVo(menuVo);
        return ResultBean.resultInit(ResultBean.SUCCESS, "登陆成功", loginVo);
    }


}
