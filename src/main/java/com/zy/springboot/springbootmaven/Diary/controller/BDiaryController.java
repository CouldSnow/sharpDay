package com.zy.springboot.springbootmaven.Diary.controller;

import com.zy.springboot.springbootmaven.Diary.entity.BDiary;
import com.zy.springboot.springbootmaven.Diary.service.impl.BDiaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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


}
