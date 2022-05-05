package com.gaurav.courses.service;

import java.util.Map;

import com.gaurav.courses.Model.User;

public interface UserService {

	@SuppressWarnings("rawtypes")
	public Map UserLogin(Map user);

	public Map createUser(User user);
	
}
