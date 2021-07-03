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
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.AXSOS.beltExam.models.Course;
import com.example.AXSOS.beltExam.models.User;
import com.example.AXSOS.beltExam.services.CourseService;
import com.example.AXSOS.beltExam.services.UserService;

@Controller
public class CourseController {
	
	@Autowired
	private UserService userServ;
	
	@Autowired
	private CourseService courseServ;

	
	@RequestMapping("/courses/")
	public String coursesPage(@ModelAttribute("courses") Course course,Model model) {
		List<Course> c = courseServ.allCourses();
		model.addAttribute("courses", c);//used Model to pass data to frontend
		return "show.jsp";
	}
//	@RequestMapping("/courses/{id}")
//	public String show(@PathVariable("id") Long id,@ModelAttribute("course") Course course,Model model) {
//		Course c = courseServ.findById(id);
//		model.addAttribute("course",c);
//		return "courceDetails.jsp";
//		
//	}
//	
	@RequestMapping("/courses/new")
	public String courseCreation(@ModelAttribute("course") Course c) {
		return "create.jsp";
	}

	
	@PostMapping("/courses/new")
	public String createCourse(@Valid @ModelAttribute("course") Course c, BindingResult result) {
		if (result.hasErrors()) {

			
			return "create.jsp";
		} else {
			
			courseServ.createACourse(c);
			return "redirect:/courses";
		}
	}
	
	@RequestMapping("courses/{id}")
	public String displayCourse(@PathVariable("id") Long id, Model model, HttpSession session) {
		Course course = courseServ.findCourseById(id);
		model.addAttribute("course", course);

		List<User> users = course.getJoining();
		Long userId = (Long) session.getAttribute("userId");
		User u = userServ.findUserById(userId);
		model.addAttribute("currentUser",u);
		System.out.println("--get id-- "+u.getId());
		return "courseDetails.jsp";
	}
	
	@RequestMapping("/courses/add/{id}")
	public String addCourse(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User u = userServ.findUserById(userId);
		Course course = courseServ.findCourseById(id);
		
		u.getJoineCourse().add(course);
		userServ.updateUser(u);
		
		
		return "redirect:/courses";
	}
	
	@RequestMapping("/courses/{id}/edit")
	public String editPage(@ModelAttribute("course") Course course, @PathVariable("id") Long id, Model model) {
		Course course1 = courseServ.findCourseById(id);
		model.addAttribute("course", course1);
		return "edit.jsp";
	}
	
	@PostMapping("/courses/update")
	public String updateCourse(@Valid @ModelAttribute("course") Course course, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			List<User> students =course.getJoining();
			System.out.println("--- all students --- "+ students);

			courseServ.updateCourse(course);
			
			return "redirect:/courses";
		}
		
		
	}
	
	@RequestMapping("/courses/delete/{id}")
	public String deleteCourse(@PathVariable("id") Long id) {
		Course course = courseServ.findCourseById(id);
		if (course != null) {
			courseServ.deleteCourse(course);
			return "redirect:/courses";
		} else {
			System.out.println("Course doesn't exist");
			return "redirect:/courses";
		}

	}
	
	@RequestMapping("/courses/{id}/remove")
	public String removeUserFromCourse(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		User u = userServ.findUserById(userId);
		Course course = courseServ.findCourseById(id);
		
		u.getJoineCourse().remove(course);
		userServ.updateUser(u);
		
		return "redirect:/courses";
	}
	
	
//	@RequestMapping("/courses/add/{id}")
//	public String addUserToCourse(@PathVariable("id") Long myId, Model model, HttpSession session) {
//		Long userId = (Long) session.getAttribute("userId");
//		User u = userServ.findUserById(userId);
//		Course course = courseServ.findCourseById(myId);
//		
//		u.getJoineCourse().add(course);
//		userServ.updateUser(u);
//		
//		return "redirect:/courses";
//	}
	

}
