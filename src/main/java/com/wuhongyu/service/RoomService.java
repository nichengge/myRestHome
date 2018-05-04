package com.wuhongyu.service;

import java.util.List;

import com.wuhongyu.entity.Oldman;
import com.wuhongyu.entity.Room;

public interface RoomService {

	public List<Room> selectAll(Room room);

	public void insertRoom(Room room);

	public void deleteById(Integer id);

	public void deleteByIds(Integer[] ids);

	public Room queryById(Integer id);

	public void updateRoom(Room room);

	public List<Room> selectFreeRoom();

}
