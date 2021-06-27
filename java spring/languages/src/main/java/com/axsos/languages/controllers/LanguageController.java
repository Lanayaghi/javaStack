package com.axsos.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.axsos.languages.models.Language;
import com.axsos.languages.services.LanguageServices;

@Controller
public class LanguageController {
	private final LanguageServices languageServices;
	
	public LanguageController(LanguageServices languageServices) {
		this.languageServices = languageServices;
	}

	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("Language") Language Language) {
		List<Language> languages = languageServices.allLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	@RequestMapping(value = "/languages", method = RequestMethod.POST)
	public  String create(@Valid @ModelAttribute("Language") Language Language, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp"; 
		}else {
			languageServices.createLanguage(Language);
			return "redirect:/languages";
		}
		
	}
	

     @RequestMapping("/languages/{id}")
     public String show(@PathVariable("id") Long id, Model model) {
	 Language language = languageServices.findLanguage(id);
	 model.addAttribute("language", language);
	 return "show.jsp";
}

	@RequestMapping(value="/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language language = languageServices.findLanguage(id);
		model.addAttribute("language", language);
		return "edit.jsp";

	}
	
	@RequestMapping(value="/languages/update/{id}", method = RequestMethod.PUT)
	public String editBook(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		}else {
			languageServices.updateLanguage(language);
			return "redirect:/languages";

		}
	}

	
	@RequestMapping(value = "/languages/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
    	languageServices.deleteLanguage(id);
    	  return "redirect:/languages";
    }
}

