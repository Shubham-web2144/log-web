package com.lwp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lwp.model.User;
import com.lwp.repo.UserRepo;

@RestController
public class MainRest {
	
	@Autowired
	private UserRepo repo;
	
	
	
	@PostMapping("/post")
	public User postUser(@RequestBody() User user) {
		return repo.save(user);
	}
	
}
