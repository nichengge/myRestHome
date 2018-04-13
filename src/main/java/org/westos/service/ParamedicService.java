package org.westos.service;

import org.westos.entity.Room;
import org.westos.entity.User;
import org.westos.page.Page;

public interface ParamedicService {
	public User getMyMessage(Integer id);

	public Page<Room> getRestOfRoom(Room room, String currentPage);

	public void updateMessage(User user);

}
