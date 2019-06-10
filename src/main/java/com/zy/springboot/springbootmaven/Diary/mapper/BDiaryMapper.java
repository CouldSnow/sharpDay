package com.zy.springboot.springbootmaven.Diary.mapper;

import com.zy.springboot.springbootmaven.Diary.entity.BDiary;
import java.util.List;

public interface BDiaryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BDiary record);

    BDiary selectByPrimaryKey(Integer id);

    List<BDiary> selectAll();

    int updateByPrimaryKey(BDiary record);

    int selectTodayDiary();
}