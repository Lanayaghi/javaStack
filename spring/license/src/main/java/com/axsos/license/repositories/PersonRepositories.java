package com.axsos.license.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.license.models.Person;

@Repository
public interface PersonRepositories extends CrudRepository<Person, Long>{
	List<Person> findAll();

}
