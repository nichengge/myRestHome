package com.wuhongyu.service;

import com.wuhongyu.entity.Orders;

import java.util.List;



public interface OrdersService {
	public List<Orders> selectAll();

	public List<Orders> selectAll(Integer uid);

	public void insertOrders(Orders orders);

	public Orders queryById(Integer id);

	void updateOrders(Orders orders);

	void deleteById(Integer id);

	void deleteByIds(Integer[] ids);

	void handle(Orders orders);

}
