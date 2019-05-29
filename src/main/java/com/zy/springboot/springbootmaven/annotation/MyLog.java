package com.zy.springboot.springbootmaven.annotation;


import java.lang.annotation.*;

/**
 * 自定义操作日志记录注解
 * 
 * @author numberone
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyLog {
    /**
     * 模块
     */
    public String title() default "";
    /**
     * 功能
     */
    public String businessType() default "";
    /**
     * 操作人
     */
    public String opratorType() default "";

    /**
     * 是否保存请求参数
     */
    public boolean isSaveReuestData() default true;
}
