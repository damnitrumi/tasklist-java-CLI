package com.guilhermesoares.todolist.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilhermesoares.todolist.entities.User;
import com.guilhermesoares.todolist.repository.UserRepository;
import com.guilhermesoares.todolist.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> user = repository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
}
