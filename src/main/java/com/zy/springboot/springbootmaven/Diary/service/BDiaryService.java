package com.zy.springboot.springbootmaven.Diary.service;

import com.zy.springboot.springbootmaven.Diary.entity.BDiary;
import com.zy.springboot.springbootmaven.Diary.mapper.BDiaryMapper;

import java.util.List;

/**
 * Created by 73507 on 2019/6/3.
 */
public interface BDiaryService {
    int deleteByPrimaryKey(Integer id);

    int insert(BDiary record);

    BDiary selectByPrimaryKey(Integer id);

    List<BDiary> selectAll();

    int updateByPrimaryKey(BDiary record);
}
