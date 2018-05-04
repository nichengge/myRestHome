package com.wuhongyu.service.impl;

import com.wuhongyu.entity.Malfunction;
import com.wuhongyu.mapper.MalfunctionMapper;
import com.wuhongyu.mapper.OldmanMapper;
import com.wuhongyu.service.MalfunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("malfunctionService")
public class MalfunctionServiceImpl implements MalfunctionService {

    @Autowired
    private MalfunctionMapper malfunctionMapper;
    @Autowired
    private OldmanMapper oldmanMapper;


    @Override
    public List<Malfunction> selectAll(Integer oldid) {
        return malfunctionMapper.selectAll(oldid);
    }

    @Override
    public void insert(Malfunction malfunction) {
        malfunctionMapper.insertSelective(malfunction);
    }

    @Override
    public void update(Malfunction malfunction) {
        malfunctionMapper.updateByPrimaryKeySelective(malfunction);
    }

    @Override
    public void delete(Integer id) {
        malfunctionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteBath(Integer[] ids) {
        for(Integer id : ids){
            this.delete(id);
        }
    }

    @Override
    public Malfunction queryById(Integer id) {
        Malfunction malfunction = malfunctionMapper.selectByPrimaryKey(id);
        malfunction.setOldmanname(oldmanMapper.selectByPrimaryKey(malfunction.getOldid()).getName());
        return malfunction;
    }
}