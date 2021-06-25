package com.axsos.HelloHuman;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

@Controller
//@RestController
public class HomeController {
//	@RequestMapping("/")
//	public String human(@RequestParam (value  = "q", required=false ) String searchQuery) {
//		if (searchQuery == null) {
//			return "Hello Human";
//		}
//		else {
//			return "Hello" + searchQuery;
//		}
//	}
@RequestMapping ("/")
public String home(Model model) {
	model.addAttribute("lana", "yaghi");
	return "index.jsp";
}


}
