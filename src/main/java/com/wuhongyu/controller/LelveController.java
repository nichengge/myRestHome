package com.wuhongyu.controller;

import com.github.pagehelper.PageHelper;
import com.wuhongyu.common.MyCommon;
import com.wuhongyu.entity.Lelve;
import com.wuhongyu.entity.MyPage;
import com.wuhongyu.service.LelveService;
import com.wuhongyu.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/lelve")
public class LelveController {

    @Autowired
    private LelveService lelveService;

    @RequestMapping("/list")
    public String list(Model model , Integer pageNum, Lelve lelve, HttpServletRequest request){
        PageHelper.startPage(MyUtil.getCurrentPage(pageNum),MyCommon.PAGESIZE);
        List<Lelve> lelveList = lelveService.selectAll(lelve);
        MyPage<Lelve> page = MyUtil.getPage(lelveList, request);
        model.addAttribute("lelveList",lelveList);
        model.addAttribute("page",page);
        return "adminjsp/lelve/list";
    }

    //改功能也是只能修改
    @RequestMapping("/queryBeforeUpdateOrInsert")
    public String queryBeforeUpdateOrInsert(Model model , Integer id){
        Lelve lelve = lelveService.queryById(id);
        model.addAttribute("lelve",lelve);
        return "adminjsp/lelve/insertOrUpdate";
    }

    @RequestMapping("/insertOrUpdate")
    public String insertOrUpdate(Model model, Lelve lelve){
        lelveService.update(lelve);
        model.addAttribute("msg","添加成功");
        return "msg";
    }

    @RequestMapping("/delete")
    public String delete(Model model, Integer id){
        lelveService.delete(id);
        model.addAttribute("msg","删除成功");
        return "msg";
    }

    @RequestMapping("/deleteBath")
    public String deleteBath(Model model, Integer[] checkId){
        lelveService.deleteBath(checkId);
        model.addAttribute("msg","删除成功");
        return "msg";
    }

    @RequestMapping("/queryLelveByOldmanId")
    public String queryLelveByOldmanId(Model model, Integer oldid){
        Lelve lelve = lelveService.queryByOldid(oldid);
        model.addAttribute("lelve",lelve);
        return "userjsp/lelve/query";
    }
}