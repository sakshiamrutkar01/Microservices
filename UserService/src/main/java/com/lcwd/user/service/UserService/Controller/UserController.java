package com.lcwd.user.service.UserService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.service.UserService.Entity.User;
import com.lcwd.user.service.UserService.Services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userservice;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		User user1 = userservice.saveUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user1);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getSingleUser(@PathVariable String userId)
	{
		User user = userservice.getUser(userId);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getallUser(){
		List<User> allUser = userservice.getallUser();
		return ResponseEntity.ok(allUser);
		
	}
	
}
