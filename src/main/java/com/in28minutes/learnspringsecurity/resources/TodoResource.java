package com.in28minutes.learnspringsecurity.resources;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {
	private Logger logger= LoggerFactory.getLogger(getClass());
	@GetMapping("/todos")
	public List<Todo> retrieveAllTodos() {

		return todoList();
	}

	private static List<Todo> todoList() {
		return List.of(new Todo("tienvua", "Learn AWS"),
				new Todo("tienvua", "Learn C#"),
				new Todo("tienvua", "Learn Java"));
	}

	@GetMapping("/users/{username}/todos")
	public Todo retrieveTodoForSpecificUser(@PathVariable String username) {

		return todoList().get(0);
	}
	@PostMapping("/users/{username}/todos")
	public void createTodoForSpecificUser(@PathVariable String username, @RequestBody Todo todo) {
		logger.info("Create {} for {}",username,todo);
		//todoList().add(todo);

	}


}

record Todo(String username,String description){}
