package com.axsos.license.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.axsos.license.models.Person;
import com.axsos.license.services.LicenseServices;

@Controller

public class HomeController {
	private final LicenseServices licenesesevice;

	public HomeController(LicenseServices licenesesevice) {
		super();
		this.licenesesevice = licenesesevice;
	}
	
	@RequestMapping("/person/new")
	public String index(Model model, @ModelAttribute("person") Person person) {
		
		return "index.jsp";
	}
	
	@RequestMapping(value = "/person/new", method = RequestMethod.POST)
	public  String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp"; 
		}else {
			licenesesevice.createPerson(person);
			return "redirect:/licenses/new";
		}
		
	}

}
