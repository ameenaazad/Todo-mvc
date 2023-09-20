package com.example.Todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Todo.entity.Todo;
import com.example.Todo.service.TodoService;


@Controller
public class TodoController {
	
	@Autowired
	TodoService todoService;
	
	@GetMapping("/")
	public String home(Model m){
		List<Todo> todo = todoService.getAllTodos();
		m.addAttribute("todos", todo);
		return "index";
	}
	
	@PostMapping("/addTask")
	public String add(@ModelAttribute Todo t) {
		if(t.getDescription().trim()!="") {
			todoService.addTodo(t);
		}
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
		public String remove(@PathVariable int id) {
			todoService.deleteTodo(id);
			return "redirect:/";
	}
	
	@GetMapping("/changeStatus/{id}")
	public String changeStatus(@PathVariable int id) {
		Todo todo = todoService.getTodo(id)
				.orElseThrow(() -> new RuntimeException("Employee not found"));
		todoService.change(todo);
		System.out.println("This is todooooooo"+todo);
		return "redirect:/";
		
		
	}
}
