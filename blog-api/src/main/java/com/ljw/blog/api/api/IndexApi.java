package com.ljw.blog.api.api;

import com.ljw.blog.common.vo.IndexVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: lujunwei
 * @Date: 16:00 2019/3/30
 * @Desc:
 */
public interface IndexApi {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    IndexVo fillIndex();
}
