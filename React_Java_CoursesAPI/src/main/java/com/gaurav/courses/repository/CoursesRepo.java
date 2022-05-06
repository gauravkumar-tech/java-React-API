package com.gaurav.courses.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.courses.Model.Courses;

@Repository
public interface CoursesRepo extends CrudRepository<Courses, Integer>{
	
	public Courses findByCourseName(String courseName);

}
