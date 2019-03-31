package com.ljw.blog.common.model;



import lombok.Data;
import javax.persistence.Id;

@Data
public class SysPermission {
    @Id
    private long id;
    private String name;
    private String type;
    private String url;
    private String perCode;
    private Long parentId;
    private String sort;
    private String available;
}