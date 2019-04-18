package com.ljw.blog.common.vo;

import com.ljw.blog.common.model.SysRole;
import lombok.Data;

import java.util.List;

/**
 * @author: lujunwei
 * @time: 9:57 2019/4/18
 * @des:
 */
@Data
public class UserObj {
    private String userCode;
    private String userName;
    private String phone;
    private String email;
    private List<SysRole> sysRoles;
}
