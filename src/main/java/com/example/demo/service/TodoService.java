package com.example.demo.service;

import java.util.List;
import com.example.demo.dto.TodoDTO;

public interface TodoService {
	
//	todo 조회 메소드
    List<TodoDTO> getAllTodos();
    
//  todo 생성 메소드
    void addTodo(TodoDTO todo);
    
//  todo 수정 메소드
    void updateTodo(int id);
    
//  todo 삭제 메소드
    void deleteTodo(int id);
}