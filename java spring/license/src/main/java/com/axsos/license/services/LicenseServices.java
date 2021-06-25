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
	
	public Person getPerson(Long id) {
		return personreposit.findById(id).orElse(null);
	}
	
	public List<Person> unLicensed(){
		return personreposit.findByLicenseIdNull();
	}

	public List<Person> allPersons(){
		return personreposit.findAll();
	}
	
	public Person createPerson(Person p) {
		return personreposit.save(p);
	}
	
	public Person findeLPerson(Long id) {
		Optional <Person> optionalperson = personreposit.findById(id);
		if (optionalperson.isPresent()) {
			return optionalperson.get();
		}else {
			return null; 
		}
	}
	
	public List<License> allLicense(){
		return licensereposit.findAll();
	}
	public License createLicense(License l) {
		return licensereposit.save(l);
	}
	
	public License findeLicense(Long id) {
		Optional <License> optionalLicense = licensereposit.findById(id);
		if (optionalLicense.isPresent()) {
			return optionalLicense.get();
		}else {
			return null; 
		}
	}

}
