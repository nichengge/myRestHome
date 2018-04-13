package org.westos.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.westos.entity.Oldman;
import org.westos.entity.Orders;
import org.westos.entity.Room;
import org.westos.entity.User;
import org.westos.page.Page;
import org.westos.service.impl.ParamedicServiceImpl;
import org.westos.service.impl.RoomServiceImpl;

@Controller
public class ParamedicController {
	@Autowired
	private ParamedicServiceImpl paramedicServiceImpl;
	@Autowired
	private RoomServiceImpl roomServiceImpl;

	@RequestMapping(value = "/myMessage")
	public String myMessage(Model model, @Param(value = "userId") Integer userId) {
		User user = paramedicServiceImpl.getMyMessage(userId);
		model.addAttribute("user", user);
		System.out.println("user:" + user);
		return "userjsp/user/message";
	}

	@RequestMapping(value = "/updateMyMessage")
	public String updateMyMessage(Model model, @Param(value = "User") User user) {
		paramedicServiceImpl.updateMessage(user);
		model.addAttribute("msg", "修改成功");
		return "msg2";
	}

	@RequestMapping(value = "/restOfRoom")
	public String restOfRoom(Model model, @Param(value = "currentPage") String currentPage, @Param("Room") Room room) {
		Page<Room> roomPage = paramedicServiceImpl.getRestOfRoom(room, currentPage);
		model.addAttribute("roomPage", roomPage);
		model.addAttribute("room", room);
		return "userjsp/room/list";
	}

	@RequestMapping(value = "/openedQuery")
	public String openedQuery(Model model, @Param("Room") Room room, HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Oldman> oldmanList = paramedicServiceImpl.getMyOldman(user);
		room = roomServiceImpl.queryById(room);
		model.addAttribute("room", room);
		model.addAttribute("oldmanList", oldmanList);
		return "userjsp/order/add";
	}

	@RequestMapping(value = "/amount")
	@ResponseBody
	public String amount(Integer roomid, Integer duration) {
		BigDecimal price = paramedicServiceImpl.amount(roomid, duration);
		return price.toString();
	}

	@RequestMapping(value = "/opened")
	public String opened(Model model, @Param("Orders") Orders orders) {
		String msg = paramedicServiceImpl.opened(orders);
		model.addAttribute("msg", msg);
		return "msg2";
	}

	@RequestMapping(value = "/myOrder")
	public String myOrder(Model model, HttpSession session, @Param("currentPage") String currentPage) {
		User user = (User) session.getAttribute("user");
		Integer id = user.getId();
		Orders orders = new Orders();
		orders.setUid(id);
		Page<Orders> orderPage = paramedicServiceImpl.getMyOrders(currentPage, orders);
		model.addAttribute("orderPage", orderPage);
		return "userjsp/order/list";
	}
}
