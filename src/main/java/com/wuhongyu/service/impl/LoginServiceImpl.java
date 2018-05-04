package com.wuhongyu.service.impl;

import com.wuhongyu.entity.*;
import com.wuhongyu.mapper.*;
import com.wuhongyu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private LeavesMapper leavesMapper;


    // 订单过期验证
    @Override
    public void OrdersExpiredVerification() {
        OrdersExample ordersExample = new OrdersExample();
        ordersExample.createCriteria();
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        List<Orders> ordersList = ordersMapper.selectByExample(ordersExample);
        for (Orders orders : ordersList) {
            Date createtime = orders.getCreatetime();
            Integer duration = orders.getDuration();
            c.setTime(createtime);
            c.add(Calendar.MONTH, duration);
            c2.setTime(date);
            if (c2.after(c)) {
                Integer roomid = orders.getRoomid();
                Room room = new Room();
                room.setId(roomid);
                room.setStatus(0);
                room.setOldid(0);
                roomMapper.updateByPrimaryKeySelective(room);
            }
        }
    }

    @Override
    public boolean login(String username, String password, String type) {
        if("管理员".equals(type)){
            AdminExample example = new AdminExample();
            example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
            List<Admin> adminList = adminMapper.selectByExample(example);
            if(adminList.size() == 1){
                return true;
            }
        }else if("护理人员".equals(type)) {
            UserExample example = new UserExample();
            example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
            List<User> userList = userMapper.selectByExample(example);
            if(userList.size() == 1){
                return true;
            }

         }
        return false;
    }

    @Override
    public Admin seletcAdmin(String username, String password) {
        AdminExample example = new AdminExample();
        example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<Admin> adminList = adminMapper.selectByExample(example);
        return adminList.get(0);
    }

    @Override
    public User seletcUser(String username, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<User> userList = userMapper.selectByExample(example);
        return userList.get(0);
    }

    @Override
    public void deleteBeforeLeave() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String format = sdf.format(date);
        leavesMapper.deleteBefore(format);
    }
}