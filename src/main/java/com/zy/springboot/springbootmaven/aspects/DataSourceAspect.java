package com.zy.springboot.springbootmaven.aspects;

import com.zy.springboot.springbootmaven.annotation.DataSource;
import com.zy.springboot.springbootmaven.datasource.DataSourceContextHolder;
import org.apache.naming.factory.DataSourceLinkFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
//@Order(1) //设置该类在spring容器中的加载顺序
public class DataSourceAspect {

    @Pointcut("@annotation(com.zy.springboot.springbootmaven.annotation.DataSource)")
    public void pointcut(){

    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        DataSource dataSource = method.getAnnotation(DataSource.class);

        if(dataSource!=null){
            DataSourceContextHolder.setDataSource(dataSource.value().name()); //设置本地数据源

        }
        try{
            return joinPoint.proceed();
        }finally {
            DataSourceContextHolder.clearDataSource();
        }
    }
}
