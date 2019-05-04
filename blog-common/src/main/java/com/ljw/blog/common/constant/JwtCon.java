package com.ljw.blog.common.constant;

import java.util.UUID;

/**
 * @Author: lujunwei
 * @Date: 15:14 2019/5/1
 * @Desc:
 */
public class JwtCon {
    public static final String JWT_ID = UUID.randomUUID().toString();
    /**
     * token 过期时间, 单位: 秒. 这个值表示 30 天
     */
    public static final long TOKEN_EXPIRED_TIME = 30 * 24 * 60 * 60;

    public static final long TOKEN_EXPIRED_TIME_ = 1000000;

    /**
     * jwt 加密解密密钥
     */
    public static final String JWT_SECRET = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=";

    /**
     * jwt 加密解密密钥
     */
    public static final String JWT_TOKEN_SYS_USER_ID = "jwtTokenSysUserId";
}
