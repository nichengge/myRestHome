package org.westos.service;

import org.westos.entity.User;
import org.westos.page.Page;

public interface UserService {
	public Page<User> getPage(String currentPage, User user);

	public String addUser(User user);

	public void deleteById(User user);

	public void deleteByIds(Integer[] ids);

	public User queryById(User user);

	public void updateUser(User user);
}
