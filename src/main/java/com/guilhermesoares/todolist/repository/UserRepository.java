package com.guilhermesoares.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilhermesoares.todolist.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
