package com.axsos.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.axsos.dojosandninjas.models.Ninjas;
import com.axsos.dojosandninjas.services.DojoNinjaServices;

@Controller
public class NinjaController {
	private final DojoNinjaServices dojoninjaservice;

	public NinjaController(DojoNinjaServices dojoninjaservice) {
		super();
		this.dojoninjaservice = dojoninjaservice;
	}
	@RequestMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninjas ninja,Model model) {
		model.addAttribute("dojos", dojoninjaservice.allDojos());
		return "ninjas.jsp";
	}
	
	@RequestMapping(value = "/ninjas/new", method= RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja") Ninjas ninja, BindingResult result ) {
		if(result.hasErrors()) {
			return "ninjas.jsp";
		}else {
			dojoninjaservice.createNinja(ninja);
			return"redirect:/ninjas/new";
		}
	}
	@RequestMapping("/dojos/{id}")
	public String thisNinja(@PathVariable("id") Long id , Model model) {
		model.addAttribute("dojo", this.dojoninjaservice.findDojo(id));
		return "dojos.jsp";
	}
 
}
