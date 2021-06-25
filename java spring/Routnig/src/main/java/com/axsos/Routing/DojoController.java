package com.axsos.Routing;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DojoController {
	
	@RequestMapping("dojo/{text}")
	public String dojo( @PathVariable("text") String text) {
		return "The"+ " " + text + " " +"is awesome!";
		
	}
	
	@RequestMapping("/burbank-dojo/{text}")
	public String bdojo(@PathVariable ("text") String text) {
		return  text + " " + "Dojo is located in Southern California";
	}
	
	@RequestMapping("/san-jose/{text}")
	public String san(@PathVariable ("text") String text) {
		return text +  " " + "dojo is the headquarters";
	}
}



