package com.ljw.blog.common.inface;

import com.ljw.blog.common.entity.BaseOpEntity;
import com.ljw.blog.common.exception.CustomException;

import java.util.List;



/**
 * @ClassName
 * @Description 通用业务层的接口-带逻辑删除接口
 */
public interface BaseOp<T extends BaseOpEntity> extends BaseInterface<T>{

	/**
	 * 根据id逻辑删除数据
	 * 
	 * @param t
	 * @return
	 */
	Integer deleteLogicById(T t) throws CustomException;

	/**
	 * 批量逻辑删除
	 * 
	 * @param clazz
	 * @param property
	 * @param values
	 * @param record
	 * @return
	 */
	Integer deleteLogicByIds(Class<T> clazz, String property, List<Object> values, T record) throws CustomException;
}