package com.wuhongyu.service.impl;

import com.wuhongyu.entity.Room;
import com.wuhongyu.entity.RoomExample;
import com.wuhongyu.mapper.RoomMapper;
import com.wuhongyu.service.ParamedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service("paramedicService")
public class ParamedicServiceImpl implements ParamedicService {

    @Autowired
    private RoomMapper roomMapper;

    @Override
    public List<Room> restRoom(Room room) {
        RoomExample example = new RoomExample();
        RoomExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(0);
        if(room.getName() !=null && !"".equals(room.getName())){
            criteria.andNameLike("%"+room.getName()+"%");
        }
        List<Room> roomList = roomMapper.selectByExample(example);
        return roomList;
    }

    @Override
    public BigDecimal amount(Integer roomid, Integer duration) {
        Room room = new Room();
        room.setId(roomid);
        room = roomMapper.selectByPrimaryKey(roomid);
        BigDecimal price = room.getPrice();
        BigDecimal duration2 = new BigDecimal(duration);
        price = price.multiply(duration2);
        return price;
    }
}