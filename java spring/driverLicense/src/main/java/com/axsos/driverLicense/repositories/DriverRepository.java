package com.axsos.driverLicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.driverLicense.models.Driver;

@Repository
public interface DriverRepository extends CrudRepository<Driver, Long>{
	List<Driver> findAll();

}
