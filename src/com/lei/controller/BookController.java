package com.lei.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.lei.po.Book;
import com.lei.po.Book_type;
import com.lei.po.Dict_bus;
import com.lei.po.User;
import com.lei.service.BookService;
import com.lei.service.Book_typeService;
import com.lei.service.Dict_busService;

@Controller
public class BookController {
	@Resource
	private BookService bookService;
	@Resource
	private Book_typeService book_typeService;
	@Resource
	private Dict_busService dict_busService;
	/*
	 * 管理员的书籍列表，实现索引查询，页面跳转查询
	 */
	@RequestMapping(value = "/listBook")
	public String listBook(HttpSession session,
			@RequestParam(defaultValue = "1") Integer PageNum,
			@RequestParam(defaultValue = "5") Integer pageSize, Book book,
			String key) {
		if ("all".equals(key)) {
			session.removeAttribute("searchBook");
		}
		if ("search".equals(key)) {
			session.setAttribute("searchBook", book);
		}
		if ("skip".equals(key)) {
			book = (Book) session.getAttribute("searchBook");
			session.removeAttribute("pageBook");
		}
		PageInfo<Book> pageBook = bookService.listBook(PageNum, pageSize, book);
		session.setAttribute("pageBook", pageBook);
		List<Book_type> book_types = book_typeService.selectAll();
		session.setAttribute("book_types", book_types);
		session.setAttribute("PageNum", PageNum);
		return "adminOfBooks";
	}
	/*
	 * 进入书籍添加的页面
	 */
	@RequestMapping(value = "/bookAdd")
	public String bookAdd() {
		return "bookAdd";
	}
	/*
	 * 添加书籍
	 */
	@RequestMapping(value = "/addBook")
	public String addBook(Book book, HttpSession session) {
		bookService.addBook(book);
		Integer PageNum = (Integer) session.getAttribute("PageNum");
		return "redirect:listBook?PageNum=" + PageNum + "&key=skip";
	}
	/*
	 * 进入书籍修改的页面
	 */
	@RequestMapping(value = "/bookUpdate")
	public String bookUpdate(Book book, HttpSession session) {
		Book oldBook = bookService.selectByPrimarykey(book.getBid());
		session.setAttribute("oldBook", oldBook);
		return "bookUpdate";
	}
	/*
	 * 修改书籍
	 */
	@RequestMapping(value = "/updateBook")
	public String updateBook(Book book, HttpSession session) {
		bookService.updateBook(book);
		Integer PageNum = (Integer) session.getAttribute("PageNum");
		return "redirect:listBook?PageNum=" + PageNum + "&key=skip";
	}
	/*
	 * 删除书籍
	 */
	@RequestMapping(value = "/deleteBook")
	public String deleteBook(Book book, HttpSession session) {
		bookService.deleteBook(book.getBid());
		Integer PageNum = (Integer) session.getAttribute("PageNum");
		return "redirect:listBook?PageNum=" + PageNum + "&key=skip";
	}
	/*
	 * 学生的书籍列表，实现索引查询，页面跳转查询
	 */
	@RequestMapping(value = "/listBook1")
	public String listBook1(HttpSession session,
			@RequestParam(defaultValue = "1") Integer PageNum,
			@RequestParam(defaultValue = "5") Integer pageSize, Book book,
			String key) {
		if ("all".equals(key)) {
			session.removeAttribute("searchBook");
		}
		if ("search".equals(key)) {
			session.setAttribute("searchBook", book);
		}
		if ("skip".equals(key)) {
			book = (Book) session.getAttribute("searchBook");
			session.removeAttribute("pageBook");
		}
		PageInfo<Book> pageBook = bookService.listBook(PageNum, pageSize, book);
		session.setAttribute("pageBook", pageBook);
		List<Book_type> book_types = book_typeService.selectAll();
		session.setAttribute("book_types", book_types);
		session.setAttribute("PageNum", PageNum);
		User loginUser=(User) session.getAttribute("loginUser");
		List<Dict_bus> dicts=dict_busService.dictList(loginUser.getUid());
		if(dicts.size()==0){
			dicts=null;
		}
		session.setAttribute("dicts", dicts);
		return "studentOfBooks";
	}
	/*
	 * 借阅书籍
	 */
	@RequestMapping(value = "/borrowBook")
	public String bookBorrow(Dict_bus dict_bus,HttpSession session) {
		dict_busService.addDict(dict_bus);
		Integer PageNum = (Integer) session.getAttribute("PageNum");
		return "redirect:listBook1?PageNum=" + PageNum + "&key=skip";
	}
	/*
	 * 归还书籍
	 */
	@RequestMapping(value = "/returnBook")
	public String returnBook(Dict_bus dict_bus,HttpSession session) {
		dict_busService.deleteDict(dict_bus.getdId());
		Integer PageNum = (Integer) session.getAttribute("PageNum");
		return "redirect:listBook1?PageNum=" + PageNum + "&key=skip";
	}
}
