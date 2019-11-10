package com.lei.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lei.po.User;
import com.lei.service.UserService;

@Controller
public class LoginController {
	@Resource
	private UserService userService;
	/*
	 * 重定向到/main
	 */
	@RequestMapping(value = "/toMain.action")
	public String toMainAction(HttpSession session, User user) {
		session.setAttribute("user", user);
		return "redirect:main";
	}
	/*
	 * 验证身份，登录到不同的主页面
	 */
	@RequestMapping(value = "/main")
	public String main(HttpSession session) {
		User user = (User) session.getAttribute("user");
		User loginUser = userService.getLoginUser(user);
		if (loginUser != null) {
			if (session.getAttribute("msg") != null) {
				session.removeAttribute("msg");
			}
			session.setAttribute("loginUser", loginUser);
			if (loginUser.getUidentity() == 1) {
				return "adminMain";
			} else if (loginUser.getUidentity() == 2) {
				return "studentMain";
			}
		}
		session.setAttribute("msg", "用户名或密码错误");
		return "redirect:toLogin.action";
	}
	/*
	 * 退出登录
	 */
	@RequestMapping(value="/logout")
	public String adminLogout(HttpSession session){
		session.invalidate();
		return "redirect:toLogin.action"; 
	}
}
