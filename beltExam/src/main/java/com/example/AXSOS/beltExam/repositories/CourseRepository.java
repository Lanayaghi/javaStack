package com.example.AXSOS.beltExam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.AXSOS.beltExam.models.Course;
@Repository

public interface CourseRepository  extends CrudRepository<Course, Long>{
	List<Course> findAll();
  
}
