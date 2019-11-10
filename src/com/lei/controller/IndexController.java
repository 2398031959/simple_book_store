package com.lei.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lei.po.User_identity;
import com.lei.service.User_identityService;

@Controller
public class IndexController {
	@Resource
	private User_identityService uiService;
	/*
	 * 重定向到/login
	 */
	@RequestMapping(value="/toLogin.action")
	public String toLoginAction(){
		return "redirect:login";
	}
	/*
	 * 进入login界面
	 */
	@RequestMapping(value="/login")
	public String login(Model model){
		List<User_identity> uis=uiService.selectAll();
		model.addAttribute("uis", uis);
		return "login";
	}
}
