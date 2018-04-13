package org.westos.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.westos.exception.LoginExpection;
import org.westos.service.impl.LoginServiceImpl;

@Controller
public class LoginController {
	@Autowired
	private LoginServiceImpl loginServiceImpl;

	// 用户登录认证的功能
	@RequestMapping(value = "/userLogin")
	public String userLogin(@Param("username") String username, @Param("password") String password,
			@Param("type") String type,  HttpSession session) throws Exception {
		// 在登录之前判断一下订单是否过期
		loginServiceImpl.OrdersExpiredVerification();
		// 登录认证功能
		Object login = loginServiceImpl.login(username, password, type);
		if ("管理员".equals(type)) {
			session.setAttribute("admin", login);
			return "redirect:/adminjsp";	
		}else if("护理人员".equals(type)) {
			session.setAttribute("user", login);
			return "redirect:/userjsp";
		}
		return "redirect:/login";
	}

	
	// 退出功能
	@RequestMapping(value = "/adminExit")
	public String adminExit(HttpSession session) {
		session.invalidate();
		return "redirect:/exit";
	}

	// 注册功能
	// 前端没有实现
	@RequestMapping(value = "/regist")
	@ResponseBody
	public String regist(@Param("username") String username, @Param("password") String password,
			@Param("type") String type) throws LoginExpection {
		loginServiceImpl.register(username, password, type);
		return "1234";
	}
	
}
