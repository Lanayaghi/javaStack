package com.axsos.mvc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.mvc.models.book;
import com.axsos.mvc.repositories.BookRepository;

@Service
public class BookServices {
	private final BookRepository bookrepo;
	
	public BookServices (BookRepository bookrepo) {
		this.bookrepo = bookrepo;
	}
	
    public List<book> allbooks() {
        return bookrepo.findAll();
    }
    // creates a book
    public book createbook(book b) {
        return bookrepo.save(b);
    }
    // retrieves a book
    public book findbook(Long id) {
        Optional<book> optionalbook = bookrepo.findById(id);
        if(optionalbook.isPresent()) {
            return optionalbook.get();
        } else {
            return null;
        }
    }
  public book updateBook( Long id, String title, String desc, String lang, Integer numOfPages) { 
	 Optional<book> book2 = bookrepo.findById(id);
	 book book1 = book2.get();
	 book1.setTitle(title);
	 book1.setDescription(desc);
	 book1.setLanguage(lang);
	 book1.setNumberOfPages(numOfPages);
	 return bookrepo.save(book1);
	
}
  public void deleteBook(Long id) {
	  bookrepo.deleteById(id);
  }
}


