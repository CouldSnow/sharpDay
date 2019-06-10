package com.zy.springboot.springbootmaven.Diary.controller;

import cn.hutool.core.date.DateUtil;
import com.zy.springboot.springbootmaven.Diary.entity.BDiary;
import com.zy.springboot.springbootmaven.Diary.service.impl.BDiaryServiceImpl;
import com.zy.springboot.springbootmaven.utils.DateHelper;
import com.zy.springboot.springbootmaven.utils.WeatherHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by 73507 on 2019/6/3.
 */
@Controller
@RequestMapping("/diary")
public class BDiaryController {

    @Autowired
    private BDiaryServiceImpl bDiaryService;

    @RequestMapping("/listData")
    @ResponseBody
    public List<BDiary> getAllData(){
        return bDiaryService.selectAll();
    }

    @GetMapping("/addDiary")
    public String  toEditor(HttpServletRequest request , Model model) throws Exception{
        String ip = request.getRemoteHost();
        String dateTime = DateUtil.format(new Date(),"yyyy-MM-dd");
        String weekDay = DateHelper.getTodayWeek();
        Map weatherMap = WeatherHelper.getWeather("101120301");
        model.addAttribute("weather",weatherMap);
        model.addAttribute("host",ip);
        model.addAttribute("date",dateTime);
        model.addAttribute("week",weekDay);
        return "diary/addDiary";
    }

    @GetMapping("/mainDiary")
    public String toMainDiary(){
        return "diary/mainDiary";
    }

    /**
     * 添加新的日记
     * @param bDiary
     * @return
     */
    @PostMapping("/insertDiaryData")
    @ResponseBody
    public int insertDiaryData(@RequestBody()BDiary bDiary){
        int count = bDiaryService.insert(bDiary);
        return bDiary.getId();
    }


    /**
     * 定时任务，发送短信
     * 每天22点5分触发
     */
    @Scheduled(cron = "0 5 22 * * ?")
    public void sendMessage(){
        int index = bDiaryService.selectTodayDiary();
        if(index == 0){ //没有写
                //调用短信接口
            System.out.println("111111111111111111111111111111111111111111111111111111111111");
        }else{
            System.out.println("触发定时器任务");
        }
    }
}
