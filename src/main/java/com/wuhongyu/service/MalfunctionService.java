package com.wuhongyu.service;

import com.wuhongyu.entity.Malfunction;

import java.util.List;

public interface MalfunctionService {

    public List<Malfunction> selectAll(Integer oldid);

    public void insert(Malfunction malfunction);

    public void update(Malfunction malfunction);

    public void delete(Integer id);

    public void deleteBath(Integer[] ids);

    public Malfunction queryById(Integer id);
}
