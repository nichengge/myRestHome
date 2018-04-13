package org.westos.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.westos.entity.User;
import org.westos.page.Page;
import org.westos.service.impl.UserServiceImpl;

@Controller
public class UserController {
	@Autowired
	private UserServiceImpl userServiceImpl;

	@RequestMapping(value = "/userList")
	public String userList(Model model, @Param("currentPage") String currentPage, @Param("User") User user) {
		Page<User> userPage = userServiceImpl.getPage(currentPage, user);
		model.addAttribute("userPage", userPage);
		model.addAttribute("user", user);
		return "adminjsp/user/list";
	}

	@RequestMapping(value = "/deleteUser")
	public String deleteUser(Model model, @Param("currentPage") String currentPage, @Param("User") User user) {
		userServiceImpl.deleteById(user);
		return userList(model, currentPage, user);
	}

	@RequestMapping(value = "/deleteUserBach")
	public String deleteUserBach(Model model, @RequestParam("checkId") Integer[] checkId, @Param("User") User user,
			@Param("currentPage") String currentPage) {
		userServiceImpl.deleteByIds(checkId);
		return userList(model, currentPage, user);
	}

	@RequestMapping(value="/addUserUrl")
	public String addUserUrl() {
		return "adminjsp/user/add";
	}
	
	@RequestMapping(value = "/addUser")
	public String addUser(Model model, @Param("User") User user) {
		String msg = userServiceImpl.addUser(user);
		model.addAttribute("msg", msg);
		return "msg2";
	}

	@RequestMapping(value = "/queryUpdate")
	public String queryUpdate(Model model, @Param("currentPage") String currentPage, @Param("User") User user) {
		User userQuery = userServiceImpl.queryById(user);
		model.addAttribute("userQuery", userQuery);
		model.addAttribute("user", user);
		model.addAttribute("currentPage", currentPage);
		return "adminjsp/user/update";
	}

	@RequestMapping(value = "/updateUser")
	public String updateUser(Model model, @Param("currentPage") String currentPage, @Param("likeName") String likeName,
			@Param("User") User user) {
		userServiceImpl.updateUser(user);
		User likeUser = new User();
		likeUser.setUsername(likeName);
		return userList(model, currentPage, likeUser);
	}
}