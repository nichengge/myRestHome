package com.wuhongyu.service;

import java.util.List;

import com.wuhongyu.entity.User;

public interface UserService {
	public List<User> selectAll(User user);

	public void addUser(User user);

	public void deleteById(Integer id);

	public void deleteByIds(Integer[] ids);

	public User queryById(Integer id);

	public void updateUser(User user);
}
