package com.wuhongyu.service;

import java.util.List;

import com.wuhongyu.entity.Oldman;
import com.wuhongyu.entity.User;



public interface OldmanService {
	public List<Oldman> selectAll(Oldman oldman);

	public void addOldman(Oldman oldman);

	public void deleteById(Integer id);

	public void deleteByIds(Integer[] ids);

	public Oldman queryById(Integer id);

	public void updateOldman(Oldman oldman);

	public List<Oldman> selectFreeOldman(Integer uid);
}
