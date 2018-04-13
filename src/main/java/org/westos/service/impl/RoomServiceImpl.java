package org.westos.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.westos.common.MyCommon;
import org.westos.entity.Oldman;
import org.westos.entity.OldmanExample;
import org.westos.entity.Room;
import org.westos.mapper.OldmanMapper;
import org.westos.mapper.RoomMapper;
import org.westos.page.Page;
import org.westos.service.RoomService;

@Component
public class RoomServiceImpl implements RoomService {
	@Autowired
	private RoomMapper roomMapper;
	@Autowired
	private OldmanMapper oldmanMapper;

	private Integer count = MyCommon.COMMON_COUNT;

	@Override
	public Page<Room> getPage(String current, Room room) {
		int allLine = roomMapper.selectAllLine(room);
		Page<Room> page = new Page<Room>();
		page.setAllLine(allLine);
		page.setCount(this.count);
		Integer currentPage;
		try {
			currentPage = Integer.parseInt(current);
			if (currentPage == null || currentPage <= 0) {
				currentPage = 1;
			} else if (currentPage > page.getAllPage()) {
				currentPage = page.getAllPage();
			}
		} catch (NumberFormatException e) {
			currentPage = 1;
		}
		page.setCurrentPage(currentPage);
		Integer begin = (currentPage - 1) * count;
		System.out.println(begin);
		List<Room> list = roomMapper.selectUserByPage(begin, count, room);
		for (Room room2 : list) {
			if (room2.getOldid() != null && room2.getOldid() != 0) {
				room2.setOldmanName(oldmanMapper.selectByPrimaryKey(room2.getOldid()).getName());
			}
		}
		page.setList(list);
		return page;
	}

	@Override
	public String addRoom(Room room) {
		if (MyCommon.COMMON_NOPIC.equals(room.getPic())) {
			room.setPic("没有添加图片");
		}
		room.setStatus(0);
		roomMapper.insert(room);
		return "添加成功....";
	}

	@Override
	public void deleteById(Room room) {
		Integer id = room.getId();
		roomMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteByIds(Integer[] ids) {
		if (ids != null) {
			List<Integer> idList = Arrays.asList(ids);
			roomMapper.deleteByKeys(idList);
		}
	}

	@Override
	public Room queryById(Room room) {
		Room resultRoom = roomMapper.selectByPrimaryKey(room.getId());
		if (resultRoom.getOldid() != null && resultRoom.getOldid() != 0) {
			Oldman oldman = oldmanMapper.selectByPrimaryKey(resultRoom.getOldid());
			resultRoom.setOldmanName(oldman.getName());
		}
		return resultRoom;
	}

	@Override
	public void updateRoom(Room room) {
		// 如果没有输入房间的照片 就不改变这个照片
		if (MyCommon.COMMON_PIC.equals(room.getPic())) {
			Room selectRoom = roomMapper.selectByPrimaryKey(room.getId());
			room.setPic(selectRoom.getPic());
		}
		// 根据房间的老人信息是否变化 来修改 oldid 和 status
		if (MyCommon.COMMON_NOOLDMAN.equals(room.getOldmanName())) {
			room.setOldid(null);
			room.setStatus(0);
		} else {
			// 如果给该房间添加了入住老人就通过老人的姓名查询oldman
			OldmanExample oldmanExample = new OldmanExample();
			oldmanExample.createCriteria().andNameEqualTo(room.getOldmanName());
			List<Oldman> oldmanList = oldmanMapper.selectByExample(oldmanExample);
			// 如果该房间本来没有老人的话直接给oldid 和status赋值
			if (room.getOldid() == null) {
				room.setOldid(oldmanList.get(0).getId());
				room.setStatus(1);
			} else {
				// 如果原来房间有老人居住, 需要判断一下原来的老人和新的老人的名字是否相等,如果不相等就修改
				Oldman oldman = oldmanMapper.selectByPrimaryKey(room.getOldid());
				if (!oldman.getName().equals(room.getOldmanName())) {
					room.setOldid(oldmanList.get(0).getId());
				}
				room.setStatus(1);
			}
		}
		roomMapper.updateByPrimaryKey(room);
	}

	// 得到除了本房间以外的所有老人
	// 修复了一个bug,返回的老人list中去除掉已经有房间的老人
	// 事实证明单次查询没法得到我想要的结果0.0
	// 或者如果有人有更好的查询方法可以告诉我
	@Override
	public List<Oldman> getOldmanExcept(Integer oldid) {
		// OldmanExample oldmanExample = new OldmanExample();
		// oldmanExample.createCriteria();
		// List<Oldman> oldmanList = oldmanMapper.selectByExample(oldmanExample);
		//已经解决,使用子查询的方式,查找出所有没有房间的老人
		List<Oldman> oldmanList = oldmanMapper.selectNoRoomOldman(null);
		// 这里要加上一个非空判断
		if (oldid != null) {
			for (Oldman oldman : oldmanList) {
				if (oldid.equals(oldman.getId())) {
					oldmanList.remove(oldmanList.indexOf(oldman));
					break;
				}
			}
		}
		return oldmanList;
	}

}
