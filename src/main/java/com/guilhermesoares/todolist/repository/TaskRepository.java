package com.guilhermesoares.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilhermesoares.todolist.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
}
