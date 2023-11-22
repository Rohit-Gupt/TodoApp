package com.mydata.dao;

import java.util.List;

import com.mydata.model.Todo;

public interface TodoDao {
	public List<Todo> viewAllTodo();
	public int saveTodo(Todo t);
	public String deleteTodo(String s);
	public Todo viewTodoByTitle(String s);
	public String update(String s,String s1);
}
