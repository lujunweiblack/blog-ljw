package com.ljw.blog.common.entity;

import java.io.Serializable;


import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;
//import org.codehaus.jackson.annotate.JsonUnwrapped;       //可能有问题  TODO

/**
 * @author 作者 jk
 * @date 2019/5/11 14:26
 */

public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -1449875354570226204L;
    //页码
    @Transient
    protected Integer pageNum;

    //每页条数
    @Transient
    protected Integer pageSize;

    @JsonUnwrapped      //作用在属性字段或方法上，用来将子JSON对象的属性添加到封闭的JSON对象
    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    @JsonUnwrapped
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
