package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.TodoDTO;

public interface TodoService {
    List<TodoDTO> getAllTodos();
    void addTodo(TodoDTO todo);
    void updateTodoStatus(int id);
    void deleteTodoById(int id);
}