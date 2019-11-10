package com.lei.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lei.dao.BookMapper;
import com.lei.po.Book;
import com.lei.service.BookService;
@Service
public class BookServiceImpl implements BookService {
	@Resource
	private BookMapper bookMapper;
	@Override
	public PageInfo<Book> listBook(Integer pageNum, Integer pageSize,Book book) {
		PageHelper.startPage(pageNum, pageSize);
		List<Book> books=bookMapper.listbook(book);
		PageInfo<Book> pageBook=new PageInfo<Book>(books);
		return pageBook;
	}
	@Override
	public int addBook(Book book) {
		return bookMapper.insertSelective(book);
	}
	@Override
	public Book selectByPrimarykey(Integer bid) {
		return bookMapper.selectByPrimaryKey(bid);
	}
	@Override
	public int updateBook(Book book) {
		return bookMapper.updateByPrimaryKeySelective(book);
	}
	@Override
	public Integer deleteBook(Integer bid) {
		return bookMapper.deleteByPrimaryKey(bid);
	}

}
