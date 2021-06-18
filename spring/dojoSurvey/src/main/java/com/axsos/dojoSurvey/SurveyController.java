package com.axsos.dojoSurvey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SurveyController {
	@RequestMapping("")
	public String survey() {
		return"index.jsp";
	}
	@RequestMapping(value="/result" , method = RequestMethod.POST)
	public String result(@RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam (value="fave") String fave, @RequestParam (value="comment") String comment, Model viewModel) {
	    viewModel.addAttribute("name", name);
	    viewModel.addAttribute("location", location);
	    viewModel.addAttribute("fave", fave);
	    viewModel.addAttribute("comment", comment);



		return"result.jsp";
	}

}
