package com.zy.springboot.springbootmaven.test;

import cn.hutool.core.util.EscapeUtil;
import cn.hutool.core.util.HexUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.annotation.*;
import java.lang.reflect.Method;

public class HutoolTest {

    //十六进制操作
    @Test
    @Comment("十六进制操作")
    public void test1(){
        String s1 ="12";
        boolean b1 = HexUtil.isHexNumber(s1);
        System.out.println(b1);
        String s2="test";
        HexUtil.decodeHexStr(s2);
        System.out.println(s2);
    }

    @Test
    @Comment("转义与非转义")
    public void test2(){
        String s1="<script>location.href='http://www.baidu.com;</script>'";
        String s2 = EscapeUtil.escapeHtml4(s1);
        System.out.println(s2);
    }


    @Target({ElementType.METHOD,ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    @Documented
    public @interface Comment{
        String value() default "";
    }



}
