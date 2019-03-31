package com.ljw.blog.common.model;


import lombok.Data;
import javax.persistence.Id;

@Data
public class SysRole {
    @Id
    private int id;
    private String name;
    private String code;
    private String available;
    private String remark;
}
