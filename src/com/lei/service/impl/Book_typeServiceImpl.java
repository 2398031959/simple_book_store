package com.lei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lei.dao.Book_typeMapper;
import com.lei.po.Book_type;
import com.lei.service.Book_typeService;
@Service
public class Book_typeServiceImpl implements Book_typeService {
	@Resource
	private Book_typeMapper mapper;
	@Override
	public List<Book_type> selectAll() {
		return mapper.selectByExample(null);
	}

}
