package com.wuhongyu.controller;


import com.github.pagehelper.PageHelper;
import com.wuhongyu.common.MyCommon;
import com.wuhongyu.entity.MyPage;
import com.wuhongyu.entity.Oldman;
import com.wuhongyu.entity.User;
import com.wuhongyu.service.OldmanService;
import com.wuhongyu.service.UserService;
import com.wuhongyu.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/oldman")
public class OldmanController {

    @Autowired
    private OldmanService oldmanService;
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String list(Model model, Oldman oldman, HttpServletRequest request,Integer pageNum){
        PageHelper.startPage(MyUtil.getCurrentPage(pageNum),MyCommon.PAGESIZE);
        List<Oldman> oldmenList = oldmanService.selectAll(oldman);
        MyPage<Oldman> page = MyUtil.getPage(oldmenList, request);
        model.addAttribute("page",page);
        model.addAttribute("oldmanList",oldmenList);
        return "adminjsp/oldman/list";
    }

    @RequestMapping("/queryBeforeUpdateOrInsert")
    public String queryBeforeUpdateOrInsert(Model model,Integer id){
        if(id != null){
            Oldman oldman = oldmanService.queryById(id);
            model.addAttribute("oldman",oldman);
        }
        List<User> userList = userService.selectAll(new User());
        model.addAttribute("userList",userList);
        return "adminjsp/oldman/insertOrUpdate";
    }

    @RequestMapping("/insertOrUpdate")
    public String insertOrUpdate(Model model, MultipartFile oldPic,Oldman oldman){
        if(oldman.getId()!=null){//是修改操作
            if(oldPic!=null && oldPic.getSize()!=0){
                MyUtil.deleteNullPic(oldman.getPic());
                String newPic = MyUtil.addNewPic(oldPic);
                oldman.setPic(newPic);
            }
            oldmanService.updateOldman(oldman);
            model.addAttribute("msg","修改成功");
        }else {//是添加操作
            if(oldPic!=null && oldPic.getSize()!=0){
                String newPic = MyUtil.addNewPic(oldPic);
                oldman.setPic(newPic);
            }
            oldmanService.addOldman(oldman);
            model.addAttribute("msg","添加成功");
        }
        return "msg";
    }

    @RequestMapping("/delete")
    public String delete(Model model, Integer id){
        oldmanService.deleteById(id);
        model.addAttribute("msg","删除成功");
        return "msg";
    }

    @RequestMapping("/deleteBath")
    public String deleteBath(Model model, Integer[] checkId){
        oldmanService.deleteByIds(checkId);
        model.addAttribute("msg","删除成功");
        return "msg";
    }
}