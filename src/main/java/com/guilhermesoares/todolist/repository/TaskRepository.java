package com.guilhermesoares.todolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilhermesoares.todolist.entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
	List<Task> findAllByTaskOwnerId(Long id);
}
