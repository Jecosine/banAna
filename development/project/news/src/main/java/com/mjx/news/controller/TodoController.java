package com.mjx.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.ui.Model;
import com.mjx.news.repository.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mjx.news.mapper.*;
import com.mjx.news.entity.*;
import com.mjx.news.service.*;
import org.springframework.web.bind.annotation.RequestBody;

@RestController

@RequestMapping("/todo")
public class TodoController {
  @GetMapping("/getById")
  public TodoItem getTodoItemById(@RequestParam Integer id) throws IOException {
    TodoItem user = DBConnection.getTodoItemById(id);
		return user;
	}
  @GetMapping("/getByState")
  public List<TodoItem> getTodoItemsByRole(@RequestParam int id) throws IOException {
    List<TodoItem> users = DBConnection.getTodoItemsByState(id);
		return users;
  }
  @GetMapping("/getAll")
  public List<TodoItem> getTodoItemsByRole() throws IOException {
    List<TodoItem> users = DBConnection.getAllTodoItems();
		return users;
  }
  @PostMapping(value="/add")
  // @ResponseBody 
  public TodoItem addTodoItem(@RequestBody TodoItem todo) throws IOException{
      //TODO: process POST request\
      int a = DBConnection.addTodoItem(todo);
      return todo;
  }

  @PostMapping(value="/delete")
  public int delTodoItem(@RequestParam Integer id) throws IOException{
    return 1;
  } 

}