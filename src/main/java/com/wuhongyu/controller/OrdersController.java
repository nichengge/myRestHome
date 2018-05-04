package com.wuhongyu.controller;


import com.github.pagehelper.PageHelper;
import com.wuhongyu.common.MyCommon;
import com.wuhongyu.entity.*;
import com.wuhongyu.service.OldmanService;
import com.wuhongyu.service.OrdersService;
import com.wuhongyu.service.RoomService;
import com.wuhongyu.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private OldmanService oldmanService;

    @RequestMapping("/list")
    public String list(Model model, Integer pageNum, HttpServletRequest request){
        PageHelper.startPage(MyUtil.getCurrentPage(pageNum),MyCommon.PAGESIZE);
        List<Orders> ordersList = ordersService.selectAll();
        MyPage<Orders> page = MyUtil.getPage(ordersList, request);
        model.addAttribute("ordersList",ordersList);
        model.addAttribute("page",page);
        return "adminjsp/order/list";
    }

    @RequestMapping("/queryBeforeUpdateOrInsert")
    public String queryBeforeUpdateOrInsert(Model model,Integer id){
        if(id != null){
            Orders orders = ordersService.queryById(id);
            model.addAttribute("orders",orders);
        }
        List<Room> roomList = roomService.selectFreeRoom();
        List<Oldman> oldmanList = oldmanService.selectFreeOldman(ordersService.queryById(id).getUid());
        model.addAttribute("roomList",roomList);
        model.addAttribute("oldmanList",oldmanList);
        return "adminjsp/order/insertOrUpdate";
    }

    @RequestMapping("/insertOrUpdate")
    public String insertOrUpdate(Model model, Orders orders){
        if(orders.getId()!=null){//是修改
            ordersService.updateOrders(orders);
            model.addAttribute("msg","修改成功");
        }else {
            ordersService.insertOrders(orders);
            model.addAttribute("msg","申请成功,请等待管理员审核");
        }
        return "msg";
    }

    @RequestMapping("/delete")
    public String delete(Model model, Integer id){
        ordersService.deleteById(id);
        model.addAttribute("msg","删除成功");
        return "msg";
    }

    @RequestMapping("/deleteBath")
    public String deleteBath(Model model, Integer[] checkId){
        ordersService.deleteByIds(checkId);
        model.addAttribute("msg","删除成功");
        return "msg";
    }

    @RequestMapping("handle")
    public String handle(Model model,Orders orders){
        ordersService.handle(orders);
        if(orders.getStatus() == 1){
            model.addAttribute("msg","订单已通过审核");
        }else {
            model.addAttribute("msg","订单未通过审核");
        }
        return "msg";
    }
    
}