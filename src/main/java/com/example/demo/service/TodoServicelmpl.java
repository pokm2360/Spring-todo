package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.TodoDTO;

@Service
public class TodoServicelmpl implements TodoService {

    private List<TodoDTO> todoList = new ArrayList<>();

    @Override
    public List<TodoDTO> getAllTodos() {
        return todoList;
    }

    @Override
    public void addTodo(TodoDTO todo) {
        todo.setId(todoList.size() + 1);
        todoList.add(todo);
    }

    @Override
    public void updateTodoStatus(int id) {
        Optional<TodoDTO> todoOpt = todoList.stream().filter(todo -> todo.getId() == id).findFirst();
        todoOpt.ifPresent(todo -> todo.setDone(!todo.getDone()));
    }

    @Override
    public void deleteTodoById(int id) {
        todoList.removeIf(todo -> todo.getId() == id);
    }
}