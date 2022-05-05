package com.gaurav.courses.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gaurav.courses.Model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	public User findByUserName(String userName);
	
}
