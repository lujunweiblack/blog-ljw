package com.ljw.blog.portal.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


/**
 * @author: lujunwei
 * @time: 17:55 2019/4/1
 * @des:
 */
@RestController
public class InfoCtrl {
    /**
     * @author: lujunwei
     * @param: []
     * @return: java.lang.String
     * @time: 16:24 2019/3/30
     * @des: 用于根路径跳转访问
     */
    @RequestMapping(value = "/portal/info/{articleId}",method = RequestMethod.GET)
    public String jumpInfo(@PathVariable("articleId") String articleId, HttpServletRequest request) {
        request.setAttribute("articleId",articleId);
        return "info";
    }
}
