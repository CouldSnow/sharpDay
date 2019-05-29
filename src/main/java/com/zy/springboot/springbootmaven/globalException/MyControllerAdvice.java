package com.zy.springboot.springbootmaven.globalException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyControllerAdvice {

    /**
     * 全局变量捕捉
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView errorHandle(Exception e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("demo/error");
        modelAndView.addObject("code","100");
        modelAndView.addObject("msg",e.getMessage());
        return modelAndView;
    }

    /**
     * 拦截捕捉自定义异常
     * @param e
     * @return
     */
    @ExceptionHandler(value=MyException.class)
    @ResponseBody
    public Map myErrorHandler(MyException e){
        Map map = new HashMap();
        map.put("code",e.getCode());
        map.put("msg",e.getMsg());
        return map;
    }
}
