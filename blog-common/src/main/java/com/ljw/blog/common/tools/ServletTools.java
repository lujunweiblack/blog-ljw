package com.ljw.blog.common.tools;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Author: lujunwei
 * @Date: 14:30 2019/5/1
 * @Desc:
 */
public class ServletTools {

    /**
     * @author: lujunwei
     * @param:
     * @return:
     * @time: 14:32 2019/5/1
     * @des: This is a function
     */
    public static HttpSession getSession(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession();
    }
}
