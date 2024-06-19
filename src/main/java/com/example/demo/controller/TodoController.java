package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.TodoDTO;
import com.example.demo.service.TodoService;

@Controller
public class TodoController {

    @Autowired
    TodoService service;

    @RequestMapping("/todo")
    public String todo(Model model) {
        List<TodoDTO> todoDtoList = service.getAllTodos();
        model.addAttribute("todoList", todoDtoList);
        return "todo";
    }

    @RequestMapping("/")
    public String home() {
        return "redirect:/todo";
    }

    @PostMapping("/todo/create")
    public String createTodo(@RequestParam("todo-desc") String content) {
        TodoDTO newTodo = TodoDTO.builder()
                                  .content(content)
                                  .done(false)
                                  .build();
        service.addTodo(newTodo);
        return "redirect:/todo";
    }

    @PostMapping("/todo/{id}/update")
    public String updateTodo(@PathVariable("id") int id) {
        service.updateTodo(id);
        return "redirect:/todo";
    }

    @PostMapping("/todo/{id}/delete")
    public String deleteTodo(@PathVariable("id") int id) {
        service.deleteTodo(id);
        return "redirect:/todo";
    }
}