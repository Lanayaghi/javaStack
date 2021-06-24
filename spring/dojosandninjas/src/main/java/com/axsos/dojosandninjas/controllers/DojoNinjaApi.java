package com.axsos.dojosandninjas.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axsos.dojosandninjas.models.Dojos;
import com.axsos.dojosandninjas.models.Ninjas;
import com.axsos.dojosandninjas.services.DojoNinjaServices;

@RestController
public class DojoNinjaApi {
	private final DojoNinjaServices dojoninjaservice;

	public DojoNinjaApi(DojoNinjaServices dojoninjaservice) {
		super();
		this.dojoninjaservice = dojoninjaservice;
	}
	
	@RequestMapping("/api/dojos")
	public List<Dojos> index(){
		return dojoninjaservice.allDojos();
	}
	
	@RequestMapping(value = "/api/dojos", method = RequestMethod.POST)
	public Dojos create(@RequestParam(value = "name") String name) {
		Dojos dojo = new Dojos(name);
		return dojoninjaservice.createDojo(dojo);
	}
	
	@RequestMapping ("/api/dojos/{id}")
	public Dojos show(@PathVariable("id") Long id) {
		Dojos dojo = dojoninjaservice.findDojo(id);
		return dojo;
	}
	
	@RequestMapping(value = "/api/ninjas", method = RequestMethod.POST)
	public Ninjas ninjaCreate(@RequestParam(value = "firstName") String firstName, @RequestParam(value = "lastName") String lastName,  @RequestParam(value = "age") Integer age) {
		Ninjas ninja = new Ninjas(firstName,lastName,age);
		return dojoninjaservice.createNinja(ninja);
	}

}
