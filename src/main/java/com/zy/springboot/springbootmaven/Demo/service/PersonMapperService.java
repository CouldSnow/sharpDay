package com.zy.springboot.springbootmaven.Demo.service;

import com.zy.springboot.springbootmaven.Demo.Entity.Person;

import java.util.List;

public interface PersonMapperService {

    int deleteByPrimaryKey(Integer id);

    int insert(Person record);

    Person selectByPrimaryKey(Integer id);

    List<Person> selectAll();

    int updateByPrimaryKey(Person record);
}
