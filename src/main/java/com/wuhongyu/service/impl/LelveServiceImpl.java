package com.wuhongyu.service.impl;


import com.wuhongyu.entity.Lelve;
import com.wuhongyu.mapper.LelveMapper;
import com.wuhongyu.mapper.OldmanMapper;
import com.wuhongyu.service.LelveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("lelveService")
public class LelveServiceImpl implements LelveService {

    @Autowired
    private LelveMapper lelveMapper;
    @Autowired
    private OldmanMapper oldmanMapper;


    @Override
    public List<Lelve> selectAll(Lelve lelve) {
        return lelveMapper.selectAll(lelve);
    }

    @Override
    public void insert(Lelve lelve) {
        lelveMapper.insertSelective(lelve);
    }

    @Override
    public void update(Lelve lelve) {
        lelveMapper.updateByPrimaryKeySelective(lelve);
    }

    @Override
    public void delete(Integer id) {
        lelveMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteBath(Integer[] ids) {
        for(Integer id: ids){
            this.delete(id);
        }
    }

    @Override
    public Lelve queryById(Integer id) {
        Lelve lelve = lelveMapper.selectByPrimaryKey(id);
        lelve.setOldmanname(oldmanMapper.selectByPrimaryKey(lelve.getOldid()).getName());
        return lelve;
    }

    @Override
    public Lelve queryByOldid(Integer oldid) {
        Lelve lelve = lelveMapper.queryByOldid(oldid);
        return lelve;
    }
}