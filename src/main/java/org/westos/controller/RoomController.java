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
import org.westos.entity.Room;
import org.westos.page.Page;
import org.westos.service.impl.RoomServiceImpl;
import org.westos.util.MyUtil;

@Controller
public class RoomController {
	@Autowired
	private RoomServiceImpl roomServiceImpl;

	@RequestMapping(value = "/roomList")
	public String roomList(Model model, @Param("currentPage") String currentPage, @Param("Room") Room room) {
		Page<Room> roomPage = roomServiceImpl.getPage(currentPage, room);
		model.addAttribute("roomPage", roomPage);
		model.addAttribute("room", room);
		return "adminjsp/room/list";
	}

	// 这里的修改房间住户的功能就先不实现了
	// 等到写订单管理的模块再完成
	@RequestMapping(value = "/queryUpdateRoom")
	public String queryUpdateRoom(Model model, @Param("currentPage") String currentPage, @Param("Room") Room room) {
		Room roomQuery = roomServiceImpl.queryById(room);
		List<Oldman> oldmanList = roomServiceImpl.getOldmanExcept(roomQuery.getOldid());
		model.addAttribute("roomQuery", roomQuery);
		model.addAttribute("room", room);
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("oldmanList", oldmanList);
		return "adminjsp/room/update";
	}

	// 修改房间的信息
	@RequestMapping(value = "/updateRoom")
	public String updateRoom(Model model, @Param("currentPage") String currentPage, @Param("likeName") String likeName,
			@RequestParam(value = "oldpic", required = false) MultipartFile oldpic, @Param("Room") Room room) {
		String oldpicName = roomServiceImpl.queryById(room).getPic();
		// 使用自定义的工具修改pic的真正内容
		String updatePic = MyUtil.updatePic(oldpic, oldpicName);
		room.setPic(updatePic);
		roomServiceImpl.updateRoom(room);
		Room likeRoom = new Room();
		likeRoom.setName(likeName);
		return roomList(model, currentPage, likeRoom);
	}

	// 添加房间信息之前把所有的除了已经入住的备选老人传进去
	@RequestMapping(value = "/queryAddRoom")
	public String queryAddRoom(Model model) {
		List<Oldman> oldmanList = roomServiceImpl.getOldmanExcept(0);
		model.addAttribute("oldmanList", oldmanList);
		return "adminjsp/room/add";
	}

	// 添加房间信息
	@RequestMapping(value = "/addRoom")
	public String addRoom(Model model, @RequestParam(value = "oldpic") MultipartFile oldpic, @Param("Room") Room room) {
		// 使用自定义的工具添加图片
		String addNewPic = MyUtil.addNewPic(oldpic);
		room.setPic(addNewPic);
		String msg = roomServiceImpl.addRoom(room);
		model.addAttribute("msg", msg);
		return "adminjsp/room/msg";
	}

	/**
	 * 删除单个房间的信息, 其实我真的不推荐使用删除功能 人家老人住的好好的 你把房子给删了.......
	 *
	 */
	@RequestMapping("/deleteRoom")
	public String deleteRoom(Model model, @Param("currentPage") String currentPage, @Param("Room") Room room) {
		String oldpicName = roomServiceImpl.queryById(room).getPic();
		MyUtil.deleteNullPic(oldpicName);
		roomServiceImpl.deleteById(room);
		return roomList(model, currentPage, room);
	}

	/**
	 * 批量删除房间的信息 .这个功能同样不推荐使用......
	 */
	@RequestMapping("/deleteRoomBach")
	public String deleteRoomBach(Model model, @RequestParam("checkId") Integer[] checkId, @Param("Room") Room room,
			@Param("currentPage") String currentPage) {
		roomServiceImpl.deleteByIds(checkId);
		return roomList(model, currentPage, room);
	}
}
