package com.zy.springboot.springbootmaven.Diary.service.impl;

import com.zy.springboot.springbootmaven.Diary.entity.BDiary;
import com.zy.springboot.springbootmaven.Diary.mapper.BDiaryMapper;
import com.zy.springboot.springbootmaven.Diary.service.BDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 73507 on 2019/6/3.
 */
@Service
public class BDiaryServiceImpl implements BDiaryService {

    @Resource
    BDiaryMapper bDiaryMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return bDiaryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(BDiary record) {
        return bDiaryMapper.insert(record);
    }

    @Override
    public BDiary selectByPrimaryKey(Integer id) {
        return bDiaryMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<BDiary> selectAll() {
        return bDiaryMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(BDiary record) {
        return bDiaryMapper.updateByPrimaryKey(record);
    }
}
