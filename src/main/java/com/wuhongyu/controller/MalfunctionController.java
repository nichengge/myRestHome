package com.wuhongyu.controller;


import com.github.pagehelper.PageHelper;
import com.wuhongyu.common.MyCommon;
import com.wuhongyu.entity.Contacts;
import com.wuhongyu.entity.Malfunction;
import com.wuhongyu.entity.MyPage;
import com.wuhongyu.service.ContactsService;
import com.wuhongyu.service.MalfunctionService;
import com.wuhongyu.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/malfunction")
public class MalfunctionController {

    @Autowired
    private MalfunctionService malfunctionService;

    @RequestMapping("/list")
    public String list(Model model, HttpServletRequest request, Integer pageNum, Integer oldid){
        PageHelper.startPage(MyUtil.getCurrentPage(pageNum),MyCommon.PAGESIZE);
        List<Malfunction> malfunctionList = malfunctionService.selectAll(oldid);
        MyPage<Malfunction> page = MyUtil.getPage(malfunctionList, request);
        model.addAttribute("malfunctionList",malfunctionList);
        model.addAttribute("page",page);
        model.addAttribute("oldid",oldid);
        return "malfunction/list";
    }

    @RequestMapping("/queryBeforeUpdateOrInsert")
    public String queryBeforeUpdateOrInsert(Model model, Integer id,Integer oldid){
        if(id != null){
            Malfunction malfunction = malfunctionService.queryById(id);
            model.addAttribute("malfunction",malfunction);
        }
        model.addAttribute("oldid",oldid);
        return "malfunction/insertOrUpdate";
    }

    @RequestMapping("/insertOrUpdate")
    public String insertOrUpdate(Model model, Malfunction malfunction){
        if(malfunction.getId()!=null){
            malfunctionService.update(malfunction);
            model.addAttribute("msg","修改成功");
        }else {
            malfunctionService.insert(malfunction);
            model.addAttribute("msg","添加成功");
        }
        return "msg";
    }

    @RequestMapping("/delete")
    public String delete(Model model, Integer id){
        malfunctionService.delete(id);
        model.addAttribute("msg","删除成功");
        return "msg";
    }

    @RequestMapping("/deleteBath")
    public String deleteBath(Model model, Integer[] checkId){
        malfunctionService.deleteBath(checkId);
        model.addAttribute("msg","删除成功");
        return "msg";
    }
}