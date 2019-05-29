package com.zy.springboot.springbootmaven.Demo.service.serviceImpl;

import com.zy.springboot.springbootmaven.Demo.Entity.Emp;
import com.zy.springboot.springbootmaven.Demo.mapper.EmpMapper;
import com.zy.springboot.springbootmaven.Demo.service.EmpMapperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class EmpMapperServiceImpl implements EmpMapperService {

    @Resource
    private EmpMapper empMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return empMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Emp record) {
        return empMapper.insert(record);
    }

    @Override
    public Emp selectByPrimaryKey(Integer id) {
        return empMapper.selectByPrimaryKey(id);
    }

    //@DataSource(DataSourceType.SLAVE)
    @Override
    public List<Emp> selectAll() {
        return empMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Emp record) {
        return empMapper.updateByPrimaryKey(record);
    }
}
