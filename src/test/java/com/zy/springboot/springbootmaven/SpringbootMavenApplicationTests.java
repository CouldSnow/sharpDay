package com.zy.springboot.springbootmaven;

import com.zy.springboot.springbootmaven.Diary.service.impl.BDiaryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMavenApplicationTests {

    @Autowired
    BDiaryServiceImpl bDiaryService;

    @Test
    public void contextLoads() {
        int indext = bDiaryService.selectTodayDiary();
        System.out.println(indext);
    }

}
