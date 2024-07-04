package com.project.todo_management.controller;

import com.project.todo_management.dto.TodoDto;
import com.project.todo_management.service.TodoService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/todos")
public class TodoController {

    private TodoService todoService;

    // Build Add Todo REST API


    @PostMapping
    public ResponseEntity<TodoDto>addTodo(@RequestBody TodoDto todoDto){ //@RequestBody is add to convert the
        // JSON object into TodoDto java object

       TodoDto savedTodo = todoService.addTodo(todoDto);
       return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);

    }

    //Build Get Todo Rest API
    @GetMapping("{id}")
    public ResponseEntity<TodoDto>getTodo(@PathVariable("id") Long todoId){
        TodoDto todoDto = todoService.getTodo(todoId);
        return new ResponseEntity<>(todoDto, HttpStatus.OK);

    }



}
