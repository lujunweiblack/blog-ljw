package com.ljw.blog.portal.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lujunwei
 * @time: 13:36 2019/4/3
 * @des:
 */
@RestController
public class AboutCtrl {
    /**
     * @author: lujunwei
     * @param: []
     * @return: java.lang.String
     * @time: 16:24 2019/3/30
     * @des: 用于路径跳转访问
     */
    @RequestMapping(value = "/portal/about",method = RequestMethod.GET)
    public String jumpAbout() {
        return "about";
    }
}
