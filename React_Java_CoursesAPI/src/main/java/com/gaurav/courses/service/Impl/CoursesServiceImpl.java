package com.gaurav.courses.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.courses.Model.Courses;
import com.gaurav.courses.Model.User;
import com.gaurav.courses.repository.CoursesRepo;
import com.gaurav.courses.service.CoursesService;

@Service
public class CoursesServiceImpl implements CoursesService{

	@Autowired
	private CoursesRepo courseRepo;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map getAllCourses() {
		Map returnMap = new HashMap();
		try {
			returnMap.put("allCourses",courseRepo.findAll());
			returnMap.put("hasCourses", true);
		} catch (Exception e) {
			e.printStackTrace();
			returnMap.put("hasCourses", false);
		}
		return returnMap;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map createCourse(Map jsonMap) {
		Map map = new HashMap();
		try {
			Map courseMap=(Map) jsonMap.get("data");
			Courses courses = courseRepo.findByCourseName(courseMap.get("courseName").toString());
			if(courses==null) {
				Courses course = new Courses();
				course.setCourseName(courseMap.get("courseName").toString());
				course.setCourseDescription(courseMap.get("courseDescription").toString());
				course.setUserID(Integer.parseInt(courseMap.get("userId").toString()));
				courseRepo.save(course);
				map.put("Course", course);
				map.put("courseAdded",true);
				map.put("message","Course Successfully added with Name : "+ course.getCourseName());
			}else
				throw new Exception("Course Already Present");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("courseAdded", false);
			map.put("message","Invalid Request!! Course Already Present!! ");
		}
		return map;
	}
}
