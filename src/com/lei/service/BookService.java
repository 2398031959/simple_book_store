package com.lei.service;

import com.github.pagehelper.PageInfo;
import com.lei.po.Book;

public interface BookService {
	PageInfo<Book> listBook(Integer pageNum, Integer pageSize, Book book);
	int addBook(Book book);
	Book selectByPrimarykey(Integer bid);
	int updateBook(Book book);
	Integer deleteBook(Integer bid);
}
