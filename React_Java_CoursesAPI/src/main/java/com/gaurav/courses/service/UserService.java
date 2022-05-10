package com.gaurav.courses.service;

import java.util.Map;

import com.gaurav.courses.Model.User;

public interface UserService {

	@SuppressWarnings("rawtypes")
	public Map UserLogin(Map user);
	public Map getAllUsers();

	public Map deleteUser(int id);

	public Map createUser(Map user);
	
	public Map changeUserPassword(Map user);
	
}
