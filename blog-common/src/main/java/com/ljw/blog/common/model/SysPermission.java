package com.ljw.blog.common.model;



import lombok.Data;
import javax.persistence.Id;

@Data
public class SysPermission {
    @Id
    private Integer id;
    private String name;
    private String icon;
    private String componentPath;
    private String path;
    private String type;
    private Integer parentId;
    private String sort;
    private String available;
}