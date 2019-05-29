package com.zy.springboot.springbootmaven.CommonUtils;

import org.springframework.beans.factory.annotation.Value;

public class CustomUtils {

    @Value("${custom.field.message}")
    private String message;

    public String  test(){
        return message;
    }
}
