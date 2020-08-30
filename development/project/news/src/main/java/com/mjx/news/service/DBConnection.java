package com.mjx.news.service;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.Null;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.xml.crypto.Data;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
// import com.fasterxml.jackson.annotation.JsonTypeInfo.None;
import com.mjx.news.entity.*;
import com.mjx.news.mapper.*;
public class DBConnection {
  private static SqlSessionFactory sqlSessionFactory;
  private static Reader reader;
  static {
    try {
      reader = Resources.getResourceAsReader("Configuration.xml");
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  // users
  public static User getUserById(String id) throws IOException {
    // SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    SqlSession openSession = sqlSessionFactory.openSession();
    User user = null;
    try {
      IUserMapper mapper = openSession.getMapper(IUserMapper.class);
      user = mapper.getUserById(id);
      return user;
    } finally {
        openSession.close();
    }
  }
  public static User getUserByEmail(String email) throws IOException {
    // SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    SqlSession openSession = sqlSessionFactory.openSession();
    User user = null;
    try {
      IUserMapper mapper = openSession.getMapper(IUserMapper.class);
      user = mapper.getUserByEmail(email);
      return user;
    } finally {
        openSession.close();
    }
  }
  public static List<User> getUsersByRole(Integer id) throws IOException {
    // SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    SqlSession openSession = sqlSessionFactory.openSession();
    List<User> users = null;
    try {
      IUserMapper mapper = openSession.getMapper(IUserMapper.class);
      users = mapper.getUserByRole(id);
      return users;
    } finally {
        openSession.close();
    }
  }
  public static List<User> getAllUsers() throws IOException {
    // SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    SqlSession openSession = sqlSessionFactory.openSession();
    List<User> users = null;
    try {
      IUserMapper mapper = openSession.getMapper(IUserMapper.class);
      users = mapper.getAllUsers();
      return users;
    } finally {
        openSession.close();
    }
  }

  public static int addUser(User user) throws IOException {
    SqlSession openSession = sqlSessionFactory.openSession();
    // List<User> users = null;
    try {
      IUserMapper mapper = openSession.getMapper(IUserMapper.class);
      return mapper.addUser(user);
    } finally {
        openSession.commit();
        openSession.close();
    }
  }


  // passages
  public static Passage getPassageById(String id) throws IOException {
    // SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    SqlSession openSession = sqlSessionFactory.openSession();
    Passage passage = null;
    try {
      IPassageMapper mapper = openSession.getMapper(IPassageMapper.class);
      passage = mapper.getPassageById(id);
      return passage;
    } finally {
        openSession.close();
    }
  }
  public static List<Passage> getPassagesByPart(Integer id) throws IOException {
    // SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    SqlSession openSession = sqlSessionFactory.openSession();
    List<Passage> passages = null;
    try {
      IPassageMapper mapper = openSession.getMapper(IPassageMapper.class);
      passages = mapper.getPassageByPart(id);
      return passages;
    } finally {
        openSession.close();
    }
  }
  public static List<Passage> getAllPassages() throws IOException {
    // SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    SqlSession openSession = sqlSessionFactory.openSession();
    List<Passage> passages = null;
    try {
      IPassageMapper mapper = openSession.getMapper(IPassageMapper.class);
      passages = mapper.getAllPassages();
      return passages;
    } finally {
        openSession.close();
    }
  }
  public static Passage getInfoById(String id) throws IOException {
    // SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    SqlSession openSession = sqlSessionFactory.openSession();
    Passage passage = null;
    try {
      IPassageMapper mapper = openSession.getMapper(IPassageMapper.class);
      passage = mapper.getInfoById(id);
      return passage;
    } finally {
        openSession.close();
    }
  }
  public static List<Passage> getAllInfos() throws IOException {
    // SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    SqlSession openSession = sqlSessionFactory.openSession();
    List<Passage> passages = null;
    try {
      IPassageMapper mapper = openSession.getMapper(IPassageMapper.class);
      passages = mapper.getAllInfos();
      return passages;
    } finally {
        openSession.close();
    }
  }
  public static List<DataFrame> getData(String id) throws IOException {
    // SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    SqlSession openSession = sqlSessionFactory.openSession();
    List<DataFrame> data;
    try {
      IPassageMapper mapper = openSession.getMapper(IPassageMapper.class);
      System.out.print(id);
      data = mapper.getData(id);
      return data;
    } finally {
        openSession.close();
    }
  }
  // todos
  public static TodoItem getTodoItemById(Integer id) throws IOException {
    // SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    SqlSession openSession = sqlSessionFactory.openSession();
    TodoItem todo = null;
    try {
      ITodoMapper mapper = openSession.getMapper(ITodoMapper.class);
      todo = mapper.getTodoItemById(id);
      return todo;
    } finally {
        openSession.close();
    }
  }
  public static List<TodoItem> getTodoItemsByTag(Integer id) throws IOException {
    // SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    SqlSession openSession = sqlSessionFactory.openSession();
    List<TodoItem> todos = null;
    try {
      ITodoMapper mapper = openSession.getMapper(ITodoMapper.class);
      todos = mapper.getTodoItemsByTag(id);
      return todos;
    } finally {
        openSession.close();
    }
  }
  public static List<TodoItem> getTodoItemsByState(Integer id) throws IOException {
    // SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    SqlSession openSession = sqlSessionFactory.openSession();
    List<TodoItem> todos = null;
    try {
      ITodoMapper mapper = openSession.getMapper(ITodoMapper.class);
      todos = mapper.getTodoItemsByState(id);
      return todos;
    } finally {
        openSession.close();
    }
  }
  public static List<TodoItem> getAllTodoItems() throws IOException {
    // SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
    SqlSession openSession = sqlSessionFactory.openSession();
    List<TodoItem> todos = null;
    try {
      ITodoMapper mapper = openSession.getMapper(ITodoMapper.class);
      todos = mapper.getAllTodoItems();
      return todos;
    } finally {
        openSession.close();
    }
  }

  public static int addTodoItem(TodoItem todo) throws IOException {
    SqlSession openSession = sqlSessionFactory.openSession();
    // List<Todo> todos = null;
    try {
      ITodoMapper mapper = openSession.getMapper(ITodoMapper.class);
      return mapper.addTodoItem(todo);
    } finally {
        openSession.commit();
        openSession.close();
    }
  }

}