package com.axsos.Code;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class CodeController {
 @RequestMapping("")
 public String home() {
	 return "home.jsp";
 }
@RequestMapping(value="/code", method=RequestMethod.POST) 
public String error(@RequestParam(value="code") String code, RedirectAttributes ErrorMessage) {
	if (code.equals("bushido")) {
		return "redirect:/code";
	}
	else {
		ErrorMessage.addFlashAttribute("error", "you must train harder");
		return "redirect:/";
	}

}
@RequestMapping(value = "/code", method = RequestMethod.GET)
public String code () {
	return "code.jsp";
	
}
}
