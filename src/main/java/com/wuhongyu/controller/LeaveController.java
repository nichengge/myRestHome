package com.wuhongyu.controller;

import com.github.pagehelper.PageHelper;
import com.wuhongyu.common.MyCommon;
import com.wuhongyu.entity.Leaves;
import com.wuhongyu.entity.MyPage;
import com.wuhongyu.service.LeaveService;
import com.wuhongyu.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/leave")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @RequestMapping("/list")
    public String list(Model model, HttpServletRequest request, Integer pageNum,Integer uid){
        PageHelper.startPage(MyUtil.getCurrentPage(pageNum),MyCommon.PAGESIZE);
        List<Leaves> leaveList = leaveService.selectAll(uid);
        MyPage<Leaves> page = MyUtil.getPage(leaveList, request);
        model.addAttribute("leaveList",leaveList);
        model.addAttribute("page",page);
        return "adminjsp/leave/list";
    }

    @RequestMapping("/queryBeforeUpdateOrInsert")
    public String queryBeforeUpdateOrInsert(Model model, Integer id){
        if(id != null){
            Leaves leave = leaveService.queryById(id);
            model.addAttribute("leave",leave);
        }
        return "adminjsp/leave/insertOrUpdate";
    }

    @RequestMapping("/insertOrUpdate")
    public String insertOrUpdate(Model model, Leaves leave){
        if(leave.getId()!=null){
            leaveService.update(leave);
            model.addAttribute("msg","修改成功");
        }else {
            leaveService.insert(leave);
            model.addAttribute("msg","添加成功");
        }
        return "msg";
    }

    @RequestMapping("/delete")
    public String delete(Model model, Integer id){
        leaveService.delete(id);
        model.addAttribute("msg","删除成功");
        return "msg";
    }

    @RequestMapping("/deleteBath")
    public String deleteBath(Model model, Integer[] checkId){
        leaveService.deleteBath(checkId);
        model.addAttribute("msg","删除成功");
        return "msg";
    }
}