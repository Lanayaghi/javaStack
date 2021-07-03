package com.example.AXSOS.beltExam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.AXSOS.beltExam.models.Course;
import com.example.AXSOS.beltExam.models.User;
import com.example.AXSOS.beltExam.services.CourseService;
import com.example.AXSOS.beltExam.services.UserService;
import com.example.AXSOS.beltExam.validation.UserValidator;

@Controller
public class UserController {
	
	@Autowired
	private UserService userServ;
	@Autowired
	private UserValidator userVali;
	@Autowired
	private CourseService courseServ;
	
	   
	
	@RequestMapping("/users")
	public String show(@PathVariable("id") Long id,@ModelAttribute("User") User user,Model model) {
		User u = userServ.findUserById(id);
		model.addAttribute("user",u);
		return "show.jsp";
		
	}
    @RequestMapping("/register")
    public String registerForm(@ModelAttribute("user") User user, HttpSession session) {
  
    	return "index.jsp";
    }

    
    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session, Model model) {
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
    	   return"redirect:/register";
    	   
       }
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
//         if the user is authenticated, save their user id in session
//         else, add error messages and return the login page
    	if(userServ.authenticateUser(email, password) ) {
    		Long id = userServ.findByEmail(email).getId();
    		session.setAttribute("userId", id);
    		return "redirect:/courses";
    	} else {
    		model.addAttribute("error", "the email or password is inavlid");
    		return "index.jsp";
    	}
    }
    
    @RequestMapping("/courses")
    public String home(HttpSession session, Model model) {
        // get user from session, save them in the model and return the home page
   if(session.getAttribute("userId") == null) {
   	return "redirect:/register";
    }else {
    	Long id = (Long) session.getAttribute("userId");
    	User u =  userServ.findUserById(id); //to find the input user that is in the session by the id
    	 List<Course> courses = courseServ.allCourses();
    	model.addAttribute("user", u);
        model.addAttribute("courses", courses);
    	return "show.jsp";
    	
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
