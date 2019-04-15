package com.ljw.blog.manage.ctrl;

import com.ljw.blog.common.model.BArticle;
import com.ljw.blog.common.model.ResultBean;
import org.springframework.web.bind.annotation.*;

/**
 * @author: lujunwei
 * @time: 15:03 2019/4/15
 * @des:
 */
@RestController
@RequestMapping(value = "/manage/add")
public class AddCtrl {

    @PostMapping("/save")
    public String save(@RequestBody BArticle bArticle){
        System.out.println(bArticle);
        return ResultBean.resultInit(ResultBean.SUCCESS);
    }
}
