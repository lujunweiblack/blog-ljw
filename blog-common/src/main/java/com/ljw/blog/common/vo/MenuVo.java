package com.ljw.blog.common.vo;

import lombok.Data;

import java.util.List;

/**
 * @Author: lujunwei
 * @Date: 21:50 2019/5/1
 * @Desc:
 */
@Data
public class MenuVo {
    private Integer id;
    private String name;
    private String icon;
    private String componentPath;
    private String path;
    private String type;
    private Integer parentId;
    private List<MenuVo> menuVo;
}
