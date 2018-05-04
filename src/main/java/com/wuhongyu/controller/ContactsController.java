package com.wuhongyu.controller;


import com.github.pagehelper.PageHelper;
import com.wuhongyu.common.MyCommon;
import com.wuhongyu.entity.Contacts;
import com.wuhongyu.entity.MyPage;
import com.wuhongyu.service.ContactsService;
import com.wuhongyu.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactsService contactsService;

    @RequestMapping("/list")
    public String list(Model model, HttpServletRequest request, Integer pageNum, Integer oldid){
        PageHelper.startPage(MyUtil.getCurrentPage(pageNum),MyCommon.PAGESIZE);
        List<Contacts> contactsList = contactsService.selectByOldid(oldid);
        MyPage<Contacts> page = MyUtil.getPage(contactsList, request);
        model.addAttribute("contactsList",contactsList);
        model.addAttribute("page",page);
        model.addAttribute("oldid",oldid);
        return "contacts/list";
    }

    @RequestMapping("/queryBeforeUpdateOrInsert")
    public String queryBeforeUpdateOrInsert(Model model, Integer id,Integer oldid){
        if(id != null){
            Contacts contacts = contactsService.selectById(id);
            model.addAttribute("contacts",contacts);
        }
        model.addAttribute("oldid",oldid);
        return "contacts/insertOrUpdate";
    }

    @RequestMapping("/insertOrUpdate")
    public String insertOrUpdate(Model model, Contacts contacts){
        if(contacts.getId()!=null){
            contactsService.update(contacts);
            model.addAttribute("msg","修改成功");
        }else {
            contactsService.insert(contacts);
            model.addAttribute("msg","添加成功");
        }
        return "msg";
    }

    @RequestMapping("/delete")
    public String delete(Model model, Integer id){
        contactsService.deleteById(id);
        model.addAttribute("msg","删除成功");
        return "msg";
    }

    @RequestMapping("/deleteBath")
    public String deleteBath(Model model, Integer[] checkId){
        contactsService.deletBach(checkId);
        model.addAttribute("msg","删除成功");
        return "msg";
    }
}