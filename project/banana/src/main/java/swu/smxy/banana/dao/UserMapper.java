/*
 * @Date: 2020-08-22 00:35:29
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-22 00:40:08
 */
package swu.smxy.banana.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import swu.smxy.banana.entity.User;

public interface UserMapper extends BaseMapper<User> {
    /**
     * @description:
     * @param {type}
     * @return: list of user instance
     */
    @Select("select * from user")
    public List<User> getAll();

    /**
     * @description: get by id
     * @param id - user id
     * @return: User with specified id
     */
    @Select("select * from user where userId=#{userId}")
    public User getById(String userId);
    /**
     * @description: get by name
     * @param name - user name
     * @return: User with specified name
     */
    @Select("select * from user where userName=#{userName}")
    public User getByName(String userName);
    // @Update("update user set ")
    // public int update(User user);

    @Delete("delete from user where userId=#{userId}")
    public int deleteById(String userId);

    @Delete("delete from user where userId=#{userId}")
    public int delete(User user);
}