package com.service;

import java.util.List;

import com.bean.Book;
import com.dao.BookDao;

public class BookService {
	public List<Book> getBooks() {
		BookDao bookDao = new BookDao();
		List<Book> list = bookDao.selectAll();
		return list;
	}
}