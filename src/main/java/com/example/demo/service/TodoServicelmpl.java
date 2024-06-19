package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.dto.TodoDTO;

@Service
public class TodoServicelmpl implements TodoService {

//	할 일 목록을 저장하는 리스트 / 초기값 null
    private List<TodoDTO> todoList = new ArrayList<>();
    
//  todo 조회
    @Override
    public List<TodoDTO> getAllTodos() {
        return todoList;
    }
//  todo 생성
    @Override
    public void addTodo(TodoDTO todo) {
        todo.setId(todoList.size() + 1); // 새로 추가될 todo의 id를 list.size+1로 설정
        todoList.add(todo);
    }
//	todo 수정
    @Override
    public void updateTodo(int id) {
        Optional<TodoDTO> todoOpt = todoList.stream().filter(todo -> todo.getId() == id).findFirst();
        todoOpt.ifPresent(todo -> todo.setDone(!todo.getDone()));
    }
//  todo 삭제
    @Override
    public void deleteTodo(int id) {
        todoList.removeIf(todo -> todo.getId() == id);
    }
}