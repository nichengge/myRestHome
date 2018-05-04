package com.wuhongyu.mapper;

import com.wuhongyu.entity.Lelve;
import com.wuhongyu.entity.LelveExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LelveMapper {
    int countByExample(LelveExample example);

    int deleteByExample(LelveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Lelve record);

    int insertSelective(Lelve record);

    List<Lelve> selectByExample(LelveExample example);

    Lelve selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Lelve record, @Param("example") LelveExample example);

    int updateByExample(@Param("record") Lelve record, @Param("example") LelveExample example);

    int updateByPrimaryKeySelective(Lelve record);

    int updateByPrimaryKey(Lelve record);

    List<Lelve> selectAll(@Param("lelve") Lelve lelve);

    Lelve queryByOldid(@Param("oldid")Integer oldid);


}