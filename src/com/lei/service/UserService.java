package com.lei.service;

import com.github.pagehelper.PageInfo;
import com.lei.po.User;

public interface UserService {
	public User getLoginUser(User user);
	public PageInfo<User> listUser(Integer PageNum,Integer pageSize,User user);
	public Integer addUser(User user);
	public Integer updateUser(User user);
	public Integer deleteUser(Integer uid);
	public User selectByPrimaryKey(Integer uid);
}
