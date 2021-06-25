package com.axsos.mvc.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.axsos.mvc.models.book;
import com.axsos.mvc.services.BookServices;

@Controller
public class BooksController {
	private final BookServices bookcont;
	
	  public BooksController(BookServices bookService) {
	        this.bookcont = bookService;
	    }
	  
	  @RequestMapping("/books")
	    public String index(Model model) {
	        List<book> books = bookcont.allbooks();
	        model.addAttribute("books", books);
	        return "index.jsp";
	    }
	  
	    
	    @RequestMapping("/books/new")
	    public String newBook(@ModelAttribute("book") book book) {
	        return "new.jsp";
	    }
	    @RequestMapping(value="/books", method=RequestMethod.POST)
	    public String create(@Valid @ModelAttribute("book") book book, BindingResult result) {
	        if (result.hasErrors()) {
	            return "new.jsp";
	        } else {
	        	bookcont.createBook(book);
	            return "redirect:/books";
	        }
	    }
	    
	    @RequestMapping("/books/{id}")
	    public String show(@ModelAttribute("book") book book, @PathVariable("id") Long id, Model model) {
	        book book1 = bookcont.findbook(id);
	        model.addAttribute("book", book1);
	   
	       return "show.jsp";
	    } 
	    
	    @RequestMapping("/books/{id}/edit")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        book book = bookcont.findbook(id);
	        model.addAttribute("book", book);
	        return "edit.jsp";
	    
	    }
	    
	    @RequestMapping("/deletebook/{id}")
	    public String delete(@PathVariable("id") Long id, Model model ) {
	    	bookcont.deleteBook(id);
	    	  return "show.jsp";
	    }
	    
	    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("book") book book, BindingResult result) {
	        if (result.hasErrors()) {
	            return "/books/edit.jsp";
	        } else {
	        	bookcont.updateBook(book);
	            return "redirect:/books";
	        }
	    }
}
