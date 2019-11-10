package com.lei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lei.dao.UserMapper;
import com.lei.po.User;
import com.lei.po.UserExample;
import com.lei.po.UserExample.Criteria;
import com.lei.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper mapper;

	@Override
	public User getLoginUser(User user) {
		UserExample userExample = new UserExample();
		Criteria uc = userExample.createCriteria();
		uc.andUnameEqualTo(user.getUname());
		uc.andUpwdEqualTo(user.getUpwd());
		uc.andUidentityEqualTo(user.getUidentity());
		List<User> users = mapper.selectByExample(userExample);
		for (User user2 : users) {
			return user2;
		}
		return null;
	}

	@Override
	public PageInfo<User> listUser(Integer PageNum, Integer pageSize, User user) {
		PageHelper.startPage(PageNum, pageSize);
		List<User> users = mapper.listUser(user);
		PageInfo<User> pageUser = new PageInfo<User>(users);
		return pageUser;
	}

	@Override
	public Integer addUser(User user) {
		return mapper.insertSelective(user);
	}

	@Override
	public Integer updateUser(User user) {
		return mapper.updateByPrimaryKeySelective(user);
	}
	@Override
	public Integer deleteUser(Integer uid) {
		return mapper.deleteByPrimaryKey(uid);
	}

	@Override
	public User selectByPrimaryKey(Integer uid) {
		return mapper.selectByPrimaryKey(uid);
	}
}
