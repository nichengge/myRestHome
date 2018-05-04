package com.wuhongyu.controller;

import com.github.pagehelper.PageHelper;
import com.wuhongyu.common.MyCommon;
import com.wuhongyu.entity.MyPage;
import com.wuhongyu.entity.User;
import com.wuhongyu.service.UserService;
import com.wuhongyu.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/list")
	public String list(Model model, Integer pageNum, User user,HttpServletRequest request) {
		PageHelper.startPage(MyUtil.getCurrentPage(pageNum), MyCommon.PAGESIZE);
		List<User> userList = userService.selectAll(user);
		MyPage<User> page = MyUtil.getPage(userList, request);
		model.addAttribute("userList", userList);
		model.addAttribute("page", page);
		return "adminjsp/user/list";
	}

	@RequestMapping("/queryBeforeUpdateOrInsert")
	public String queryBeforeUpdateOrInsert(Model model, Integer id){
		if(id!=null && id!=0){
			User user = userService.queryById(id);
			model.addAttribute("user",user);
		}
		return "adminjsp/user/insertOrUpdate";
	}

	@RequestMapping("/insertOrUpdate")
	public String insertOrUpdate(Model model, User user){
		if(user.getId()!=null) {
			userService.updateUser(user);
			model.addAttribute("msg", "修改成功");
		}else {
			userService.addUser(user);
			model.addAttribute("msg","添加成功");
		}
		return "msg";
	}

	@RequestMapping("/delete")
	public String delete(Model model, Integer id){
		userService.deleteById(id);
		model.addAttribute("msg","删除成功");
		return "msg";
	}

	@RequestMapping("/deleteBath")
	public String deleteBatch(Model model, Integer[] checkId){
		userService.deleteByIds(checkId);
		model.addAttribute("msg","删除成功");
		return "msg";
	}

}
