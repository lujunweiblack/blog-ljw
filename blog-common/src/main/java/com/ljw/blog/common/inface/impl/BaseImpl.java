package com.ljw.blog.common.inface.impl;

import java.util.List;

import com.ljw.blog.common.exception.CustomException;
import com.ljw.blog.common.inface.BaseInterface;
import com.ljw.blog.common.enums.BaseExceptionEnums;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

/**
 * @ClassName
 * @Description 通用业务层的的实现类
 * @param <T>
 */
public abstract class BaseImpl<T> implements BaseInterface<T> {

	@Autowired
	private Mapper<T> mapper;

	@Override
	public T queryById(int id) throws CustomException {
		try {
			return this.mapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			String params = "params:id=" + id;
			throw BaseExceptionEnums.BaseImpl_queryById_00_error.throwCustomException(e, params, Thread
					.currentThread().getStackTrace()[1]);
		}
	}

	@Override
	public List<T> queryAll() throws CustomException {
		try {
			return this.mapper.select(null);
		} catch (Exception e) {
			String params = "";
			throw BaseExceptionEnums.BaseImpl_queryAll_00_error.throwCustomException(e, params, Thread
					.currentThread().getStackTrace()[1]);
		}
	}

	@Override
	public T queryOne(T record) throws CustomException {
		try {
			return this.mapper.selectOne(record);
		} catch (Exception e) {
			String params = "T:" + record.getClass().getName() + ",params:rocord=" + record.toString();
			throw BaseExceptionEnums.BaseImpl_queryOne_00_error.throwCustomException(e, params, Thread
					.currentThread().getStackTrace()[1]);
		}
	}

	@Override
	public List<T> queryListByWhere(T record) throws CustomException {
		try {
			return this.mapper.select(record);
		} catch (Exception e) {
			String params = "T:" + record.getClass().getName() + ",params:rocord=" + record.toString();
			throw BaseExceptionEnums.BaseImpl_queryListByWhere_00_error.throwCustomException(e, params, Thread
					.currentThread().getStackTrace()[1]);
		}
	}

	@Override
	public PageInfo<T> queryPageListByWhere(Integer page, Integer rows, T record) throws CustomException {
		try {
			// 设置分页参数
			PageHelper.startPage(page, rows);
			List<T> list = this.mapper.select(record);
			return new PageInfo<T>(list);
		} catch (Exception e) {
			String params = "T:" + record.getClass().getName() + ",params:[rocord=" + record.toString() + ",page=" + page
					+ ",rows=" + rows + "]";
			throw BaseExceptionEnums.BaseImpl_queryPageListByWhere_00_error.throwCustomException(e, params,
					Thread.currentThread().getStackTrace()[1]);
		}
	}

	@Override
	public Integer insert(T t) throws CustomException {
		try {
			return this.mapper.insert(t);
		} catch (Exception e) {
			String params = "T:" + t.getClass().getName() + ",params:t=" + t.toString();
			throw BaseExceptionEnums.BaseImpl_save_00_error.throwCustomException(e, params, Thread
					.currentThread().getStackTrace()[1]);
		}
	}

	@Override
	public Integer insertSelective(T t) throws CustomException {
		try {
			return this.mapper.insertSelective(t);
		} catch (Exception e) {
			String params = "T:" + t.getClass().getName() + ",params:t=" + t.toString();
			throw BaseExceptionEnums.BaseImpl_saveSelective_00_error.throwCustomException(e, params, Thread
					.currentThread().getStackTrace()[1]);
		}
	}

	@Override
	public Integer update(T t) throws CustomException {
		try {
			return this.mapper.updateByPrimaryKey(t);
		} catch (Exception e) {
			String params = "T:" + t.getClass().getName() + ",params:t=" + t.toString();
			throw BaseExceptionEnums.BaseImpl_update_00_error.throwCustomException(e, params, Thread
					.currentThread().getStackTrace()[1]);
		}
	}

	@Override
	public Integer updateSelective(T t) throws CustomException {
		try {
			return this.mapper.updateByPrimaryKeySelective(t);
		} catch (Exception e) {
			String params = "T:" + t.getClass().getName() + ",params:t=" + t.toString();
			throw BaseExceptionEnums.BaseImpl_updateSelective_00_error.throwCustomException(e, params, Thread
					.currentThread().getStackTrace()[1]);
		}
	}

	@Override
	public Integer deleteById(Integer id) throws CustomException {
		try {
			return this.mapper.deleteByPrimaryKey(id);
		} catch (Exception e) {
			String params = "params:id=" + id;
			throw BaseExceptionEnums.BaseImpl_deleteById_00_error.throwCustomException(e, params, Thread
					.currentThread().getStackTrace()[1]);
		}
	}

	@Override
	public Integer deleteByIds(Class<T> clazz, String property, List<Object> values) throws CustomException {
		try {
			Example example = new Example(clazz);
			example.createCriteria().andIn(property, values);
			return this.mapper.deleteByExample(example);
		} catch (Exception e) {
			String params = "T:" + clazz.getName() + ",params:[clazz=" + clazz.toString() + ",property="
					+ property + ",values=" + values.toString() + "]";
			throw BaseExceptionEnums.BaseImpl_deleteByIds_00_error.throwCustomException(e, params, Thread
					.currentThread().getStackTrace()[1]);
		}
	}

	@Override
	public Integer deleteByWhere(T record) throws CustomException {
		try {
			return this.mapper.delete(record);
		} catch (Exception e) {
			String params = "T:" + record.getClass().getName() + ",params:rocord=" + record.toString();
			throw BaseExceptionEnums.BaseImpl_deleteByWhere_00_error.throwCustomException(e, params, Thread
					.currentThread().getStackTrace()[1]);
		}
	}

}
