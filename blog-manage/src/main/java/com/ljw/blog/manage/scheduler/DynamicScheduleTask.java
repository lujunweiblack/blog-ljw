package com.ljw.blog.manage.scheduler;

import com.ljw.blog.common.tools.DataTools;
import com.ljw.blog.manage.mapper.CronMapper;
import com.ljw.blog.manage.scheduler.JobTask.DataBaseBackup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import static com.ljw.blog.common.constant.SchedulerCon.DATABASE_BACKUP;

/**
 * @author: lujunwei
 * @time: 13:27 2019/4/25
 * @des:
 */
@Configuration
@EnableScheduling
public class DynamicScheduleTask implements SchedulingConfigurer {

    @Autowired
    private CronMapper cronMapper;

    @Autowired
    private DataBaseBackup dataBaseBackup;

    /**
     * @author: lujunwei
     * @param: [taskRegistrar]
     * @return: void
     * @time: 14:01 2019/4/25
     * @des: 动态执行定时任务(备份数据库)
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.addTriggerTask(
                () -> dataBaseBackup.startJob(),
                triggerContext -> {
                    String cron = cronMapper.getCron(DATABASE_BACKUP);
                    if (!DataTools.dataIsNotNullAndEmpty(cron)) {
                        throw new RuntimeException("============== cron 表达式配置错误 ==============");
                    }
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
    }

}