package com.ljw.blog.common.model;


import lombok.Data;
import javax.persistence.Id;

@Data
public class SysUser {
    @Id
    private int id;
    private String userCode;
    private String userName;
    private String passWord;
    private Integer age;
    private String gender;
    private String phone;
    private String email;
    private String address;
    private String salt;
    private String locked;
}