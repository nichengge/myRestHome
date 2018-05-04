package com.wuhongyu.service.impl;

import com.wuhongyu.entity.Contacts;
import com.wuhongyu.entity.ContactsExample;
import com.wuhongyu.mapper.ContactsMapper;
import com.wuhongyu.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("contactsService")
public class ContactsServiceImpl implements ContactsService {

    @Autowired
    private ContactsMapper contactsMapper;
    @Override
    public List<Contacts> selectByOldid(Integer oldid) {
        ContactsExample example = new ContactsExample();
        example.createCriteria().andOldidEqualTo(oldid);
        List<Contacts> contactsList = contactsMapper.selectByExample(example);
        return contactsList;
    }

    @Override
    public void insert(Contacts contacts) {
        contactsMapper.insertSelective(contacts);
    }

    @Override
    public void update(Contacts contacts) {
        contactsMapper.updateByPrimaryKeySelective(contacts);
    }

    @Override
    public void deleteById(Integer integer) {
        contactsMapper.deleteByPrimaryKey(integer);
    }

    @Override
    public Contacts selectById(Integer id) {
        return contactsMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deletBach(Integer[] ids) {
        for(Integer id: ids){
            this.deleteById(id);
        }
    }
}