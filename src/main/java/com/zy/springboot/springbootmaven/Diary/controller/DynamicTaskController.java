package com.zy.springboot.springbootmaven.Diary.controller;

import com.zy.springboot.springbootmaven.CommonUtils.MyRunnable;
import com.zy.springboot.springbootmaven.utils.GroovyHelper;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

@Controller
@RequestMapping("/quartz")
public class DynamicTaskController {

    @Resource
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private static final Map<String, ScheduledFuture<?>> futureMap = new HashMap<>();

    /**
     * 启动默认定时器
     * @param id
     * @param cron
     * @return
     */
    @GetMapping("/start")
    @ResponseBody
    public String startCron(@RequestParam("id")String id, @RequestParam("cron")String cron){

        ScheduledFuture future = threadPoolTaskScheduler.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("启动默认定时器");
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                return new CronTrigger(cron).nextExecutionTime(triggerContext);
            }
        });

        futureMap.put(id,future);

        return "启动成功";
    }


    @GetMapping("/start1")
    @ResponseBody
    public String startCron1(){
        StringBuilder sb = new StringBuilder();
        sb.append("public class Test implements Runnable{ public void run(){ System.out.println(\"123\")}} ");
        return startCron1("11","0/2 * * * * ?",sb.toString());
    }

    /**
     *继承runnable接口，传入自定义定时器
     * @param id
     * @param cron
     * @param runnable
     * @return
     */
    public String startCron1(@RequestParam("id")String id, @RequestParam("cron")String cron, Runnable runnable){

        ScheduledFuture future = threadPoolTaskScheduler.schedule(runnable, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                return new CronTrigger(cron).nextExecutionTime(triggerContext);
            }
        });

        futureMap.put(id,future);

        return "启动成功";
    }

     /**
     * 编译自定义java脚本,启动定时任务
     * @param id
     * @param cron
     * @param
     * @return
      */
    public String startCron1(@RequestParam("id")String id, @RequestParam("cron")String cron, @RequestParam("classContext")String classContext){

        Runnable runnable = null;
        try {
            runnable = GroovyHelper.getEntity(classContext);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ScheduledFuture future = threadPoolTaskScheduler.schedule(runnable, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                return new CronTrigger(cron).nextExecutionTime(triggerContext);
            }
        });

        futureMap.put(id,future);

        return "启动成功";
    }

    @GetMapping("/close")
    @ResponseBody
    public String closeCron(@RequestParam("id")String id){
        ScheduledFuture future = futureMap.get(id);
        if(future!=null){
            future.cancel(true);
        }
        return "关闭";
    }
}
