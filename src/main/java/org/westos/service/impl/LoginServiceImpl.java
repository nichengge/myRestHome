package org.westos.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.westos.entity.Admin;
import org.westos.entity.AdminExample;
import org.westos.entity.Orders;
import org.westos.entity.OrdersExample;
import org.westos.entity.Room;
import org.westos.entity.User;
import org.westos.entity.UserExample;
import org.westos.exception.LoginExpection;
import org.westos.mapper.AdminMapper;
import org.westos.mapper.OrdersMapper;
import org.westos.mapper.RoomMapper;
import org.westos.mapper.UserMapper;
import org.westos.service.LoginService;

@Component
public class LoginServiceImpl implements LoginService {
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private RoomMapper roomMapper;
	@Autowired
	private UserMapper userMapper;

	// 订单过期验证
	@Override
	public void OrdersExpiredVerification() {
		OrdersExample ordersExample = new OrdersExample();
		ordersExample.createCriteria();
		Date date = new Date();
		Calendar c = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		List<Orders> ordersList = ordersMapper.selectByExample(ordersExample);
		for (Orders orders : ordersList) {
			Date createtime = orders.getCreatetime();
			Integer duration = orders.getDuration();
			c.setTime(createtime);
			c.add(Calendar.MONTH, duration);
			c2.setTime(date);
			if (c2.after(c)) {
				Integer roomid = orders.getRoomid();
				Room room = new Room();
				room.setId(roomid);
				room.setStatus(0);
				room.setOldid(0);
				roomMapper.updateByPrimaryKeySelective(room);
			}

		}
	}

	
	// 注册功能
	@Override
	public void register(String username, String password, String type) throws LoginExpection {
		if ("管理员".equals(type)) {
			// 判断用户名是否重复
			boolean result = this.userNameIsRepeat(username, type);
			if (result) {
				throw new LoginExpection("用户名已存在");
			}
			Admin admin = new Admin();
			admin.setUsername(username);
			admin.setPassword(password);
			adminMapper.insert(admin);
		} else if ("护理人员".equals(type)) {
			// 判断用户名是否重复
			boolean result = this.userNameIsRepeat(username, type);
			if (result) {
				throw new LoginExpection("用户名已存在");
			}
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			userMapper.insert(user);
		}

	}

	// 判断用户名是否重复
	@Override
	public boolean userNameIsRepeat(String username, String type) {
		if ("管理员".equals(type)) {
			Integer count = adminMapper.selectByUserName(username);
			if (count == 1) {
				return true;
			}
		} else if ("护理人员".equals(type)) {
			Integer count = userMapper.selectByUserName(username);
			if (count == 1) {
				return true;
			}
		}
		return false;
	}


	@Override
	public Object login(String username, String password, String type) throws Exception {
		if ("管理员".equals(type)) {
			AdminExample adminExample = new AdminExample();
			adminExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
			List<Admin> list = adminMapper.selectByExample(adminExample);
			if (list.size() != 1) {
				throw new LoginExpection("用户名或密码错误");
			}
			return list.get(0);

		} else if ("护理人员".equals(type)) {
			UserExample userExample = new UserExample();
			userExample.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
			List<User> list = userMapper.selectByExample(userExample);
			if (list.size() != 1) {
				throw new LoginExpection("用户名或密码错误");
			}
			return list.get(0);
		}
		return "未知错误";
		
	}
}
