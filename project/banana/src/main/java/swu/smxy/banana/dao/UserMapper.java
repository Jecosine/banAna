/*
 * @Date: 2020-08-22 00:35:29
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-22 11:50:04
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

@Component
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user limit #{count}")
    public List<User> getSome(int count);
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
     * @description: get by username and password(for login feature)
     * @param id - user id
     * @param password - user password
     * @return: User with specified id and password
     */
    @Select("select * from user where userName=#{userName} and password=#{password}")
    public User getByNameAndPassword(String userName, String password);
    /**
     * @description: get by name
     * @param name - user name
     * @return: User with specified name
     */
    @Select("select * from user where userName=#{userName}")
    public User getByName(String userName);
    // @Update("update user set ")
    // public int update(User user);
    	
    @Insert("insert into user values(#{userId}, #{userName}, #{gender}, #{password},#{qq},#{email}, #{phone}, #{avatarUrl})")
    public int addUser(User user);
    @Delete("delete from user where userId=#{userId}")
    public int deleteById(String userId);

    @Delete("delete from user where userId=#{userId}")
    public int delete(User user);
    
    @Update("update user set userName=#{userName},gender=#{gender},qq=#{qq},email=#{email},phone=#{phone}, avatarUrl=#{avatarUrl} where userId=#{userId}")
    public int update(User user);
}