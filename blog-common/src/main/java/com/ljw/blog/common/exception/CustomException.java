package com.ljw.blog.common.exception;

import java.io.Serializable;

/**
 *
 */
public class CustomException extends RuntimeException implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;//可用可不用

	private String controllerClassName;//控制层类名

    private String controllerMethodName;//控制层方法名

    private String serviceClassName;//服务层类名

    private String serviceMethodName;//服务层方法名

    private String resendUrl;//需要跳转的URL

    private String params;//参数

    private String code;//错误编码

    private String msg;//错误信息

    private String remark;//备注保留域
	
    private Exception ex;//异常对象

    
    
    


	public CustomException() {
		super();
	}


    /**
     * 构造函数
     * @param serviceClassName 服务层类名
     * @param serviceMethodName 服务层方法名
     */
	public CustomException(String serviceClassName, String serviceMethodName) {
		super();
		this.serviceClassName = serviceClassName;
		this.serviceMethodName = serviceMethodName;
	}
	
	
	/**
	 * 构造函数
	 * @param serviceClassName 服务层类名
	 * @param serviceMethodName 服务层方法名
	 * @param code 错误编码
	 * @param msg  错误信息
	 */
	public CustomException(String serviceClassName, String serviceMethodName, String code, String msg) {
		super();
		this.serviceClassName = serviceClassName;
		this.serviceMethodName = serviceMethodName;
		this.code = code;
		this.msg = msg;
	}


	

	/**
	 * 构造函数
	 * @param controllerClassName 控制层类名
	 * @param controllerMethodName 控制层方法名
	 * @param serviceClassName 服务层类名
	 * @param serviceMethodName 服务层方法名
	 * @param code  错误编码
	 * @param msg 错误信息
	 */
	public CustomException(String controllerClassName, String controllerMethodName, String serviceClassName,
			String serviceMethodName, String code, String msg) {
		super();
		this.controllerClassName = controllerClassName;
		this.controllerMethodName = controllerMethodName;
		this.serviceClassName = serviceClassName;
		this.serviceMethodName = serviceMethodName;
		this.code = code;
		this.msg = msg;
	}

	

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getControllerClassName() {
		return controllerClassName;
	}


	public void setControllerClassName(String controllerClassName) {
		this.controllerClassName = controllerClassName;
	}



	public String getControllerMethodName() {
		return controllerMethodName;
	}



	public void setControllerMethodName(String controllerMethodName) {
		this.controllerMethodName = controllerMethodName;
	}



	public String getServiceClassName() {
		return serviceClassName;
	}



	public void setServiceClassName(String serviceClassName) {
		this.serviceClassName = serviceClassName;
	}



	public String getServiceMethodName() {
		return serviceMethodName;
	}



	public void setServiceMethodName(String serviceMethodName) {
		this.serviceMethodName = serviceMethodName;
	}



	public String getResendUrl() {
		return resendUrl;
	}



	public void setResendUrl(String resendUrl) {
		this.resendUrl = resendUrl;
	}



	public String getParams() {
		return params;
	}



	public void setParams(String params) {
		this.params = params;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	public Exception getEx() {
		return ex;
	}



	public void setEx(Exception ex) {
		this.ex = ex;
	}


	@Override
	public String toString() {
		return "CustomException [id=" + id + ", controllerClassName=" + controllerClassName + ", controllerMethodName="
				+ controllerMethodName + ", serviceClassName=" + serviceClassName + ", serviceMethodName="
				+ serviceMethodName + ", resendUrl=" + resendUrl + ", params=" + params + ", code=" + code + ", msg="
				+ msg + ", remark=" + remark + ", ex=" + ex + "]";
	}
    
    
	 

}
