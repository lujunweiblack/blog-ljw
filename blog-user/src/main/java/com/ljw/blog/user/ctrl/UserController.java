package com.ljw.blog.user.ctrl;

import com.ljw.blog.common.model.SysUser;
import com.ljw.blog.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lujunwei
 * @time: 13:21 2019/3/20
 * @des:
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public SysUser queryById(@PathVariable("id") Long id) {
        return this.userService.queryById(id);
    }
}