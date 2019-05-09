package com.ljw.blog.manage.mapper;

import org.apache.ibatis.annotations.Select;

/**
 * @author: lujunwei
 * @time: 13:31 2019/4/25
 * @des:
 */
public interface CronMapper {

    @Select("SELECT T.CRON_EXP FROM db_cron T WHERE T.IS_AVAILABLE = 1 AND T.CRON_TYPE= #{cronType} ORDER BY T.UPDATE_DATE DESC ")
     String getCron(String cronType);
}
