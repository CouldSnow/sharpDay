package com.zy.springboot.springbootmaven.Demo.mapper;

import com.zy.springboot.springbootmaven.Demo.Entity.Emp;
import java.util.List;

public interface EmpMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Emp record);

    Emp selectByPrimaryKey(Integer id);

    List<Emp> selectAll();

    int updateByPrimaryKey(Emp record);
}