package com.ljw.blog.common.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: lujunwei
 * @Date: 21:23 2019/5/1
 * @Desc:
 */
@Data
public class LoginVo {
    private UserObj userObj;
    private List<MenuVo> menuVo;
}
