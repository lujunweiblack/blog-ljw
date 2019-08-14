package com.ljw.blog.common.entity;

import lombok.Data;

import javax.persistence.Transient;
import java.util.Date;

/**
 * @ClassName SuperEntity
 * @Description 基本操作实体
 * @Author jk
 * @Date 2019/5/11 14:26
 */
@SuppressWarnings("serial")
@Data
public class BaseOpEntity extends BaseEntity {

	/** 创建人 **/
	protected String createUser;

	/** 创建人姓名 **/
	@Transient
	protected String createUserName;
	
	/** 创建时间 **/
	protected Date createTime;

	/** 更新人 **/
	protected String updateUser;

	/** 更新人姓名 **/
	@Transient
	protected String updateUserName;
	
	/** 更新时间 **/
	protected Date updateTime;

	/** 删除标识(0:正常,1:删除,2:审核) **/
	protected String delFlag;
	
	/**备注**/
	protected String remark;

	protected String status;

}
