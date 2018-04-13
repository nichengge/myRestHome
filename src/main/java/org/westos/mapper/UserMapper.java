package org.westos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.westos.entity.User;
import org.westos.entity.UserExample;

public interface UserMapper {
	int countByExample(UserExample example);

	int deleteByExample(UserExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(User record);

	int insertSelective(User record);

	List<User> selectByExample(UserExample example);

	User selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

	int updateByExample(@Param("record") User record, @Param("example") UserExample example);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	// 以下方法为自己添加
	List<User> selectUserByPage(@Param("begin") Integer begin, @Param("count") Integer count, @Param("user") User user);

	int selectAllLine(@Param("user") User user);

	void deleteByKeys(@Param("ids") List<Integer> ids);
	
	@Select("SELECT COUNT(id) FROM user WHERE username = #{username}" )
	int selectByUserName(@Param("username") String username);

}