package com.axsos.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.languages.models.Language;
import com.axsos.languages.repositories.LanguagesRepository;

@Service
public class LanguageServices {
private final LanguagesRepository LangRepo;

public LanguageServices(LanguagesRepository LangRepo) {
	this.LangRepo = LangRepo;
}

public List<Language> allLanguages(){
	return LangRepo.findAll();
	
}

public Language createLanguage(Language language) {
    return LangRepo.save(language);

	
}

public Language updateLanguage(Language language) {
    return LangRepo.save(language);

	
}
public Language findLanguage(Long id) {
	Optional <Language> optionalLanguage = LangRepo.findById(id);
	if(optionalLanguage.isPresent()) {
		return optionalLanguage.get();
	}else {
		return null;
	}
}

public Language updateLanguage(Long id, String name, String creator, Integer version) {
	Optional <Language> optionalLanguage = LangRepo.findById(id);
	Language language = optionalLanguage.get();
	language.setName(name);
	language.setVersion(version);
	language.setCreator(creator);
	
	return LangRepo.save(language);

}

public void deleteLanguage(Long id ) {
	LangRepo.deleteById(id);
}

}
