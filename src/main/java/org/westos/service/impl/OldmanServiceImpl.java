package org.westos.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.westos.common.MyCommon;
import org.westos.entity.Oldman;
import org.westos.entity.User;
import org.westos.entity.UserExample;
import org.westos.mapper.OldmanMapper;
import org.westos.mapper.UserMapper;
import org.westos.page.Page;
import org.westos.service.OldmanService;

@Component
public class OldmanServiceImpl implements OldmanService {
	@Autowired
	private OldmanMapper oldmanMapper;
	@Autowired
	private UserMapper userMapper;
	private Integer count = MyCommon.COMMON_COUNT;

	/**
	 * 得到page
	 */
	@Override
	public Page<Oldman> getPage(String current, Oldman oldman) {
		int allLine = oldmanMapper.selectAllLine(oldman);
		Page<Oldman> page = new Page<Oldman>();
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
		List<Oldman> list = oldmanMapper.selectUserByPage(begin, count, oldman);
		page.setList(list);
		return page;
	}

	@Override
	public String addOldman(Oldman oldman) {
		if (oldman.getUsername() != null && !"".equals(oldman.getUsername())) {
			UserExample userExample = new UserExample();
			userExample.createCriteria().andUsernameEqualTo(oldman.getUsername());
			List<User> userList = userMapper.selectByExample(userExample);
			User user2 = userList.get(0);
			oldman.setUserId(user2.getId());
			if (MyCommon.COMMON_NOPIC.equals(oldman.getPic())) {
				oldman.setPic("没有添加图片");
			}
		}
		oldmanMapper.insert(oldman);
		return "添加成功....";
	}

	@Override
	public void deleteById(Oldman oldman) {
		Integer id = oldman.getId();
		oldmanMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteByIds(Integer[] ids) {
		if (ids != null) {
			List<Integer> idList = Arrays.asList(ids);
			oldmanMapper.deleteByKeys(idList);
		}
	}

	/**
	 * 通过老人的id和老人的userId完善Oldman这个实体类
	 */
	@Override
	public Oldman queryById(Oldman oldman) {
		Oldman resultOldman = oldmanMapper.selectByPrimaryKey(oldman.getId());
		User user = userMapper.selectByPrimaryKey(resultOldman.getUserId());
		resultOldman.setUsername(user.getUsername());
		return resultOldman;
	}

	@Override
	public void updateOldman(Oldman oldman) {
		// 如果没有输入老人的照片 就不改变这个照片
		if (MyCommon.COMMON_PIC.equals(oldman.getPic())) {
			Oldman selectOldman = oldmanMapper.selectByPrimaryKey(oldman.getId());
			oldman.setPic(selectOldman.getPic());
		}
		// 如果没有传进username,说明是从护理人员页面传进来的,那就无需以下操作
		if (oldman.getUsername() != null) {
			// 如果老人的username改变了 就改变老人的userId
			User user = userMapper.selectByPrimaryKey(oldman.getUserId());
			if (!user.getUsername().equals(oldman.getUsername())) {
				UserExample userExample = new UserExample();
				userExample.createCriteria().andUsernameEqualTo(oldman.getUsername());
				List<User> userList = userMapper.selectByExample(userExample);
				User user2 = userList.get(0);
				oldman.setUserId(user2.getId());
			}
		}
		oldmanMapper.updateByPrimaryKey(oldman);
	}

	/**
	 * 获取除了当前老人的护理人员之外的所有护理人员
	 */
	@Override
	public List<User> getUsersExcept(Integer userId) {
		UserExample userExample = new UserExample();
		userExample.createCriteria();
		List<User> users = userMapper.selectByExample(userExample);
		for (User user : users) {
			if (userId.equals(user.getId())) {
				users.remove(users.indexOf(user));
				break;
			}
		}
		return users;
	}

}
