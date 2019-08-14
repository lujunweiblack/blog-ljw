package com.ljw.blog.common.inface.impl;


import com.ljw.blog.common.entity.BaseOpEntity;
import com.ljw.blog.common.enums.BaseExceptionEnums;
import com.ljw.blog.common.enums.DelFlagEnum;
import com.ljw.blog.common.exception.CustomException;
import com.ljw.blog.common.inface.BaseOp;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @Description 通用操作业务层的实现类-带逻辑删除接口
 * @param <T>
 */
public abstract class BaseOpBizImpl<T extends BaseOpEntity> extends BaseImpl<T> implements BaseOp<T> {

	@Autowired
	private Mapper<T> mapper;

	@Override
	public Integer deleteLogicById(T t) throws CustomException {
		try {
			t.setUpdateTime(new Date());
			t.setDelFlag(DelFlagEnum.DEL_FLAG_DELETE.getValue());
			return this.mapper.updateByPrimaryKeySelective(t);
		} catch (Exception e) {
			String params = "T:" + t.getClass().getName() + ",params:t=" + t.toString();
			throw BaseExceptionEnums.BaseOpImpl_deleteByWhere_00_error.throwCustomException(e, params, Thread
					.currentThread().getStackTrace()[1]);
		}
	}

	@Override
	public Integer deleteLogicByIds(Class<T> clazz, String property, List<Object> values, T record)
			throws CustomException {
		try {
			Example example = new Example(clazz);
			example.createCriteria().andIn(property, values);
			record.setUpdateTime(new Date());
			record.setDelFlag(DelFlagEnum.DEL_FLAG_DELETE.getValue());
			return this.mapper.updateByExampleSelective(record, example);
		} catch (Exception e) {
			String params = "T:" + clazz.getName() + ",params:[clazz=" + clazz.toString() + ",property="
					+ property + ",values=" + values.toString() + ",record=" + record.toString() + "]";
			throw BaseExceptionEnums.BaseOpImpl_deleteByWhere_00_error.throwCustomException(e, params, Thread
					.currentThread().getStackTrace()[1]);
		}
	}

}
