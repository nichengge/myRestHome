package com.wuhongyu.service.impl;

import com.wuhongyu.common.MyCommon;
import com.wuhongyu.entity.Leaves;
import com.wuhongyu.mapper.LeavesMapper;
import com.wuhongyu.mapper.UserMapper;
import com.wuhongyu.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("leaveService")
public class LeaveServiceImpl implements LeaveService {

    @Autowired
    private LeavesMapper leavesMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Leaves> selectAll(Integer uid) {
        return leavesMapper.selectAll(uid);
    }

    @Override
    public void insert(Leaves leave) {
        leave.setCreatedate(new Date());
        int count = this.selectLeaveCount(leave.getUid())+1;
        leave.setNumber(count);
        leave.setDeduct(MyCommon.DEDUCT.get(count));
        leavesMapper.insertSelective(leave);
    }

    @Override
    public void update(Leaves leave) {
        leavesMapper.updateByPrimaryKeySelective(leave);
    }

    @Override
    public void delete(Integer id) {
        leavesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteBath(Integer[] ids) {
        for(Integer id: ids){
            this.delete(id);
        }
    }

    @Override
    public Leaves queryById(Integer id) {
        Leaves leave = leavesMapper.selectByPrimaryKey(id);
        leave.setUsername(userMapper.selectByPrimaryKey(leave.getUid()).getName());
        return leave;
    }

    @Override
    public int selectLeaveCount(Integer uid) {
        return leavesMapper.selectLeaveCount(uid);
    }
}