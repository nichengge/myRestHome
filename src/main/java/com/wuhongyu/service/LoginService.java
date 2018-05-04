package com.wuhongyu.service;


import com.wuhongyu.entity.Admin;
import com.wuhongyu.entity.User;

public interface LoginService {
	
	public void OrdersExpiredVerification();
	
	public boolean login(String username, String password, String type);

	public Admin seletcAdmin(String username, String password);

	public User seletcUser(String username, String password);

	public void deleteBeforeLeave();


}
