/*
 * @Date: 2020-07-25 17:00:29
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-07-25 17:05:07
 * @FilePath: \banana\src\main\java\swu\smxy\banana\service\UserService.java
 */ 
package swu.smxy.banana.service;
import java.util.List;
import swu.smxy.banana.entity.User;

public interface UserService {
  
  /**
   * @description: get all user
   * @param <empty>
   * @return: list of User instances
   */  
  public List<User> getAllUsers();

  /**
   * @description: get user instance by user id
   * @param userId String
   * @return: User instance
   */  
  public User getUserById(String userId);

}