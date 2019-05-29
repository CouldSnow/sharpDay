package com.zy.springboot.springbootmaven;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}) // 配置多数据源时如果不配置这一个会造成循环自动注入
@MapperScan("com.zy.springboot.springbootmaven.Demo.mapper")
@EnableAspectJAutoProxy(proxyTargetClass = true) //打开自动注解 默认时true
public class SpringbootMavenApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMavenApplication.class, args);
    }

}
