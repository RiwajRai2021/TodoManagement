package com.project.todo_management.service;

import com.project.todo_management.dto.TodoDto;

public interface TodoService {

    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodo(Long id);

}
