package com.example.Todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Todo.entity.Todo;
import com.example.Todo.repository.TodoRepo;

@Service
public class TodoService {

	@Autowired
	TodoRepo todoRepo;
	
	public List<Todo> getAllTodos() {
		return todoRepo.findAll();
	}
	
	public void addTodo(Todo todo) {
		todoRepo.save(todo);
	}
	
	public void deleteTodo(int id) {
		todoRepo.deleteById(id);
	}
	public Optional<Todo> getTodo(int id) {
		return todoRepo.findById(id);
	}
	
	public void change(Todo todo) {
		todo.setStatus(!todo.isStatus());
		System.out.println("This is statussssssssssssss"+todo.isStatus());
		todoRepo.save(todo);
	}
}
