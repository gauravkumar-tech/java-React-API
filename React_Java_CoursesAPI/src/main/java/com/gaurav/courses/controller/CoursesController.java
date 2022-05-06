package com.gaurav.courses.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.courses.service.CoursesService;

@RestController
@RequestMapping("/courses")
@CrossOrigin(origins = "*")
public class CoursesController {

	@Autowired
	private CoursesService courseService;
	
	@SuppressWarnings({ "static-access", "rawtypes" })
	@PostMapping("/allCourses")
	public ResponseEntity<Map> getAllCourse(){
		ResponseEntity res =null;
		try {
			return res.status(HttpStatus.CREATED).body(this.courseService.getAllCourses());
		} catch (Exception e) {
			e.printStackTrace();
			return res.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@SuppressWarnings({ "static-access", "rawtypes" })
	@PostMapping("/Create")
	public ResponseEntity<Map> createCourse(@RequestBody Map jsonMap){
		ResponseEntity res =null;
		try {
			return res.status(HttpStatus.CREATED).body(this.courseService.createCourse(jsonMap));
		} catch (Exception e) {
			e.printStackTrace();
			return res.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	
}
