package com.zy.springboot.springbootmaven.configure;

import com.zy.springboot.springbootmaven.CommonUtils.CustomUtils;
import com.zy.springboot.springbootmaven.Demo.Entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class MyConfigure {

  @Bean("custom")
  public CustomUtils getCutomUtils(){
      CustomUtils customUtils = new CustomUtils();
      return customUtils;
  }

  @Bean
  public ThreadPoolTaskScheduler getThreadPoolScheduler(){
      return new ThreadPoolTaskScheduler();
  }


 /* @Bean("user")
    public User getUser(){
      User user = new User();
      user.setName("test");
      user.setAge(10);
      return user;
  }*/

}
