package com.axsos.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axsos.languages.models.Language;
import com.axsos.languages.services.LanguageServices;

@RestController
public class LanguageApi {
private final LanguageServices languageservices;

public LanguageApi(LanguageServices languageservices) {
	this.languageservices = languageservices;
}
@RequestMapping("/api/languages")
public List<Language> AllLanguages(){
	
	return languageservices.allLanguages();
}
@RequestMapping (value = "api/languages", method = RequestMethod.POST)
public Language create(@RequestParam (value = "name") String name, @RequestParam ( value = "version") Integer version,
		@RequestParam(value = "creator") String creator) {
	Language language = new  Language(name, creator, version);
	return languageservices.createLanguage(language);
	
}

@RequestMapping ("/api/languages/{id}")
public Language show (@PathVariable("id") Long id) {
	Language language = languageservices.findLanguage(id);
	return language;
}

@RequestMapping(value = "/api/languages/{id}", method = RequestMethod.PUT)
public Language upDate(@PathVariable("id") Long id, @RequestParam (value = "name") String name, @RequestParam ( value = "version") Integer version, @RequestParam(value = "creator") String creator ) {
	Language language = languageservices.updateLanguage(id, name, creator, version);

	return language;
}

@RequestMapping(value = "api/languages/{id}", method=RequestMethod.DELETE)
public void destroy(@PathVariable("id") Long id) {
	languageservices.deleteLanguage(id);
	
	
}

}
