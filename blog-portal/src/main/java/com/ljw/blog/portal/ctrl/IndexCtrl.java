package com.ljw.blog.portal.ctrl;

import com.ljw.blog.common.model.ResultBean;
import com.ljw.blog.portal.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: lujunwei
 * @time: 9:54 2019/3/21
 * @des:
 */
@RestController
@CrossOrigin
public class IndexCtrl {

    @Autowired
    private IndexService indexService;

    /**
     * @author: lujunwei
     * @param: []
     * @return: java.lang.String
     * @time: 16:24 2019/3/30
     * @des: 用于根路径跳转访问
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String jumpIndex() {
        return "index";
    }

    /**
     * @author: lujunwei
     * @param: []
     * @return: java.lang.String
     * @time: 16:24 2019/3/30
     * @des: index.html页面的ajax请求, 获取填充页面的数据
     */
    @RequestMapping(value = "/portal/index", method = RequestMethod.GET)
    @ResponseBody
    public String fillIndex() {
        return ResultBean.resultInit(ResultBean.SUCCESS, indexService.fillIndex());
    }

    public static void main(String[] args) {
        System.out.println("".equals(null));
    }

}
