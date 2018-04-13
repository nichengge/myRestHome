package org.westos.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.westos.entity.Oldman;
import org.westos.entity.User;
import org.westos.page.Page;
import org.westos.service.impl.OldmanServiceImpl;
import org.westos.util.MyUtil;

@Controller
public class OldmanController {
	@Autowired
	private OldmanServiceImpl oldmanServiceImpl;

	@RequestMapping(value = "/oldmanList")
	public String oldmanList(Model model, @Param("currentPage") String currentPage, @Param("Oldman") Oldman oldman) {
		Page<Oldman> oldmanPage = oldmanServiceImpl.getPage(currentPage, oldman);
		model.addAttribute("oldmanPage", oldmanPage);
		model.addAttribute("oldman", oldman);
		if (oldman.getUserId() != null && oldman.getUserId() != 0) {
			return "userjsp/oldman/list";
		}
		return "adminjsp/oldman/list";
	}

	/**
	 * 查询将要修改的老人的信息
	 */
	@RequestMapping(value = "/queryUpdateOldman")
	public String queryUpdateOldman(Model model, @Param("currentPage") String currentPage,
			@Param("Oldman") Oldman oldman) {
		Oldman oldmanQuery = oldmanServiceImpl.queryById(oldman);
		List<User> userList = oldmanServiceImpl.getUsersExcept(oldmanQuery.getUserId());
		model.addAttribute("userList", userList);
		model.addAttribute("oldmanQuery", oldmanQuery);
		model.addAttribute("oldman", oldman);
		model.addAttribute("currentPage", currentPage);
		if (oldman.getUserId() != null && oldman.getUserId() != 0) {
			return "userjsp/oldman/update";
		}
		return "adminjsp/oldman/update";
	}

	/**
	 * 修改老人的信息
	 */
	@RequestMapping(value = "/updateOldman")
	public String updateOldman(Model model, @Param("currentPage") String currentPage,
			@Param("likeName") String likeName, @RequestParam(value = "oldpic", required = false) MultipartFile oldpic,
			@Param("Oldman") Oldman oldman) {
		String oldpicName = oldmanServiceImpl.queryById(oldman).getPic();
		// 使用自定义的工具修改pic的真正内容
		String updatePic = MyUtil.updatePic(oldpic, oldpicName);
		oldman.setPic(updatePic);
		oldmanServiceImpl.updateOldman(oldman);
		Oldman likeOldman = new Oldman();
		likeOldman.setName(likeName);
		// 这里加上护理人员的id 使oldmanList能够查到该护理人员下的老人
		likeOldman.setUserId(oldman.getUserId());
		return oldmanList(model, currentPage, likeOldman);
	}

	/**
	 * 查询所有的护理人员 传到add界面提供选择,这里加个Oldman参数再判断一下,在前端的jsp页面里将护理人员隐藏就可以了
	 */
	@RequestMapping("/queryAddOldman")
	public String queryAddOldman(Model model, @Param(value = "Oldman") Oldman oldman) {
		// 在最前面判断,因为前台页面无需查找所有护理人员
		if (oldman.getUserId() != null && oldman.getUserId() != 0) {
			model.addAttribute("oldman", oldman);
			return "userjsp/oldman/add";
		}
		List<User> userList = oldmanServiceImpl.getUsersExcept(0);
		model.addAttribute("userList", userList);
		return "adminjsp/oldman/add";
	}

	/**
	 * 添加老人的信息
	 */
	@RequestMapping("/addOldman")
	public String addOldman(Model model, @RequestParam(value = "oldpic") MultipartFile oldpic,
			@Param("Oldman") Oldman oldman) {
		// 使用自定义的工具添加图片
		// 这里不用判断null的问题了 工具里面已经判断
		String addNewPic = MyUtil.addNewPic(oldpic);
		oldman.setPic(addNewPic);
		String msg = oldmanServiceImpl.addOldman(oldman);
		model.addAttribute("msg", msg);
		if (oldman.getUsername() == null) {
			return "userjsp/oldman/msg";
		}
		return "adminjsp/oldman/msg";
	}

	/**
	 * 删除单个老人的信息
	 */
	@RequestMapping("/deleteOldman")
	public String deleteOldman(Model model, @Param("currentPage") String currentPage, @Param("Oldman") Oldman oldman) {
		String oldpicName = oldmanServiceImpl.queryById(oldman).getPic();
		MyUtil.deleteNullPic(oldpicName);
		oldmanServiceImpl.deleteById(oldman);
		return oldmanList(model, currentPage, oldman);
	}

	/**
	 * 批量删除老人的信息
	 */
	@RequestMapping("/deleteOldmanBach")
	public String deleteOldmanBach(Model model, @RequestParam("checkId") Integer[] checkId,
			@Param("Oldman") Oldman oldman, @Param("currentPage") String currentPage) {
		// 批量删除的时候就不去实现删除本地图片的逻辑了
		// 一般人也不会批量删除老人的信息吧
		// 如果想添加这个逻辑 请自行填写
		oldmanServiceImpl.deleteByIds(checkId);
		return oldmanList(model, currentPage, oldman);
	}

}
