package com.example.Todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Todo.entity.Todo;

public interface TodoRepo extends JpaRepository<Todo, Integer>{

}
