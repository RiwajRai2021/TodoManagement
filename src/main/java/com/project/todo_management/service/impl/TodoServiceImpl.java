package com.project.todo_management.service.impl;

import com.project.todo_management.dto.TodoDto;
import com.project.todo_management.entity.Todo;
import com.project.todo_management.exception.ResourceNotFoundException;
import com.project.todo_management.repository.TodoRepository;
import com.project.todo_management.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor

public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    private ModelMapper modelMapper;


    @Override
    public TodoDto addTodo(TodoDto todoDto) {

        // convert TodoDto into Todo Jpa entity

//        Todo todo = new Todo();
//        todo.setTitle(todoDto.getTitle());
//        todo.setDescription(todoDto.getDescription());
//        todo.setCompleted(todoDto.isCompleted());

        Todo todo = modelMapper.map(todoDto, Todo.class);

        // Todo Jpa entity into db
         Todo savedTodo = todoRepository.save(todo);

         //Convert saved Todo Jpa entity object into TodoDto object
//        TodoDto savedTodoDto = new TodoDto();
//        savedTodoDto.setId(savedTodo.getId());
//        savedTodoDto.setTitle(savedTodo.getTitle());
//        savedTodoDto.setCompleted(savedTodo.isCompleted());

        TodoDto savedTodoDto = modelMapper.map(savedTodo, TodoDto.class);

        return savedTodoDto;
    }

    @Override
    public TodoDto getTodo(Long id) {

        Todo todo = todoRepository.findById(id).
                orElseThrow(() ->new ResourceNotFoundException("Todo not found with id :" + id));

        return modelMapper.map(todo,TodoDto.class);
    }
}
