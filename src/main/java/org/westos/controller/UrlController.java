package org.westos.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UrlController {

	@RequestMapping("/adminjsp")
	public String adminjsp() {
		return "adminjsp/main";
	}

	@RequestMapping("/userjsp")
	public String userjsp() {
		return "userjsp/main";
	}

	@RequestMapping("/admintop")
	public String admintop() {
		return "adminjsp/top";
	}

	@RequestMapping("/login")
	public String login() {
		return "login/login";
	}

	@RequestMapping("/adminleft")
	public String adminleft() {
		return "adminjsp/left";
	}

	@RequestMapping("/adminbody")
	public String adminbody() {
		return "adminjsp/body";
	}
	@RequestMapping("/exit")
	public String exit() {
		return "login/login";
	}
	
	@RequestMapping("/usertop")
	public String usertop() {
		return "userjsp/top";
	}
	@RequestMapping("/userleft")
	public String userleft() {
		return "userjsp/left";
	}
	@RequestMapping("/userbody")
	public String userbody() {
		return "userjsp/body";
	}

}
