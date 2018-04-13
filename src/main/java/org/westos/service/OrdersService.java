package org.westos.service;

import java.util.HashMap;
import java.util.List;

import org.westos.entity.Orders;
import org.westos.entity.User;
import org.westos.page.Page;

public interface OrdersService {
	public Page<Orders> getPage(String currentPage, Orders orders);

	public String addOrders(Orders orders);

	public Orders queryById(Integer id);

	HashMap<String, Integer> getWape();

	void updateOrders(Orders orders);

	void deleteOrders(Integer id);

	List<User> getUserListExcept(Integer uid);

}
