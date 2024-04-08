package com.guilhermesoares.todolist.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.guilhermesoares.todolist.entities.Task;
import com.guilhermesoares.todolist.entities.User;
import com.guilhermesoares.todolist.entities.enums.TaskPriority;
import com.guilhermesoares.todolist.services.TaskService;
import com.guilhermesoares.todolist.services.UserService;

@Controller
public class TodoListCliController {

	@Autowired
	TaskService taskService;

	@Autowired
	UserService userService;

	public void runCli() {
		try (Scanner sc = new Scanner(System.in)) {

			String name;
			User user;
			Task task;
			Long id;
			String notes = null;
			String priority;
			TaskPriority taskPriority;
			Boolean running = true;

			while (running) {
				System.out.println("Choose the desired option");
				System.out.println("1: Add new User");
				System.out.println("2: Add new Task");
				System.out.println("3: Change Task Priority");

				String option = sc.next();

				switch (option) {
				case "1":
					System.out.println("Whats the name of the user");
					sc.nextLine();
					name = sc.nextLine();
					user = new User(null, name);
					userService.insert(user);
					break;
					
				case "2":
					System.out.println("First of all, what is the ID of your User?");
					id = sc.nextLong();
					user = userService.findById(id);
					System.out.println(user);

					System.out.println("What is the description of your task?");
					sc.nextLine();
					String desc = sc.nextLine();

					System.out.println("What is the priority of your task? [Choose between: Low, Medium, High]");
					priority = sc.nextLine().toUpperCase();
					taskPriority = TaskPriority.valueOf(priority);

					System.out.println("Do you have any aditional notes? ['y' or 'n']");
					char response = sc.next().charAt(0);
					if (response == 'y') {
						System.out.println("Type in your aditional notes and press enter");
						sc.nextLine();
						notes = sc.nextLine();
					}

					task = new Task(null, desc, taskPriority, notes, user);

					taskService.insert(task);
					
					user.getTasks().add(task);
					break;
					
				case "3":
					System.out.println("First of all i need to know what is the id of your User");
					id = sc.nextLong();
					user = userService.findById(id);
					
					System.out.println("I need to know the ID of the task you to change priority");
					id = sc.nextLong();
					task = taskService.findById(id);
					
					System.out.println("What is the priority of your task? [Choose between: Low, Medium, High]");
					sc.nextLine();
					priority = sc.nextLine().toUpperCase();
					taskPriority = TaskPriority.valueOf(priority);
					task.setTaskPriority(taskPriority);
					taskService.update(task);
					break;
				default:
					System.out.println("Selected option does not exist!");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
