package com.axsos.license.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.license.models.License;
import com.axsos.license.models.Person;
import com.axsos.license.repositories.LicenseRepository;
import com.axsos.license.repositories.PersonRepositories;


@Service
public class LicenseServices {
	private final LicenseRepository licensereposit;
	private final PersonRepositories personreposit;
	
	
	
	public LicenseServices(LicenseRepository licensereposit, PersonRepositories personreposit) {
		super();
		this.licensereposit = licensereposit;
		this.personreposit = personreposit;
	}

	public List<Person> allPersons(){
		return personreposit.findAll();
	}
	
	public Person createPerson(Person p) {
		return personreposit.save(p);
	}
	
	public Person findeLicense(Long id) {
		Optional <Person> optionalLicense = personreposit.findById(id);
		if (optionalLicense.isPresent()) {
			return optionalLicense.get();
		}else {
			return null; 
		}
	}

}
