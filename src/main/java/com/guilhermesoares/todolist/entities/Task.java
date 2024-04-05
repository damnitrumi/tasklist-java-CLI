package com.guilhermesoares.todolist.entities;

import java.time.Instant;

import com.guilhermesoares.todolist.entities.enums.TaskPriority;
import com.guilhermesoares.todolist.entities.enums.TaskStatus;

public class Task {
	
	private String description;
	private Instant createdAt;
	private Instant finishedAt;
	private TaskPriority taskPriority;
	private TaskStatus taskStatus;
}
