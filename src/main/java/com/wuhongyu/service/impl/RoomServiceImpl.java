package com.wuhongyu.service.impl;

import com.wuhongyu.entity.Oldman;
import com.wuhongyu.entity.Room;
import com.wuhongyu.entity.RoomExample;
import com.wuhongyu.mapper.OldmanMapper;
import com.wuhongyu.mapper.RoomMapper;
import com.wuhongyu.service.RoomService;
import com.wuhongyu.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roomService")
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private OldmanMapper oldmanMapper;

    @Override
    public List<Room> selectAll(Room room) {
        List<Room> roomList = roomMapper.selectAll(room);
        return roomList;
    }

    @Override
    public void insertRoom(Room room) {
        roomMapper.insertSelective(room);
    }

    @Override
    public void deleteById(Integer id) {
        Room room = roomMapper.selectByPrimaryKey(id);
        MyUtil.deleteNullPic(room.getPic());
        roomMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        for (Integer id: ids){
            this.deleteById(id);
        }
    }

    @Override
    public Room queryById(Integer id) {
        Room room = roomMapper.selectByPrimaryKey(id);
        if(room.getOldid()!=null){
            room.setOldmanname(oldmanMapper.selectByPrimaryKey(room.getOldid()).getName());
        }
        return room;
    }

    @Override
    public void updateRoom(Room room) {
        roomMapper.updateByPrimaryKeySelective(room);
    }

    @Override
    public List<Room> selectFreeRoom() {
        RoomExample example = new RoomExample();
        example.createCriteria().andStatusEqualTo(0);
        List<Room> roomList = roomMapper.selectByExample(example);
        return roomList;
    }


}