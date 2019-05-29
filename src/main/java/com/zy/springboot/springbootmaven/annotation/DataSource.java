package com.zy.springboot.springbootmaven.annotation;

import com.zy.springboot.springbootmaven.datasource.DataSourceType;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSource {

    public DataSourceType value() default DataSourceType.MASTER;
}
