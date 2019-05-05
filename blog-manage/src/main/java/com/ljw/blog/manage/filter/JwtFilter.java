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
//        response.setHeader("Access-Control-Allow-Origin", "*"); //解决跨域访问报错
//        response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
//        response.setHeader("Access-Control-Max-Age", "3600"); //设置过期时间
//        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization");
//        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // 支持HTTP 1.1.
//        response.setHeader("Pragma", "no-cache"); // 支持HTTP 1.0. response.setHeader("Expires", "0");

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
                filterChain.doFilter(request, response);
            }
        }
    }

    @Override
    public void destroy() {

    }


}
