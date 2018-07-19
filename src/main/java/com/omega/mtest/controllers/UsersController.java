package com.omega.mtest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.omega.mtest.models.User;
import com.omega.mtest.services.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	@Autowired 
	private UserService userService;
	
	@GetMapping()
	@ResponseBody
	public List<User> findAllUsers() {
		return userService.findAll();
	}
	
	@GetMapping(path = "/{id}")
	@ResponseBody 
	public ResponseEntity<?> findOne(@PathVariable("id") int id) {
		User user = userService.findById(id);
		
		if (user == null) return ResponseEntity.badRequest().build();
				
		return ResponseEntity.ok(userService.findById(id));
	}
}
