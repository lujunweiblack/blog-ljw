package com.ljw.blog.common.model;


import com.ljw.blog.common.entity.BaseOpEntity;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Table(name = "t_user_info")
public class UserInfo extends BaseOpEntity {

    private static final long serialVersionUID = 7098335334140203886L;

    /**
     * 主键Id
     */
    @Id
    private  Integer id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 直属上级userid
     */
    private String  superiorUserId;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     *直属上级姓名
     */
    private String superiorUserName;

    /**
     * 工号
     */
    private String jobNumber;

    /**
     * 手机
     */
    private String phone;

    /**
     * 密码（MD5）
     */
    private String password;

    /**
     * 性别
     */
    private String sex;

    /**
     * 职位
     */
    private String position;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String headImage;

    /**
     * 住址
     */
    private String address;

    /**
     * 简介
     */
    private String intro;

    /**
     * QQ
     */
    private String qq;

    /**
     * 座机
     */
    private String telPhone;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人
     */
    private String createUser;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * x修改人
     */
    private String updateUser;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 标识（0：默认，1：删除）
     */
    private String delFlag;

    /**
     * 有效状态
     */
    private String status;
    /**
     * 用户的token
     */
    @Transient
    private String token;
    
    /**
     * 所属部门id
     */
    @Transient
    private String departmentId;
    
    /**
     * 所属部门名称
     */
    @Transient
    private String departmentName;

    /**
     * 预留字段1
     */
    private String field1;

    /**
     * 预留字段2
     */
    private String field2;

    /**
     * 预留字段3
     */
    private String field3;

    public UserInfo() {
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
    }


    public String getSuperiorUserId() {
        return superiorUserId;
    }

    public void setSuperiorUserId(String superiorUserId) {
        this.superiorUserId = superiorUserId;
    }

    public String getSuperiorUserName() {
        return superiorUserName;
    }

    public void setSuperiorUserName(String superiorUserName) {
        this.superiorUserName = superiorUserName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage == null ? null : headImage.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone == null ? null : telPhone.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String getUpdateUser() {
        return updateUser;
    }

    @Override
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Override
    public Date getUpdateTime() {
        return updateTime;
    }

    @Override
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1 == null ? null : field1.trim();
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2 == null ? null : field2.trim();
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3 == null ? null : field3.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", jobNumber='" + jobNumber + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", headImage='" + headImage + '\'' +
                ", address='" + address + '\'' +
                ", intro='" + intro + '\'' +
                ", qq='" + qq + '\'' +
                ", telPhone='" + telPhone + '\'' +
                ", remark='" + remark + '\'' +
                ", createUser='" + createUser + '\'' +
                ", createTime=" + createTime +
                ", updateUser='" + updateUser + '\'' +
                ", updateTime=" + updateTime +
                ", delFlag='" + delFlag + '\'' +
                ", status='" + status + '\'' +
                ", token='" + token + '\'' +
                ", field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                '}';
    }
}