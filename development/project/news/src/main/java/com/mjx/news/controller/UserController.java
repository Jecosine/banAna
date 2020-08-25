package com.mjx.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

@RequestMapping("/user")
public class UserController {
  @GetMapping("/getById")
  public User getUserById(@RequestParam String id) throws IOException {
    User user = DBConnection.getUserById(id);
		return user;
	}
  @GetMapping("/getByRole")
  public List<User> getUsersByRole(@RequestParam Integer id) throws IOException {
    List<User> users = DBConnection.getUsersByRole(id);
		return users;
  }
  @GetMapping("/getAll")
  public List<User> getUsersByRole() throws IOException {
    List<User> users = DBConnection.getAllUsers();
		return users;
  }
  @PostMapping(value="/add")
  // @ResponseBody 
  public User addUser(@RequestBody User user) throws IOException{
      //TODO: process POST request\
      int a = DBConnection.addUser(user);
      System.out.println(user.getRealname());
      return user;
  }

  @PostMapping(value="/deleteById")
  public int delUser(@RequestParam String id) throws IOException{
    return 1;
  }


  @ResponseBody
  @PostMapping(value="/loginService")
  public ResponseDataPack login(@RequestBody RequestDataPack dp, HttpServletRequest request, HttpServletResponse response) throws IOException {
    ResponseDataPack res = new ResponseDataPack();
    String email = (String)dp.getEmail();
    String password = (String)dp.getPassword();
    System.out.println(dp.getPassword());
    User user = DBConnection.getUserByEmail(email);
    res.setStatus(-1);
    res.setMessage("Login fail. Check your password or email.");
    if(user == null){
      return res;
      // response.sendRedirect("/adminlogin");      
    }

    if (user.getPassword().equals(password)) {
      request.getSession().setAttribute("user", user);
      res.setStatus(0);
      res.setMessage("Success");
      return res;
    } else {
      System.out.println(user.getPassword() + " " + password);

      return res;
    }
  } 

}