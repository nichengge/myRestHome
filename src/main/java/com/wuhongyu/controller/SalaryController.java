package com.wuhongyu.controller;


import com.github.pagehelper.PageHelper;
import com.wuhongyu.common.MyCommon;
import com.wuhongyu.entity.Contacts;
import com.wuhongyu.entity.MyPage;
import com.wuhongyu.entity.Salary;
import com.wuhongyu.service.SalaryService;
import com.wuhongyu.util.MyUtil;
import org.apache.tools.ant.taskdefs.condition.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @RequestMapping("/list")
    public String list(Model model , HttpServletRequest request, Integer pageNum){
        PageHelper.startPage(MyUtil.getCurrentPage(pageNum),MyCommon.PAGESIZE);
        List<Salary> salaryList = salaryService.selectAll();
        MyPage<Salary> page = MyUtil.getPage(salaryList, request);
        model.addAttribute("salaryList",salaryList);
        model.addAttribute("page",page);
        return "adminjsp/salary/list";
    }

    //不提供增加功能
    @RequestMapping("/queryBeforeUpdateOrInsert")
    public String queryBeforeUpdateOrInsert(Model model,Integer id){
        if(id != null){//修改
            Salary salary = salaryService.queryById(id);
            model.addAttribute("salary",salary);
        }
        return "adminjsp/salary/insertOrUpdate";
    }

    @RequestMapping("/insertOrUpdate")
    public String insertOrUpdate(Model model, Salary salary){
        salaryService.update(salary);
        model.addAttribute("msg","修改成功");
        return "msg";
    }

    @RequestMapping("/delete")
    public String delete(Model model, Integer id){
        salaryService.delete(id);
        model.addAttribute("msg","删除成功");
        return "msg";
    }

    @RequestMapping("/deleteBath")
    public String deleteBath(Model model, Integer[] checkId){
        salaryService.deleteBath(checkId);
        model.addAttribute("msg","删除成功");
        return "msg";
    }
}