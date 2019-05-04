package com.ljw.blog.manage;

import com.alibaba.fastjson.JSONObject;
import com.ljw.blog.common.model.SysPermission;
import com.ljw.blog.common.tools.DataTools;
import com.ljw.blog.common.vo.MenuVo;
import com.ljw.blog.manage.api.PermissionApi;
import com.netflix.discovery.converters.Auto;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lujunwei
 * @Date: 10:23 2019/5/2
 * @Desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCtrlTest {

    @Autowired
    private PermissionApi permissionApi;

    @Test
    public void queryMenu(){
        List<SysPermission> sysPermissions = permissionApi.getPermByUserId(20190020);
        List<MenuVo> resultUserVoMenuList = new ArrayList<>();
        //将查询的结果po转为vo
        for (SysPermission menuPo : sysPermissions) {
            MenuVo menuVo = new MenuVo();
            BeanUtils.copyProperties(menuPo, menuVo);
            resultUserVoMenuList.add(menuVo);
        }
        //根据一级菜单id查询所有的菜单
        List<MenuVo> userMenuVos = new ArrayList<>();
        for (MenuVo menuVo : resultUserVoMenuList) {
            //这里需要的是一级菜单的id，对于没有父菜单id的就是一级菜单
            if(!DataTools.dataIsNotNullAndEmpty(menuVo.getParentId())){
                List<MenuVo> iterateMenus = DataTools.iterateMenus(resultUserVoMenuList, menuVo.getId());
                menuVo.setMenuVo(iterateMenus);
                userMenuVos.add(menuVo);
            }
        }

        System.out.println(JSONObject.toJSONString(userMenuVos));
    }

}
