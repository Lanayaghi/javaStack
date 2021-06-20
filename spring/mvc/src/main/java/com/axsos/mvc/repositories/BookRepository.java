package com.axsos.mvc.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.mvc.models.book;

@Repository 
public interface BookRepository extends CrudRepository<book, Long> {
	
	List<book> findAll();
	Optional<book> findById(Long id);
	void deleteById(Long id);

}
