package com.controller.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.BookBean;
import com.dao.BookDao;

@RestController
public class BookController {
	
	@Autowired
	BookDao bookDao;
	
	@PostMapping("/book")
	public BookBean addBook(BookBean book) {
		bookDao.addBook(book);
		return book;
	}
	@GetMapping("/book")
	public List<BookBean> getAllBooks(){
		return bookDao.getAllBooks();
		
	}
	@DeleteMapping("/book/{bookId}")
	public List<BookBean> removeBook(@PathVariable("bookId") int bookId){
		bookDao.deleteBook(bookId);
		return bookDao.getAllBooks();
	}
	@PutMapping("/book")
	public BookBean modifyBook(BookBean book) {
		bookDao.updsteBook(book);
		return book;
	}
}
