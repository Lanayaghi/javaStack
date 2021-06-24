package com.axsos.license.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axsos.license.models.Person;
import com.axsos.license.services.LicenseServices;

@RestController
public class LicenseApi {
	private final LicenseServices licenseservice;
	
	public LicenseApi (LicenseServices licenseservice) {
		this.licenseservice = licenseservice;
	}
	
	@RequestMapping("/api/persons")
	public List<Person> index(){
		return licenseservice.allPersons();
	}
	
	@RequestMapping(value = "/api/persons", method = RequestMethod.POST)
	public Person create(@RequestParam(value = "firstName") String firstName,@RequestParam(value = "lastName") String lastName ) {
		Person person = new Person(firstName,lastName);
		return licenseservice.createPerson(person);
	}

}
