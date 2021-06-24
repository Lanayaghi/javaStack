package com.axsos.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.axsos.dojosandninjas.models.Dojos;
import com.axsos.dojosandninjas.services.DojoNinjaServices;

@Controller
public class DojoController {
	private final DojoNinjaServices dojoninjaservice;

	public DojoController(DojoNinjaServices dojononjaservice) {
		super();
		this.dojoninjaservice = dojononjaservice;
	}
	
	@RequestMapping("/dojos/new")
	public String newdojo(@ModelAttribute("dojo") Dojos dojo) {
		return "index.jsp";
	}
	
	@RequestMapping(value = "/dojos/new", method= RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojos dojo, BindingResult result ) {
		if(result.hasErrors()) {
			return "index.jsp";
		}else {
			dojoninjaservice.createDojo(dojo);
			return"redirect:/ninjas/new";
		}
	}
	
}
