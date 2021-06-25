package com.axsos.driverLicense.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsos.driverLicense.models.Driver;
import com.axsos.driverLicense.repositories.DriverRepository;

@Service
public class DriverServices {
	@Autowired
	private DriverRepository driverReposit;
	
	public List<Driver> findAllDrivers(){
		return driverReposit.findAll();
	}
	
	public Driver findDriver(Long id) {
		Optional<Driver> d = driverReposit.findById(id);
		if (d.isPresent()) {
			return d.get();
		}else {
			return null;
		}
	}
	
	public Driver createDriver(Driver d) {
		return driverReposit.save(d);
		
	}
	public Driver UpdateDriver(Long id, Driver d) {
		Driver driver = findDriver(id);
		driver.setFirstName(d.getFirstName());
		driver.setLastName(d.getLastName());
		driverReposit.save(driver);
		return driver;
	}
	
	public void delteDriver(Long id) {
		driverReposit.deleteById(id);
	}

}
