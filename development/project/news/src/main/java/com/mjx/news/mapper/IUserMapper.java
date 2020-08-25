package com.mjx.news.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.mjx.news.entity.*;

public interface IUserMapper {
  @Insert("insert into user(uid, realname, email, role_id, password, phone) values (#{uid}, #{realname}, #{email}, #{role_id}, #{password}, #{phone})")
  public int addUser(User user);
  @Delete("delete from user where id=#{id}")
  public int deleteById(String id);
  @Update("update user set realname=#{realname}, email=#{email}, role_id=#{role_id}, password=#{password}, phone=#{phone} where uid=#{uid}")
  public int updateUser(User user);
  @Select("select * from user where uid=#{id}")
  public User getUserById(String id);
  @Select("select username from user where uid=#{id}")
  public String getUsernameById(String id);
  @Select("select * from user where email=#{email}")
  public User getUserByEmail(String email);
  // get all user
  @Select("select * from user")
  public List<User> getAllUsers();
  // get users by role
  @Select("select * from user where role_id=#{id}")
  public List<User> getUserByRole(int id);

}