package org.westos.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.westos.entity.Oldman;
import org.westos.entity.OldmanExample;
import org.westos.entity.Orders;
import org.westos.entity.Room;
import org.westos.entity.User;
import org.westos.mapper.OldmanMapper;
import org.westos.mapper.OrdersMapper;
import org.westos.mapper.UserMapper;
import org.westos.page.Page;
import org.westos.service.ParamedicService;

@Component
public class ParamedicServiceImpl implements ParamedicService {
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private RoomServiceImpl roomServiceImpl;
	@Autowired
	private OrdersServiceImpl ordersServiceImpl;
	@Autowired
	private OldmanMapper oldmanMapper;

	@Override
	public User getMyMessage(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public Page<Room> getRestOfRoom(Room room, String currentPage) {
		room.setStatus(0);
		Page<Room> pageList = roomServiceImpl.getPage(currentPage, room);
		return pageList;
	}

	@Override
	public void updateMessage(User user) {
		user.setUsername(userMapper.selectByPrimaryKey(user.getId()).getUsername());
		userMapper.updateByPrimaryKey(user);
	}

	public List<Oldman> getMyOldman(User user) {
		List<Oldman> list = oldmanMapper.selectNoRoomOldman(user.getId());
		return list;
	}

	public String opened(Orders orders) {
		if (orders != null) {
			OldmanExample oldmanExample = new OldmanExample();
			oldmanExample.createCriteria().andNameEqualTo(orders.getOldmanName());
			List<Oldman> oldmanList = oldmanMapper.selectByExample(oldmanExample);
			orders.setOldid(oldmanList.get(0).getId());
			orders.setPrice(this.amount(orders.getRoomid(), orders.getDuration()));
			Long currentTimeMillis = System.currentTimeMillis();
			Date createtime = new Date(currentTimeMillis);
			orders.setCreatetime(createtime);
			orders.setStatus(0);
			System.out.println("orders:" + orders);
			ordersMapper.insert(orders);
			return "申请成功,请等待管理员审核";

		}
		return "申请失败,发生未知错误";
	}

	public BigDecimal amount(Integer roomid, Integer duration) {
		Room room = new Room();
		room.setId(roomid);
		room = roomServiceImpl.queryById(room);
		BigDecimal price = room.getPrice();
		BigDecimal duration2 = new BigDecimal(duration);
		price = price.multiply(duration2);
		return price;
	}

	public Page<Orders> getMyOrders(String current, Orders orders) {
		return ordersServiceImpl.getPage(current, orders);
	}

}
