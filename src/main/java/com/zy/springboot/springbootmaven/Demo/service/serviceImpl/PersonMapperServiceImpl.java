package com.zy.springboot.springbootmaven.Demo.service.serviceImpl;

import com.zy.springboot.springbootmaven.Demo.Entity.Person;
import com.zy.springboot.springbootmaven.Demo.mapper.PersonMapper;
import com.zy.springboot.springbootmaven.Demo.service.PersonMapperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PersonMapperServiceImpl implements PersonMapperService {

    @Resource
    private PersonMapper personMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return personMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Person record) {
        return personMapper.insert(record);
    }

    @Override
    public Person selectByPrimaryKey(Integer id) {
        return personMapper.selectByPrimaryKey(id);
    }


    @Override
    public List<Person> selectAll() {
        return personMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Person record) {
        return personMapper.updateByPrimaryKey(record);
    }
}
