package com.axsos.mvc.controllers;

import java.awt.print.Book;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axsos.mvc.models.book;
import com.axsos.mvc.services.BookServices;

@RestController
public class BooksApi {
	private final BookServices bookrserv;

	public BooksApi(BookServices bookrserv) {
		super();
		this.bookrserv = bookrserv;
	}
	
	  @RequestMapping("/api/books")
	    public List<book> index() {
	        return bookrserv.allbooks();
	    }
	    
	    @RequestMapping(value="/api/books", method=RequestMethod.POST)
	    public book create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
	        book book = new book(title, desc, lang, numOfPages);
	        return bookrserv.createBook(book);
	    }
	    
	    @RequestMapping("/api/books/{id}")
	    public book show(@PathVariable("id") Long id) {
	        book book = bookrserv.findbook(id);
	        return book;
	    }
	    
	    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
	    public book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
	        book book = bookrserv.updateBook(id, title, desc, lang, numOfPages);
	        return book;
	    }
	    
	    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
	    public void destroy(@PathVariable("id") Long id) {
	    	bookrserv.deleteBook(id);
	    }

}
