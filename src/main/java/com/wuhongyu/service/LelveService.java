package com.wuhongyu.service;

import com.wuhongyu.entity.Lelve;

import java.util.List;

public interface LelveService {

    public List<Lelve> selectAll(Lelve lelve);

    public void insert(Lelve lelve);

    public void update(Lelve lelve);

    public void delete(Integer id);

    public void deleteBath(Integer[] ids);

    public Lelve queryById(Integer id);

    public Lelve queryByOldid(Integer oldid);
}
