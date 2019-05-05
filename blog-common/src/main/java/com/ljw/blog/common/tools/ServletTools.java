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
    public static HttpSession getSession() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getSession();
    }

    /**
     * @author: lujunwei
     * @param:
     * @return:
     * @time: 14:32 2019/5/1
     * @des: 排除不需要拦截的路径  必须以 /开头 不支持 /**
     */
    public static boolean pathExclusions(String uri, String[] patterns) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        if (!uri.startsWith("/")) {
           stringBuilder.append("/").append(uri);
        }else{
            stringBuilder.append(uri);
        }
        if (uri.endsWith("/")) {
            flag = true;
        }
        if (flag) {
            uri = stringBuilder.toString();
            uri = uri.substring(0, uri.length() - 1);
        }

        for (String p : patterns) {
            if (p.equals(uri)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] p = {"/manage/user/login"};
        String u = "/manage/user/login/";
        System.out.println(pathExclusions(u, p));
    }
}
