package com.zy.springboot.springbootmaven.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by 73507 on 2019/6/3.
 */
public class DateHelper {

    private static final String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};

    public static String getTodayWeek(){
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        int weekDay=c.get(Calendar.DAY_OF_WEEK);
        return weeks[weekDay-1];
    }

    public static void main(String[] args) {
        System.out.println(getTodayWeek());
    }
}
