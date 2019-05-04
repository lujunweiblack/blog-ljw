package com.ljw.blog.common.vo;

import lombok.Data;

/**
 * @author: lujunwei
 * @time: 9:57 2019/4/18
 * @des:
 */
@Data
public class UserObj {
    private String token;
    private String userName;
    private String userCode;
    private String phone;
    private String email;
}
