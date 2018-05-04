package com.wuhongyu.controller;

import com.wuhongyu.entity.Admin;
import com.wuhongyu.entity.User;
import com.wuhongyu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("/login")
    public String login(Model model,HttpSession session, String username, String password, String type){
        loginService.OrdersExpiredVerification();
        loginService.deleteBeforeLeave();
        if(loginService.login(username,password,type)){
            if("管理员".equals(type)){
                Admin admin = loginService.seletcAdmin(username, password);
                session.setAttribute("admin",admin);
                return "redirect:/adminjsp/main";
            }else if("护理人员".equals(type)){
                User user = loginService.seletcUser(username, password);
                session.setAttribute("user",user);
                return "redirect:/userjsp/main";
            }
        }
        model.addAttribute("msg","用户名或密码错误");
        return "login/msg";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login/index";
    }

    @RequestMapping("/index")
    public String index(){
        return "login/login";
    }
}