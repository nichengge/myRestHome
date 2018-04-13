package org.westos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.westos.entity.Oldman;
import org.westos.entity.OldmanExample;

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

	// 以下为自己添加的方法

	List<Oldman> selectUserByPage(@Param("begin") Integer begin, @Param("count") Integer count,
			@Param("oldman") Oldman oldman);

	int selectAllLine(@Param("oldman") Oldman oldman);

	void deleteByKeys(@Param("ids") List<Integer> ids);

	// 查找没有房间住的老人
	List<Oldman> selectNoRoomOldman(@Param("userId") Integer userId);

}