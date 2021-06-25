package com.axsos.dojosandninjas.rebositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.dojosandninjas.models.Dojos;
import com.axsos.dojosandninjas.models.Ninjas;

@Repository
public interface DojosRepository extends CrudRepository<Dojos, Long> {
	List<Dojos> findAll();

}
