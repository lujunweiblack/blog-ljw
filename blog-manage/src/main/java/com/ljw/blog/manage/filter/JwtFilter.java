package com.ljw.blog.manage.filter;

import com.ljw.blog.common.model.ResultBean;
import com.ljw.blog.common.tools.ServletTools;
import com.ljw.blog.manage.tools.JWTUtils;
import io.jsonwebtoken.Claims;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.ljw.blog.common.constant.JwtCon.EXCLUSIONS_URI;
import static com.ljw.blog.common.constant.JwtCon.JWT_TOKEN_SYS_USER_ID;

/**
 * @Author: lujunwei
 * @Date: 15:32 2019/5/1
 * @Desc:
 */
public class JwtFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //不拦截的URI
        if (ServletTools.pathExclusions(request.getRequestURI(), EXCLUSIONS_URI)) {
            filterChain.doFilter(request, response);
        } else {
            String token = request.getHeader("Authorization"); //获取请求传来的token
            Claims claims = JWTUtils.verifyJwt(token); //验证token
            if (claims == null) {
                response.getWriter().write(ResultBean.resultInit(ResultBean.AUTHENTICATION_FAILED, "token is invalid"));
            } else {
                request.setAttribute(JWT_TOKEN_SYS_USER_ID, claims.get(JWT_TOKEN_SYS_USER_ID));
                //不等于null 就续费30分钟时长
                //claims.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRED_TIME));
                filterChain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }

}
