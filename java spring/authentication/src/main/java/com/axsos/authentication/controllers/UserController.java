package com.axsos.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.authentication.models.User;
import com.axsos.authentication.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userServ;
	
	   
    @RequestMapping("/register")
    public String registerForm(@ModelAttribute("user") User user) {
        return "register.jsp";
    }
    
    @RequestMapping("/login")
    public String login() {
        return "login.jsp";
    }
    
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
       if (result.hasErrors()) {
    	   return "register.jsp";
       }
    	   if(userServ.findByEmail(user.getEmail()) != null) {
    		   model.addAttribute("error", "This Email is already used!");
    		   return "register.jsp";
    	   } else {
    	   userServ.registerUser(user);
    	   session.setAttribute("userId", user.getId());
    	   return"redirect:/home";
    	   
       }
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
    	if(userServ.authenticateUser(email, password) ) {
    		Long id = userServ.findByEmail(email).getId();
    		session.setAttribute("userId", id);
    		return "redirect:/home";
    	} else {
    		model.addAttribute("error", "the email or password is inavlid");
    		return "login.jsp";
    	}
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
    if(session.getAttribute("userId") == null) {
    	return "redirect:/register";
    }else {
    	Long id = (Long) session.getAttribute("userId");
    	User u =  userServ.findUserById(id); //to find the input user that is in the session by the id
    	model.addAttribute("userId", u);
    	return "home.jsp";
    	
    }
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidate session
        // redirect to login page
    	session.invalidate();
    	return "redirect:/login";
    }
}
