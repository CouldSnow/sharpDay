package com.zy.springboot.springbootmaven.test;


import com.zy.springboot.springbootmaven.Demo.Entity.Emp;
import com.zy.springboot.springbootmaven.Demo.Entity.Person;
import com.zy.springboot.springbootmaven.Demo.mapper.PersonMapper;
import com.zy.springboot.springbootmaven.Demo.service.EmpMapperService;
import com.zy.springboot.springbootmaven.Demo.service.PersonMapperService;
import com.zy.springboot.springbootmaven.Demo.service.serviceImpl.EmpMapperServiceImpl;
import com.zy.springboot.springbootmaven.Demo.service.serviceImpl.PersonMapperServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BootTest {

    @Autowired
    EmpMapperServiceImpl empMapperService;

    @Autowired
    PersonMapperServiceImpl personMapperService;

    //@Autowired
   // PersonMapper personMapper;
    @Test
    public void test1(){
       /* ApplicationContext app = new AnnotationConfigApplicationContext(MyConfigure.class);
        User user1 = app.getBean("user",User.class);
        System.out.println(user1.getAge());*/
//        System.out.println(user.getAge());
       // System.out.println(dataSource.toString());
        List<Person> personList = personMapperService.selectAll();
        for(Person person:personList){
            System.out.println(person);
        }
    }

    @Test
    public void test2(){
       /* ApplicationContext app = new AnnotationConfigApplicationContext(MyConfigure.class);
        User user1 = app.getBean("user",User.class);
        System.out.println(user1.getAge());*/
//        System.out.println(user.getAge());
        // System.out.println(dataSource.toString());
        List<Emp> empList = empMapperService.selectAll();
        for(Emp emp:empList){
            System.out.println(emp);
        }
    }
}
