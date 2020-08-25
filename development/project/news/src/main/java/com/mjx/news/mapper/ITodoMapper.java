package com.mjx.news.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.mjx.news.entity.*;

public interface ITodoMapper {
  @Insert("insert into todo(todo_id, uid, title, start_date, end_date, tag, content) values (#{todo_id}, #{uid}, #{title}, #{startDate}, #{endDate}, #{tag}, #{content})")
  public int addTodoItem(TodoItem todo);
  @Delete("delete from todo where id=#{id}")
  public int deleteById(Integer id);
  @Update("update todo set todo_id=#{todo_id}, title=#{titile}, start_date=#{start_date}, end_date=#{end_date}, tag=#{tag}, content=#{content} where todo_id=#{todo_id}")
  public int updateTodoItem(TodoItem todo);
  @Select("select * from todo where todo_id=#{id}")
  public TodoItem getTodoItemById(Integer id);
  // get all todo
  @Select("select * from todo")
  public List<TodoItem> getAllTodoItems();
  // get todos by tag
  @Select("select * from todo where tag=#{tag}")
  public List<TodoItem> getTodoItemsByTag(int tag);
  // get todos by state
  @Select("select * from todo where state=#{state}")
  public List<TodoItem> getTodoItemsByState(int state);
}