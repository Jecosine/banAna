/*
 * @Date: 2020-07-25 17:00:29
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-21 20:29:21
 * @FilePath: \banana\src\main\java\swu\smxy\banana\service\UserService.java
 */
package swu.smxy.banana.service;

import java.util.List;
import org.springframework.stereotype.Service;
import swu.smxy.banana.entity.User;

@Service
public interface UserService
{

    /**
     * @description: get all user
     * @param <empty>
     * @return: list of User instances
     */
    public List<User> getAllUsers();

    /**
     * @description: get user instance by user id
     * @param userId
     *                   String
     * @return: User instance
     */
    public User getUserById(String userId);

}