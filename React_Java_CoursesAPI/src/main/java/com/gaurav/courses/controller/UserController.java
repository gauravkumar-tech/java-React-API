package com.gaurav.courses.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaurav.courses.Model.User;
import com.gaurav.courses.service.UserService;

@RestController
@RequestMapping("/User")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@SuppressWarnings({ "static-access", "rawtypes" })
	@PostMapping("/login")
	public ResponseEntity<Map> userLogin(@RequestBody Map user){
		ResponseEntity res =null;
		try {
			Map newMap=(Map)user.get("data");
			return res.ok(this.userService.UserLogin(newMap));			
		} catch (Exception e) {
			e.printStackTrace();
			return res.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@SuppressWarnings({ "static-access", "rawtypes" })
	@PostMapping("/create")
	public ResponseEntity<Map> createUser(@RequestBody Map user){
		ResponseEntity res =null;
		try {
			return res.status(HttpStatus.CREATED).body(this.userService.createUser(user));
		} catch (Exception e) {
			e.printStackTrace();
			return res.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@SuppressWarnings({ "static-access", "rawtypes" })
	@PostMapping("/changePassword")
	public ResponseEntity<Map> changeUserPassword(@RequestBody Map user){
		ResponseEntity res =null;
		try {
			return res.status(HttpStatus.CREATED).body(this.userService.changeUserPassword(user));
		} catch (Exception e) {
			e.printStackTrace();
			return res.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
