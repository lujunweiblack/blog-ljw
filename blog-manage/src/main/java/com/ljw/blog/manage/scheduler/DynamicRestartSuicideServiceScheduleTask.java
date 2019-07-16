package com.ljw.blog.manage.scheduler;

import com.ljw.blog.common.tools.DataTools;
import com.ljw.blog.manage.mapper.CronMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.io.IOException;

import static com.ljw.blog.common.constant.SchedulerCon.RESTART_SERVICE;

/**
 * @author: lujunwei
 * @time: 10:22 2019/6/3
 * @des:
 */
//@Slf4j
//@Configuration
//@EnableScheduling
public class DynamicRestartSuicideServiceScheduleTask
       // implements SchedulingConfigurer
{

//    @Autowired
//    private CronMapper cronMapper;
//
//    /**
//     * @author: lujunwei
//     * @param:
//     * @return:
//     * @time: 10:26 2019/6/3
//     * @des: 定时检查已经关闭的服务并尝试重启
//     */
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        taskRegistrar.addTriggerTask(
//                () -> {
//                    try {
//                        Runtime.getRuntime().exec("/project/portal-restart.sh");
//                        Runtime.getRuntime().exec("/project/manage-restart.sh");
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                        log.error("============== 扫描失败： {} ==============", e.getMessage());
//                    }
//                },
//                triggerContext -> {
//                    String cron = cronMapper.getCron(RESTART_SERVICE);
//                    if (!DataTools.dataIsNotNullAndEmpty(cron)) {
//                        throw new RuntimeException("============== cron 表达式配置错误 ==============");
//                    }
//                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
//                }
//        );
//    }
}
