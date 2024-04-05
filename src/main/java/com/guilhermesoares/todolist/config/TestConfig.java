package com.guilhermesoares.todolist.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.guilhermesoares.todolist.entities.User;
import com.guilhermesoares.todolist.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User p1 = new User(null, "Guilherme");
		
		userRepository.save(p1);
	}

}
