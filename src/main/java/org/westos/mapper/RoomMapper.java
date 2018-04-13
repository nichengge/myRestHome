package org.westos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.westos.entity.Room;
import org.westos.entity.RoomExample;

public interface RoomMapper {
	int countByExample(RoomExample example);

	int deleteByExample(RoomExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Room record);

	int insertSelective(Room record);

	List<Room> selectByExample(RoomExample example);

	Room selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Room record, @Param("example") RoomExample example);

	int updateByExample(@Param("record") Room record, @Param("example") RoomExample example);

	int updateByPrimaryKeySelective(Room record);

	int updateByPrimaryKey(Room record);

	// 以下为自己添加的方法

	List<Room> selectUserByPage(@Param("begin") Integer begin, @Param("count") Integer count, @Param("room") Room room);

	int selectAllLine(@Param("room") Room room);

	void deleteByKeys(@Param("ids") List<Integer> ids);
}