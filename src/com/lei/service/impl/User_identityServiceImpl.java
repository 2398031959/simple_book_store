package com.lei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lei.dao.User_identityMapper;
import com.lei.po.User_identity;
import com.lei.service.User_identityService;
@Service
public class User_identityServiceImpl implements User_identityService {
	@Resource
	private User_identityMapper mapper;
	@Override
	public List<User_identity> selectAll() {
		return mapper.selectByExample(null);
	}

}
