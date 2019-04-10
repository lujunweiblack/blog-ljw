package com.ljw.blog.portal.ctrl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lujunwei
 * @time: 13:36 2019/4/3
 * @des:
 */
@RestController
public class GbookCtrl {

    /**
     * @author: lujunwei
     * @param: []
     * @return: java.lang.String
     * @time: 16:24 2019/3/30
     * @des: 用于路径跳转访问
     */
    @RequestMapping(value = "/portal/gbook",method = RequestMethod.GET)
    public String jumpGbook() {
        return "gbook";
    }
    /**
     * @author: lujunwei
     * @param: []
     * @return: java.lang.String
     * @time: 16:24 2019/3/30
     * @des: 用于路径跳转访问
     */
    @RequestMapping(value = "/portal/index_book",method = RequestMethod.GET)
    public String jumpIndex_book() {
        return "index_book";
    }
}
