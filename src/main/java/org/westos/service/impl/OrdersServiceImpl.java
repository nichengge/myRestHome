package org.westos.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.westos.common.MyCommon;
import org.westos.entity.Oldman;
import org.westos.entity.OldmanExample;
import org.westos.entity.Orders;
import org.westos.entity.OrdersExample;
import org.westos.entity.Room;
import org.westos.entity.RoomExample;
import org.westos.entity.User;
import org.westos.entity.UserExample;
import org.westos.mapper.OldmanMapper;
import org.westos.mapper.OrdersMapper;
import org.westos.mapper.RoomMapper;
import org.westos.mapper.UserMapper;
import org.westos.page.Page;
import org.westos.service.OrdersService;

@Component
public class OrdersServiceImpl implements OrdersService {
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private RoomMapper roomMapper;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private OldmanMapper oldmanMapper;
	
	//分页的行数
	private Integer count = MyCommon.COMMON_COUNT;

	@Override
	public Page<Orders> getPage(String current, Orders orders) {
		if (orders == null) {
			orders = new Orders();
		}
		int allLine = ordersMapper.selectAllLine(orders);
		Page<Orders> page = new Page<Orders>();
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
		List<Orders> list = ordersMapper.selectOrderByPage(begin, count, orders);
		page.setList(list);
		return page;
	}

	@Override
	public String addOrders(Orders orders) {
		ordersMapper.insert(orders);
		return "添加成功....";
	}

	
	@Override
	public Orders queryById(Integer id) {
		return ordersMapper.selectOrderById(id);
	}

	//修改订单的功能
	//这里能改变的有userName oldmanName roomName duration 
	@Override
	public void updateOrders(Orders orders) {
		Orders orders1 = ordersMapper.selectOrderById(orders.getId());
		if(!orders.equals(orders1)) {
			RoomExample roomExample = new RoomExample();
			roomExample.createCriteria();
			Room room = roomMapper.selectByExample(roomExample).get(0);
			if(!orders1.getUserName().equals(orders.getUserName())) {
				UserExample userExample = new UserExample();
				userExample.createCriteria();
				User user = userMapper.selectByExample(userExample).get(0);
				orders.setUid(user.getId());
			}else if(!orders1.getOldmanName().equals(orders.getOldmanName())) {
				OldmanExample oldmanExample = new OldmanExample();
				oldmanExample.createCriteria();
				Oldman oldman = oldmanMapper.selectByExample(oldmanExample).get(0);
				orders.setOldid(oldman.getId());
			}else if(!orders1.getRoomName().equals(orders.getRoomName())) {
				orders.setRoomid(room.getId());
			}
			BigDecimal price = room.getPrice();
			Integer dura = orders.getDuration();
			BigDecimal duration = new BigDecimal(dura);
			price = price.multiply(duration);
			orders.setPrice(price);
			ordersMapper.updateByPrimaryKeySelective(orders);
		}
	}

	@Override
	public void deleteOrders(Integer id) {
		ordersMapper.deleteByPrimaryKey(id);
	}
	public void pass(Integer id, Integer pass) {
		Orders order = ordersMapper.selectByPrimaryKey(id);
		if (MyCommon.COMMON_PASS.equals(pass)) {
			order.setStatus(1);
			Room room = roomMapper.selectByPrimaryKey(order.getRoomid());
			room.setOldid(order.getOldid());
			room.setStatus(1);
			roomMapper.updateByPrimaryKey(room);
		} else if (MyCommon.COMMON_NOPASS.equals(pass)) {
			order.setStatus(2);
		}
		ordersMapper.updateByPrimaryKey(order);
	}
	//得到工资
	@Override
	public HashMap<String,Integer> getWape() {
		OrdersExample ordersExample = new OrdersExample();
		ordersExample.createCriteria().andStatusEqualTo(1);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
		List<Orders> ordersList = ordersMapper.selectByExample(ordersExample);
		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		for (Orders orders : ordersList) {
			Date createtime = orders.getCreatetime();
			Integer price = Integer.valueOf(orders.getPrice().toString());
			String date = simpleDateFormat.format(createtime);
			if (hashMap.containsKey(date)) {
				price = hashMap.get(date) + price;
			}
			hashMap.put(date, price);
		}
		return hashMap;
	}
	
	//得到所有用户信息,因为只有Order表里不用分页,所有写在这里
	@Override
	public List<User> getUserListExcept(Integer uid){
		UserExample userExample = new UserExample();
		userExample.createCriteria();
		List<User> userList = userMapper.selectByExample(userExample);
		if (uid != null) {
			for (User user : userList) {
				if (uid.equals(user.getId())) {
					userList.remove(userList.indexOf(user));
					break;
				}
			}
		}
		return userList;
	}
	
	public List<Room> getRestRoomList(){
		RoomExample roomExample = new RoomExample();
		roomExample.createCriteria().andStatusEqualTo(0);
		List<Room> roomList = roomMapper.selectByExample(roomExample);
		return roomList;
	}
	
}
