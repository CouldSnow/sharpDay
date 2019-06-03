package com.zy.springboot.springbootmaven.Diary.controller;

import cn.hutool.core.date.DateUtil;
import com.zy.springboot.springbootmaven.Diary.entity.BDiary;
import com.zy.springboot.springbootmaven.Diary.service.impl.BDiaryServiceImpl;
import com.zy.springboot.springbootmaven.utils.DateHelper;
import com.zy.springboot.springbootmaven.utils.WeatherHelper;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 添加新的日记
     * @param bDiary
     * @return
     */
    @PostMapping("/insertDiaryData")
    @ResponseBody
    public int insertDiaryData(@RequestBody()BDiary bDiary){
        System.out.println(bDiary);
        int id = bDiaryService.insert(bDiary);
        return id;
    }
}
