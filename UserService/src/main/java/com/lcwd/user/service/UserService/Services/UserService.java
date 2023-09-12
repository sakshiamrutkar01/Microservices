package com.lcwd.user.service.UserService.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lcwd.user.service.UserService.Entity.User;


@Service
public interface UserService {

	
	User saveUser(User user);
	
	List<User> getallUser();
	
	User getUser(String userId);
}
