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
     * 60000 = 1分钟
     */
    public static final long TOKEN_EXPIRED_TIME = 60000*30;

    public static final long TOKEN_EXPIRED_TIME_ = 60000*5;

    /**
     * jwt 加密解密密钥
     */
    public static final String JWT_SECRET = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=";

    /**
     * jwt UserId
     */
    public static final String JWT_TOKEN_SYS_USER_ID = "jwtTokenSysUserId";

    /**
     * 过滤拦截的uri
     */
    public static final String EXCLUSIONS_URI[] = {"/manage/user/login"};
}
