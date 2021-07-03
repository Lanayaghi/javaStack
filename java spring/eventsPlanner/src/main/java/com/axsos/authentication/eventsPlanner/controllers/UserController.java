package com.axsos.authentication.eventsPlanner.controllers;

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

import com.axsos.authentication.eventsPlanner.models.User;
import com.axsos.authentication.eventsPlanner.servecies.UserServices;
import com.axsos.authentication.eventsPlanner.validator.UserValid;



@Controller
public class UserController {
	@Autowired
	private UserServices userServ;
	@Autowired
	private UserValid userVali;
	
	   
    @RequestMapping("/")
    public String registerForm(@ModelAttribute("registration") User user, HttpSession session) {
    	if(session.getAttribute("userId") != null) {  //user is looged()
    		return "redirect:/";
    	}
    	return "index.jsp";
    }
    @RequestMapping("/login")
    public String login( HttpSession session) {
    	if(session.getAttribute("userId") != null) {//user is looged()
        	return "redirect:/";
    	} 
    	return "index.jsp";
    }
    
    @RequestMapping(value="/", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("registration") User user, BindingResult result, HttpSession session, Model model) {
    userVali.validate(user, result);
       if (result.hasErrors()) {
    	   return "index.jsp";
       }
    	   if(userServ.findByEmail(user.getEmail()) != null) {
    		   model.addAttribute("error", "This Email is already used!");
    		   return "index.jsp";
    	   } else {
    	   userServ.registerUser(user);
    	   session.setAttribute("userId", user.getId());
    	   return"redirect:/";
    	   
       }
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
        // if the user is authenticated, save their user id in session
        // else, add error messages and return the login page
    	if(userServ.authenticateUser(email, password) ) {
    		Long id = userServ.findByEmail(email).getId();
    		session.setAttribute("userId", id);
    		return "redirect:/event";
    	} else {
    		model.addAttribute("error", "the email or password is inavlid");
    		return "redirect:/";
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
    	return "redirect:/register";
    }
    
    }

