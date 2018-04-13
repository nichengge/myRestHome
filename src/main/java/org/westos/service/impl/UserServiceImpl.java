package org.westos.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.westos.common.MyCommon;
import org.westos.entity.User;
import org.westos.entity.UserExample;
import org.westos.mapper.UserMapper;
import org.westos.page.Page;
import org.westos.service.UserService;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	private Integer count = MyCommon.COMMON_COUNT;

	@Override
	public Page<User> getPage(String current, User user) {
		int allLine = userMapper.selectAllLine(user);
		Page<User> page = new Page<User>();
		page.setAllLine(allLine);
		page.setCount(this.count);
		Integer currentPage;
		try {
			currentPage = Integer.parseInt(current);
			if (currentPage == null || currentPage <= 0) {
				currentPage = 1;
			} else if (currentPage > page.getAllPage()) {
				currentPage = page.getAllPage();
			}
		} catch (NumberFormatException e) {
			currentPage = 1;
		}
		page.setCurrentPage(currentPage);
		Integer begin = (currentPage - 1) * count;
		List<User> list = userMapper.selectUserByPage(begin, count, user);
		page.setList(list);
		return page;
	}

	@Override
	public String addUser(User user) {
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUsernameEqualTo(user.getUsername());
		List<User> list = userMapper.selectByExample(userExample);
		if (list != null && list.size() >= 1) {
			return "失败: 用户名已经存在.....";
		}
		userMapper.insert(user);
		return "成功....";
	}

	@Override
	public void deleteById(User user) {
		Integer id = user.getId();
		userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteByIds(Integer[] ids) {
		if (ids != null) {
			List<Integer> idList = Arrays.asList(ids);
			userMapper.deleteByKeys(idList);
		} else {
			System.out.println("这个checkid是空的");
		}
	}

	@Override
	public User queryById(User user) {
		Integer id = user.getId();
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateByPrimaryKey(user);
	}

}
