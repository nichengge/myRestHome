package com.wuhongyu.mapper;

import com.wuhongyu.entity.Counts;
import com.wuhongyu.entity.CountsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CountsMapper {
    int countByExample(CountsExample example);

    int deleteByExample(CountsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Counts record);

    int insertSelective(Counts record);

    List<Counts> selectByExample(CountsExample example);

    Counts selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Counts record, @Param("example") CountsExample example);

    int updateByExample(@Param("record") Counts record, @Param("example") CountsExample example);

    int updateByPrimaryKeySelective(Counts record);

    int updateByPrimaryKey(Counts record);

    List<Counts> selectAll();
}