package org.westos.controller;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.westos.entity.Oldman;
import org.westos.entity.Orders;
import org.westos.entity.Room;
import org.westos.entity.User;
import org.westos.page.Page;
import org.westos.service.impl.OrdersServiceImpl;
import org.westos.service.impl.RoomServiceImpl;

@Controller
public class OrdersController {

	@Autowired
	private OrdersServiceImpl ordersServiceImpl;
	@Autowired
	private RoomServiceImpl roomServiceImpl;
	

	@RequestMapping(value = "/orderList")
	public String orderList(Model model, @Param(value = "currentPage") String currentPage) {
		Page<Orders> orderPage = ordersServiceImpl.getPage(currentPage, null);
		model.addAttribute("orderPage", orderPage);
		return "adminjsp/order/list";
	}

	@RequestMapping(value = "passOrder")
	public String passOrder(Model model, @Param(value = "currentPage") String currentPage,
			@Param(value = "pass") Integer pass, @Param(value = "id") Integer id) {
		System.out.println("pass:" + pass);
		ordersServiceImpl.pass(id, pass);
		return orderList(model, currentPage);
	}

	@RequestMapping(value = "/wageStatistics")
	public String wageStatistics(Model model) {
		HashMap<String, Integer> map = ordersServiceImpl.getWape();
		model.addAttribute("map", map);
		return "adminjsp/wage/list";
	}

	@RequestMapping(value = "/deleteOrder")
	public String deleteOrder(Model model, @Param("currentPage") String currentPage, @Param("id") Integer id) {
		ordersServiceImpl.deleteOrders(id);
		return orderList(model, currentPage);
	}
	
	@RequestMapping(value="/queryUpdateOrder")
	public String queryUpdateOrder(Model model, @Param("currentPage") String currentPage, @Param("id") Integer id) {
		//得到该订单,里面包含userName等信息
		Orders orders = ordersServiceImpl.queryById(id);
		List<User> userList = ordersServiceImpl.getUserListExcept(orders.getUid());
		List<Oldman> oldmanList = roomServiceImpl.getOldmanExcept(orders.getOldid());
		List<Room> roomList = ordersServiceImpl.getRestRoomList();
		model.addAttribute("roomList", roomList);
		model.addAttribute("oldmanList", oldmanList);
		model.addAttribute("userList", userList);
		model.addAttribute("orders", orders);
		model.addAttribute("currentPage", currentPage);
		return "adminjsp/order/update";
	}
	
	@RequestMapping(value="/updateOrders")
	public String updateOrders(Model model, @Param("currentPage") String currentPage,@Param("Orders") Orders orders) {
		ordersServiceImpl.updateOrders(orders);
		return orderList(model, currentPage);
	}
}
