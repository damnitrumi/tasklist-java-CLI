package com.guilhermesoares.todolist.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.guilhermesoares.todolist.entities.Task;
import com.guilhermesoares.todolist.entities.User;
import com.guilhermesoares.todolist.entities.enums.TaskPriority;
import com.guilhermesoares.todolist.entities.enums.TaskStatus;
import com.guilhermesoares.todolist.repository.TaskRepository;
import com.guilhermesoares.todolist.repository.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TaskRepository taskRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User p1 = new User(null, "Guilherme");
		userRepository.save(p1);
		
		Task t1 = new Task(null, "Tarefa teste", TaskPriority.MEDIUM, TaskStatus.PENDING, null, p1);
		Task t2 = new Task(null, "Tarefa teste 2 ", TaskPriority.HIGH, TaskStatus.IN_PROGRESS, null, p1);
		taskRepository.saveAll(Arrays.asList(t1, t2));
		
		p1.getTasks().addAll(Arrays.asList(t1, t2));
		
		
		System.out.println(p1.getTasks());
	}

}
