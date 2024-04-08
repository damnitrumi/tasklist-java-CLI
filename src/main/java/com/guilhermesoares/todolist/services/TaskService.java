package com.guilhermesoares.todolist.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilhermesoares.todolist.entities.Task;
import com.guilhermesoares.todolist.repository.TaskRepository;
import com.guilhermesoares.todolist.services.exceptions.ResourceNotFoundException;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository repository;
	
	public Task findById(Long id) {
		Optional<Task> task = repository.findById(id);
		return task.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public void insert(Task task) {
		repository.save(task);
	}
	
	public Task update(Task task) {
		return repository.save(task);
	}
	
	public void finishTask(Long id) {
		Task task = findById(id);
		task.finishTask();
		repository.save(task);
	}
}
