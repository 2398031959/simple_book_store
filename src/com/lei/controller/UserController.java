package com.lei.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.lei.po.User;
import com.lei.po.User_identity;
import com.lei.service.UserService;
import com.lei.service.User_identityService;

@Controller
public class UserController {
	@Resource
	private UserService userService;
	@Resource
	private User_identityService uiService;
	/*
	 * 管理员的学生列表，可以条件查询列表，页面跳转
	 */
	@RequestMapping(value="/listUser")
	public String listUser(@RequestParam(defaultValue="1")Integer PageNum,@RequestParam(defaultValue="5")Integer pageSize,User user,HttpSession session,String key){
		if("all".equals(key)){
			session.removeAttribute("searchUser");
		}
		if("search".equals(key)){
			session.setAttribute("searchUser", user);
		}
		if("skip".equals(key)){
			user=(User) session.getAttribute("searchUser");
			session.removeAttribute("pageUser");
		}
		PageInfo<User> pageUser = userService.listUser(PageNum, pageSize, user);
		session.setAttribute("pageUser", pageUser);
		List<User_identity> identitys = uiService.selectAll();
		session.setAttribute("identitys", identitys);
		session.setAttribute("PageNum", PageNum);
		return "adminOfUsers";
	}
	/*
	 * 进入用户添加页面
	 */
	@RequestMapping(value="/userAdd")
	public String userAdd(){
		return "userAdd";
	}
	/*
	 * 实现用户添加
	 */
	@RequestMapping(value="/addUser")
	public String addUser(HttpSession session,User user){
		userService.addUser(user);
		Integer PageNum=(Integer) session.getAttribute("PageNum");
		return "redirect:listUser?PageNum="+PageNum+"&key=skip";
	}
	/*
	 * 进入学生修改页面
	 */
	@RequestMapping(value="/userUpdate")
	public String userUpdate(User user,HttpSession session){
		User oldUser=userService.selectByPrimaryKey(user.getUid());
		session.setAttribute("oldUser", oldUser);
		return "userUpdate";
	}
	/*
	 * 修改学生信息
	 */
	@RequestMapping(value="/updateUser")
	public String updateUser(User user,HttpSession session){
		userService.updateUser(user);
		Integer PageNum=(Integer) session.getAttribute("PageNum");
		return "redirect:listUser?PageNum="+PageNum+"&key=skip";
	}
	/*
	 * 删除学生
	 */
	@RequestMapping(value="/deleteUser")
	public String deleteBook(User user,HttpSession session){
		userService.deleteUser(user.getUid());
		Integer PageNum=(Integer) session.getAttribute("PageNum");
		return "redirect:listUser?PageNum="+PageNum+"&key=skip";
	}
	/*
	 * 学生密码修改页面
	 */
	@RequestMapping(value="/pwdUpdate")
	public String pwdUpdate(){
		return "pwdUpdate";
	}
	/*
	 * 修改密码
	 */
	@RequestMapping(value="/updatePwd")
	public String updatePwd(User user){
		userService.updateUser(user);
		return "studentMain";
	}
}
