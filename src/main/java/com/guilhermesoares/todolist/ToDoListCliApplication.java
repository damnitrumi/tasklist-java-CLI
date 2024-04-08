package com.guilhermesoares.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import com.guilhermesoares.todolist.controller.TodoListCliController;

@SpringBootApplication
public class ToDoListCliApplication {

	@Autowired
	private TodoListCliController todoListCliController;

	public static void main(String[] args) {
		SpringApplication.run(ToDoListCliApplication.class, args);

	}

    @Bean
    @Order(2)
    CommandLineRunner commandLineRunner() {
		return args -> todoListCliController.runCli();
	}
}
