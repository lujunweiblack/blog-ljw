package com.ljw.blog.common.tools;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.ljw.blog.common.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

public class ExceptionUtilsCls {
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionUtilsCls.class);
	/**
	 * 异常工具类
	 * @param customException
	 * @param ex
	 * @param params 参数列表
	 * @return
	 */
	public static Boolean putCustomException(CustomException customException, Exception ex , String params){
		Boolean flag = false;
		try{
			if(null != params){
				if(params.length() > 1000){
	            	customException.setRemark(params.substring(0,1000));
	            }
				customException.setParams(params);
			}
			//记录异常日志
			if(null != ex){
				StringWriter sw = new StringWriter();  
	            ex.printStackTrace(new PrintWriter(sw, true));  
	            String str = sw.toString();
	            if(str.length() > 1024){
	            	customException.setRemark(str.substring(0,1024));
	            }
	            LOGGER.error("参数：" + params + "异常信息：" +sw.toString());
			}
			if(null != ex && null != ex.getMessage()){			
				JSONObject jsonObject = null ;
				if(ex.getMessage().startsWith("{") && ex.getMessage().endsWith("}")){
					jsonObject = JSONObject.parseObject(ex.getMessage());
				}
				if(null != jsonObject){
					customException.setCode(jsonObject.getString("code"));
					customException.setMsg(jsonObject.getString("msg"));
					flag = true;
				}	
			}	
		}catch(Exception e){
			LOGGER.error("异常工具类出现异常:"+e);
		}
		return flag;
	}
}
