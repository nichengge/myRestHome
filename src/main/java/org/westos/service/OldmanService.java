package org.westos.service;

import java.util.List;

import org.westos.entity.Oldman;
import org.westos.entity.User;
import org.westos.page.Page;

public interface OldmanService {
	public Page<Oldman> getPage(String currentPage, Oldman oldman);

	public String addOldman(Oldman oldman);

	public void deleteById(Oldman oldman);

	public void deleteByIds(Integer[] ids);

	public Oldman queryById(Oldman oldman);

	public void updateOldman(Oldman oldman);

	public List<User> getUsersExcept(Integer userId);
}
