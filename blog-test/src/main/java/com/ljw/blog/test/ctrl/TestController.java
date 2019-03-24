package com.ljw.blog.test.ctrl;

import com.ljw.blog.test.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lujunwei
 * @time: 14:35 2019/3/20
 * @des:
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public List<SysUser> consume(@RequestParam("ids") List<Long> ids) {
        List<SysUser> users = new ArrayList<>();
        for (Long id : ids) {
            String url = "http://localhost:9002/user/" + id;
            SysUser user = this.restTemplate.getForObject(url, SysUser.class);
            users.add(user);
        }
        return users;
    }
}
