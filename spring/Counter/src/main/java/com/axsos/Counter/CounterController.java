package com.axsos.Counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/you_server")
public class CounterController {
	
	@RequestMapping("")
	public String server(HttpSession session) {
		if (session.isNew()) {
			session.setAttribute("count", 0);
		}
		else {
			Integer count = (Integer) session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
			
		}
			
		return "server.jsp";
		
		  
	}
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		
		return"counter.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.removeAttribute("count");
		return"redirect:/you_server/counter";
	}
   
}
