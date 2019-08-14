package com.ljw.blog.common.enums;

import com.ljw.blog.common.exception.CustomException;
import com.ljw.blog.common.exception.ExceptionModelEums;
import com.ljw.blog.common.tools.ExceptionUtilsCls;

import java.util.HashMap;
import java.util.Map;


public enum BaseExceptionEnums {

    BaseImpl_queryById_00_error("10100", "通用业务层的的实现类,根据id查询数据,服务异常"),
    BaseImpl_queryAll_00_error("10200", "通用业务层的的实现类,查询所有数据,服务异常"),
    BaseImpl_queryOne_00_error("10300", "通用业务层的的实现类,根据条件查询一条数据,服务异常"),
    BaseImpl_queryListByWhere_00_error("10400", "通用业务层的的实现类,根据条件查询数据列表,服务异常"),
    BaseImpl_queryPageListByWhere_00_error("10500", "通用业务层的的实现类,分页查询数据列表,服务异常"),
    BaseImpl_save_00_error("10600", "通用业务层的的实现类,新增数据,服务异常"),
    BaseImpl_saveSelective_00_error("10700", "通用业务层的的实现类,有选择的保存,服务异常"),
    BaseImpl_update_00_error("10800", "通用业务层的的实现类,更新数据,服务异常"),
    BaseImpl_updateSelective_00_error("10900", "通用业务层的的实现类,有选择的更新,服务异常"),
    BaseImpl_deleteById_00_error("11000", "通用业务层的的实现类,根据id删除数据,服务异常"),
    BaseImpl_deleteByIds_00_error("11100", "通用业务层的的实现类,批量删除,服务异常"),
    BaseImpl_deleteByWhere_00_error("11200", "通用业务层的的实现类,根据条件删除数据,服务异常"),

    BaseOpImpl_queryById_00_error("10100", "通用业务层的的实现类,根据id查询数据,服务异常"),
    BaseOpImpl_queryAll_00_error("10200", "通用业务层的的实现类,查询所有数据,服务异常"),
    BaseOpImpl_queryOne_00_error("10300", "通用业务层的的实现类,根据条件查询一条数据,服务异常"),
    BaseOpImpl_queryListByWhere_00_error("10400", "通用业务层的的实现类,根据条件查询数据列表,服务异常"),
    BaseOpImpl_queryPageListByWhere_00_error("10500", "通用业务层的的实现类,分页查询数据列表,服务异常"),
    BaseOpImpl_save_00_error("10600", "通用业务层的的实现类,新增数据,服务异常"),
    BaseOpImpl_saveSelective_00_error("10700", "通用业务层的的实现类,有选择的保存,服务异常"),
    BaseOpImpl_update_00_error("10800", "通用业务层的的实现类,更新数据,服务异常"),
    BaseOpImpl_updateSelective_00_error("10900", "通用业务层的的实现类,有选择的更新,服务异常"),
    BaseOpImpl_deleteById_00_error("11000", "通用业务层的的实现类,根据id删除数据,服务异常"),
    BaseOpImpl_deleteByIds_00_error("11100", "通用业务层的的实现类,批量删除,服务异常"),
    BaseOpImpl_deleteByWhere_00_error("11200", "通用业务层的的实现类,根据条件删除数据,服务异常"),
    BaseOpImpl_deleteLogicById_00_error("11300", "通用业务层的的实现类,根据id逻辑删除数据,服务异常"),
    BaseOpImpl_deleteLogicByIds_00_error("11400", "通用业务层的的实现类,批量逻辑删除,服务异常"),

    ;

    private String code;
    private String msg;

    private BaseExceptionEnums(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return ExceptionModelEums.base + code;
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

    public static BaseExceptionEnums getEnum(String code) {
        BaseExceptionEnums resultEnum = null;
        BaseExceptionEnums[] enumAry = BaseExceptionEnums.values();
        for (int i = 0; i < enumAry.length; i++) {
            if (enumAry[i].getCode().equals(code)) {
                resultEnum = enumAry[i];
                break;
            }
        }
        return resultEnum;
    }

    public static Map<String, Map<String, Object>> toMap() {
        BaseExceptionEnums[] ary = BaseExceptionEnums.values();
        Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>();
        for (int num = 0; num < ary.length; num++) {
            Map<String, Object> map = new HashMap<String, Object>();
            String key = String.valueOf(getEnum(ary[num].getCode()));
            map.put("code", String.valueOf(ary[num].getCode()));
            map.put("msg", ary[num].getMsg());
            enumMap.put(key, map);
        }
        return enumMap;
    }

    public CustomException throwCustomException(Exception e, String params, StackTraceElement element)
            throws CustomException {
        CustomException customException = new CustomException(element.getClassName(), element.getMethodName(), ExceptionModelEums.base + code,
                msg);
        // 用于拼装异常信息的参数列表
        ExceptionUtilsCls.putCustomException(customException, e, params);
        return customException;
    }

    public Exception throwCustomException() throws Exception {
        return new Exception("{'code':'" + ExceptionModelEums.base + code + "','msg':'" + msg + "'}");
    }
}
