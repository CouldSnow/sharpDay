package com.zy.springboot.springbootmaven.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by 73507 on 2019/6/10.
 */
@Configuration
@Component
//@EnableScheduling
public class DynamicScheduleTask implements SchedulingConfigurer{
    /**
     * 执行定时任务
     * @param taskRegistrar
     */
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
         taskRegistrar.addTriggerTask(
                 ()-> System.out.println("执行动态定时任务: " + LocalDateTime.now().toLocalTime()),
                 triggerContext -> {
                     String cron="0/2 * * * * ?";
                     return new CronTrigger(cron).nextExecutionTime(triggerContext);
                 }
                 );
    }
}
