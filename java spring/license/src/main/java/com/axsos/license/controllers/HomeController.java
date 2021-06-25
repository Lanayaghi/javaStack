package com.axsos.license.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.axsos.license.models.License;
import com.axsos.license.models.Person;
import com.axsos.license.services.LicenseServices;

@Controller

public class HomeController {
	private final LicenseServices licenesesevice;

	public HomeController(LicenseServices licenesesevice) {
		super();
		this.licenesesevice = licenesesevice;
	}
	
	@RequestMapping(value = "/person/new" , method = RequestMethod.POST)
	public String index(Model model, @ModelAttribute("person") Person person) {
		
		return "index.jsp";
	}
	
	@RequestMapping("/person/new" )
	public  String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp"; 
		}else {
			licenesesevice.createPerson(person);
			return "redirect:/licenses/new";
		}
		
	}
	
	@RequestMapping("/licenses/new")
	public String license(Model model, @ModelAttribute("license") License license) {
		model.addAttribute("persons", licenesesevice.allPersons());
		List<Person> noLicense= licenesesevice.unLicensed();
		model.addAttribute("persons", noLicense);
		return "license.jsp";
	}
	
	@RequestMapping(value = "/license/new")
	public  String newLicense(@Valid @ModelAttribute("license") License license, BindingResult result) {
		if(result.hasErrors()) {
			return "license.jsp"; 
		}else {
			licenesesevice.createLicense(license);
			return "redirect:/licenses/new";
		}
		
	}
	@RequestMapping("/person/{id}")
	public String thisPerson(@PathVariable("id") Long id , Model model) {
		model.addAttribute("person", licenesesevice.getPerson(id));
		return "showpersondetails.jsp";
	}
 

}
