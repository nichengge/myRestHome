package com.wuhongyu.controller;

import com.github.pagehelper.PageHelper;
import com.wuhongyu.common.MyCommon;
import com.wuhongyu.entity.*;
import com.wuhongyu.service.*;
import com.wuhongyu.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/paramedic")
public class ParamedicController {

    @Autowired
    private ParamedicService paramedicService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private OldmanService oldmanService;
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private LeaveService leaveService;

    @RequestMapping("/myMessage")
    public String myMessage(Model model, HttpSession session){
        User user = (User) session.getAttribute("user");
        User user1 = userService.queryById(user.getId());
        model.addAttribute("user",user1);
        return "userjsp/user/message";
    }

    @RequestMapping("/update")
    public String update(Model model, User user){
        userService.updateUser(user);
        model.addAttribute("msg","修改成功");
        return "msg";
    }

    @RequestMapping("/oldman/list")
    public String oldmanList(Model model ,HttpSession session, Integer pageNum, HttpServletRequest request,Oldman oldman){
        User user = (User) session.getAttribute("user");
        oldman.setUid(user.getId());
        PageHelper.startPage(MyUtil.getCurrentPage(pageNum),MyCommon.PAGESIZE);
        List<Oldman> oldmanList = oldmanService.selectAll(oldman);
        MyPage<Oldman> page = MyUtil.getPage(oldmanList, request);
        model.addAttribute("oldmanList",oldmanList);
        model.addAttribute("page",page);
        return "userjsp/oldman/list";
    }

    @RequestMapping("/restRoom")
    public String restRoom(Model model, Room room, Integer pageNum, HttpServletRequest request){
        PageHelper.startPage(MyUtil.getCurrentPage(pageNum),MyCommon.PAGESIZE);
        List<Room> roomList = paramedicService.restRoom(room);
        MyPage<Room> page = MyUtil.getPage(roomList, request);
        model.addAttribute("roomList",roomList);
        model.addAttribute("page",page);
        return "userjsp/room/list";
    }


    @RequestMapping("/register")
    public String register(Model model, Integer roomid,HttpSession session){
        User user = (User) session.getAttribute("user");
        List<Oldman> oldmanList = oldmanService.selectFreeOldman(user.getId());
        Room room = roomService.queryById(roomid);
        model.addAttribute("room",room);
        model.addAttribute("oldmanList",oldmanList);
        return "userjsp/order/insert";
    }

    @RequestMapping("/amount")
    @ResponseBody
    public String amount(Integer roomid, Integer duration){
        BigDecimal amount = paramedicService.amount(roomid, duration);
        return amount.toString();
    }


    @RequestMapping("/insertOrders")
    public String insertOrders(Model model , Orders orders){
        ordersService.insertOrders(orders);
        model.addAttribute("msg","订单申请成功,请等待管理员审核");
        return "msg";
    }

    @RequestMapping("/queryBeforeUpdateOrInsert")
    public String queryBeforeUpdateOrInsert(Model model,Integer id){
        if(id != null){
            Oldman oldman = oldmanService.queryById(id);
            model.addAttribute("oldman",oldman);
        }
        List<User> userList = userService.selectAll(new User());
        model.addAttribute("userList",userList);
        return "userjsp/oldman/insertOrUpdate";
    }

    @RequestMapping("/orders/list")
    public String ordersList(Model model, HttpServletRequest request, HttpSession session,Integer pageNum){
        User user = (User) session.getAttribute("user");
        PageHelper.startPage(MyUtil.getCurrentPage(pageNum),MyCommon.PAGESIZE);
        List<Orders> ordersList = ordersService.selectAll(user.getId());
        MyPage<Orders> page = MyUtil.getPage(ordersList, request);
        model.addAttribute("ordersList",ordersList);
        model.addAttribute("page",page);
        return "userjsp/order/list";
    }

    @RequestMapping("/leave/queryBeforeInsert")
    public String queryInsert(Model model ,HttpSession session){
        User user = (User) session.getAttribute("user");
        int count = leaveService.selectLeaveCount(user.getId());
        if(count==3){
            model.addAttribute("msg","您当月已经请假三次,不能再请假了");
            return "msg";
        }
        return "userjsp/leave/insertOrUpdate";
    }

    @RequestMapping("/leave/insert")
    public String insertLeave(Model model ,HttpSession session, Leaves leave){
        User user = (User) session.getAttribute("user");
        leave.setUid(user.getId());
        leaveService.insert(leave);
        model.addAttribute("msg","请假成功");
        return "msg";
    }

}