package com.wuhongyu.service;

import com.wuhongyu.entity.Contacts;

import java.util.List;

public interface ContactsService {

    public List<Contacts> selectByOldid(Integer oldid);

    public void insert(Contacts contacts);

    public void update(Contacts contacts);

    public void deleteById(Integer integer);

    public Contacts selectById(Integer id);

    public void deletBach(Integer[] ids);
}
