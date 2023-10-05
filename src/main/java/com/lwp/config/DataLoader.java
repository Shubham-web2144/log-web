 package com.lwp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.lwp.model.User;
import com.lwp.repo.UserRepo;

@Configuration
public class DataLoader implements CommandLineRunner {
	@Autowired
	private UserRepo userRepo;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername("admin");
		user.setPassword("admin");
		userRepo.save(user);
	}

}
