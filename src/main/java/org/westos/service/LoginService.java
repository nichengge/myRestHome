package org.westos.service;


import org.westos.exception.LoginExpection;

public interface LoginService {
	
	public boolean userNameIsRepeat(String username,String type);
	
	public void OrdersExpiredVerification();
	
	public void register(String username,String password,String type) throws LoginExpection;
	
	public Object login(String username,String password,String type) throws Exception;
	
}
