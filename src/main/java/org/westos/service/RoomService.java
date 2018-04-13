package org.westos.service;

import java.util.List;

import org.westos.entity.Oldman;
import org.westos.entity.Room;
import org.westos.page.Page;

public interface RoomService {

	public Page<Room> getPage(String currentPage, Room room);

	public String addRoom(Room room);

	public void deleteById(Room room);

	public void deleteByIds(Integer[] ids);

	public Room queryById(Room room);

	public void updateRoom(Room room);

	public List<Oldman> getOldmanExcept(Integer oldid);

}
