package com.wuhongyu.service;

import com.wuhongyu.entity.Leaves;

import java.util.List;

public interface LeaveService {

    public List<Leaves> selectAll(Integer uid);

    public void insert(Leaves leave);

    public void update(Leaves leave);

    public void delete(Integer id);

    public void deleteBath(Integer[] ids);

    public Leaves queryById(Integer id);

    public int selectLeaveCount(Integer uid);
}
