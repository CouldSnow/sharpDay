package com.zy.springboot.springbootmaven.Demo.controller;

import com.zy.springboot.springbootmaven.CommonUtils.CustomUtils;
import com.zy.springboot.springbootmaven.annotation.MyLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource(name="custom")
    CustomUtils customUtils;

    @RequestMapping("/hello")
    public String helloWorld(){

        return customUtils.test();
    }
}
