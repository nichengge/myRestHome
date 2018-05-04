package com.wuhongyu.mapper;

import com.wuhongyu.entity.Leaves;
import com.wuhongyu.entity.LeavesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LeavesMapper {
    int countByExample(LeavesExample example);

    int deleteByExample(LeavesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Leaves record);

    int insertSelective(Leaves record);

    List<Leaves> selectByExample(LeavesExample example);

    Leaves selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Leaves record, @Param("example") LeavesExample example);

    int updateByExample(@Param("record") Leaves record, @Param("example") LeavesExample example);

    int updateByPrimaryKeySelective(Leaves record);

    int updateByPrimaryKey(Leaves record);

    List<Leaves> selectAll(@Param("uid")Integer uid);

    void deleteBefore(@Param("date")String date);

    int selectLeaveCount(@Param("uid")Integer uid);
}