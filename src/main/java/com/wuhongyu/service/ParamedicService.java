package com.wuhongyu.service;

import java.math.BigDecimal;
import java.util.List;

import com.wuhongyu.entity.Room;
import com.wuhongyu.entity.User;

public interface ParamedicService {

	public List<Room> restRoom(Room room);

	public BigDecimal amount(Integer roomid, Integer duration);
}
