package com.wuhongyu.controller;

import com.github.pagehelper.PageHelper;
import com.wuhongyu.common.MyCommon;
import com.wuhongyu.entity.Counts;
import com.wuhongyu.entity.MyPage;
import com.wuhongyu.service.CountService;
import com.wuhongyu.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/counts")
public class CountsController {

    @Autowired
    private CountService countService;

    @RequestMapping("/list")
    public String list(Model model, HttpServletRequest request, Integer pageNum){
        PageHelper.startPage(MyUtil.getCurrentPage(pageNum),MyCommon.PAGESIZE);
        List<Counts> countsList = countService.count();
        MyPage<Counts> page = MyUtil.getPage(countsList, request);
        model.addAttribute("countsList",countsList);
        model.addAttribute("page",page);
        return "adminjsp/counts/list";
    }
}