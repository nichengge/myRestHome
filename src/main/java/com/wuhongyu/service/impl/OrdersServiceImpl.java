package com.wuhongyu.service.impl;

import com.wuhongyu.entity.Orders;
import com.wuhongyu.entity.Room;
import com.wuhongyu.mapper.OrdersMapper;
import com.wuhongyu.mapper.RoomMapper;
import com.wuhongyu.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public List<Orders> selectAll() {
        List<Orders> ordersList = ordersMapper.selectAll(null);
        return ordersList;
    }

    @Override
    public List<Orders> selectAll(Integer uid){
        List<Orders> ordersList = ordersMapper.selectAll(uid);
        return ordersList;
    }
    @Override
    public void insertOrders(Orders orders) {
        orders.setStatus(0);
        orders.setCreatetime(new Date());
        ordersMapper.insertSelective(orders);
    }

    @Override
    public Orders queryById(Integer id) {
        return ordersMapper.selectById(id);
    }

    @Override
    public void updateOrders(Orders orders) {
        ordersMapper.updateByPrimaryKeySelective(orders);
    }

    @Override
    public void deleteById(Integer id) {
        ordersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByIds(Integer[] ids) {
        for(Integer id: ids){
            this.deleteById(id);
        }
    }

    @Override
    public void handle(Orders orders) {
        Orders orders1 = ordersMapper.selectByPrimaryKey(orders.getId());
        Integer status = orders.getStatus();
        if(status==1){//等于一表示订单审核通过
            Room room = roomMapper.selectByPrimaryKey(orders1.getRoomid());
            room.setOldid(orders1.getOldid());
            room.setStatus(1);
            roomMapper.updateByPrimaryKeySelective(room);
        }
        ordersMapper.updateByPrimaryKeySelective(orders);
    }
}