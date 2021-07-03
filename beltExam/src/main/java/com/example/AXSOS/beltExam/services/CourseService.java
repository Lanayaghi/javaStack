package com.example.AXSOS.beltExam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.AXSOS.beltExam.models.Course;
import com.example.AXSOS.beltExam.repositories.CourseRepository;
import com.example.AXSOS.beltExam.repositories.UserRepository;

@Service
public class CourseService {
	
	@Autowired
	private UserRepository userRpo;
	
   @Autowired
   private CourseRepository courseRepo;
   
	
	public List<Course> allCourses(){
		return courseRepo.findAll();
	}
	public Course createACourse(Course c) {
		return courseRepo.save(c);
	}
	
	public void updateCourse(Course c) {
		courseRepo.save(c);
	}
	public void deleteCourse(Course course) {
		courseRepo.delete(course);
	}
	
	public Course findCourseById(Long id) {
		Optional<Course> c = courseRepo.findById(id);
		if(c.isPresent()) {
			return c.get();
		}else {
			return null;
		}
	}
	
	
	
}
