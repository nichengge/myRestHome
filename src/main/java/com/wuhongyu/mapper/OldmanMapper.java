package com.wuhongyu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wuhongyu.entity.Oldman;
import com.wuhongyu.entity.OldmanExample;

public interface OldmanMapper {
    int countByExample(OldmanExample example);

    int deleteByExample(OldmanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Oldman record);

    int insertSelective(Oldman record);

    List<Oldman> selectByExample(OldmanExample example);

    Oldman selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Oldman record, @Param("example") OldmanExample example);

    int updateByExample(@Param("record") Oldman record, @Param("example") OldmanExample example);

    int updateByPrimaryKeySelective(Oldman record);

    int updateByPrimaryKey(Oldman record);
    
    
    List<Oldman> selectAll(@Param("oldman") Oldman oldman);

    List<Oldman> selectFreeOldman(@Param("uid")Integer uid);
    
}