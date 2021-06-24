package com.axsos.license.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.license.models.License;
import com.axsos.license.models.Person;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long>{
	List<License> findAll();
	

}
