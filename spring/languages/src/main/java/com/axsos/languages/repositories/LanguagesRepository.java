package com.axsos.languages.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.languages.models.Language;


@Repository
public interface LanguagesRepository extends  CrudRepository <Language, Long> {
	List<Language> findAll();
	Optional<Language> findById(Long id);
	void deleteById(Long id);

}
