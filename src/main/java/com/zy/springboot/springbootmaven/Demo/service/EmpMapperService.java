package com.zy.springboot.springbootmaven.Demo.service;

import com.zy.springboot.springbootmaven.Demo.Entity.Emp;

import java.util.List;

public interface EmpMapperService {

    int deleteByPrimaryKey(Integer id);

    int insert(Emp record);

    Emp selectByPrimaryKey(Integer id);

    List<Emp> selectAll();

    int updateByPrimaryKey(Emp record);
}
