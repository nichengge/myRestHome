package com.wuhongyu.controller;

import com.github.pagehelper.PageHelper;
import com.wuhongyu.common.MyCommon;
import com.wuhongyu.entity.MyPage;
import com.wuhongyu.entity.Oldman;
import com.wuhongyu.entity.Room;
import com.wuhongyu.service.OldmanService;
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
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private OldmanService oldmanService;

    @RequestMapping("/list")
    public String list(Model model, Integer pageNum, Room room, HttpServletRequest request){
        PageHelper.startPage(MyUtil.getCurrentPage(pageNum),MyCommon.PAGESIZE);
        List<Room> roomList = roomService.selectAll(room);
        MyPage<Room> page = MyUtil.getPage(roomList, request);
        model.addAttribute("roomList",roomList);
        model.addAttribute("page",page);
        return "adminjsp/room/list";
    }

    @RequestMapping("/queryBeforeUpdateOrInsert")
    public String queryBeforeUpdateOrInsert(Model model, Integer id){
        if(id !=null){
            Room room = roomService.queryById(id);
            model.addAttribute("room",room);
        }
        List<Oldman> oldmanList = oldmanService.selectFreeOldman(null);
        model.addAttribute("oldmanList",oldmanList);
        return "adminjsp/room/insertOrUpdate";
    }

    @RequestMapping("/insertOrUpdate")
    public String insertOrUpdate(Model model, MultipartFile roomPic, Room room){
        if(room.getId()!=null){//是修改操作
            if(roomPic!=null && roomPic.getSize()!=0){
                MyUtil.deleteNullPic(room.getPic());
                String newPic = MyUtil.addNewPic(roomPic);
                room.setPic(newPic);
            }
            roomService.updateRoom(room);
            model.addAttribute("msg","修改成功");
        }else {//是添加操作
            if(roomPic!=null && roomPic.getSize()!=0){
                String newPic = MyUtil.addNewPic(roomPic);
                room.setPic(newPic);
            }
            roomService.insertRoom(room);
            model.addAttribute("msg","添加成功");
        }
        return "msg";
    }

    @RequestMapping("/delete")
    public String delete(Model model, Integer id){
        roomService.deleteById(id);
        model.addAttribute("msg","删除成功");
        return "msg";
    }

    @RequestMapping("/deleteBath")
    public String deleteBath(Model model, Integer[] checkId){
        roomService.deleteByIds(checkId);
        model.addAttribute("msg","删除成功");
        return "msg";
    }
}