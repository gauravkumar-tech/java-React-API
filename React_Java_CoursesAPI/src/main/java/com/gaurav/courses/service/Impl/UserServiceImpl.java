package com.gaurav.courses.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaurav.courses.Model.User;
import com.gaurav.courses.repository.UserRepository;
import com.gaurav.courses.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
//	user login api
	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	@Override
	public Map UserLogin(Map user) {
		Map map =new HashMap();
		try {
			User userDTO = userRepo.findByUserName(user.get("userName").toString());
			if(userDTO!=null) {
				map.put("user", userDTO);
				map.put("UserPresent",true);	
			}else
				throw new Exception("user Not Present");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("UserPresent", false);
		}
		return map;
	}

//	user creation api
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map createUser(Map user) {
		Map map = new HashMap();
		try {
			Map userMAp=(Map) user.get("data");
			User userDTO = userRepo.findByUserName(userMAp.get("userName").toString());
			if(userDTO==null) {
				User user2 = new User();
				user2.setPassword(userMAp.get("password").toString());
				user2.setUserName(userMAp.get("userName").toString());
				userRepo.save(user2);
				map.put("user", user2);
				map.put("UserSaved",true);	
			}else
				throw new Exception("user Already Present");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("UserSaved", false);
		}
		return map;
	}

	
	
}
