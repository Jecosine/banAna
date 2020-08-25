/*
 * @Date: 2020-07-25 18:27:05
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-07-25 18:37:24
 * @FilePath: \banana\src\main\java\swu\smxy\banana\dao\sauidhauisdbas.java
 */
package com.wpw.mybatisbatchoperation.mapper;

import com.wpw.mybatisbatchoperation.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.text.MessageFormat;
import java.util.List;

/** * @author wpw */
@Mapper
@Repositorypublic
interface UserMapper {
    /** * 保存用户信息 * * @param user 用户信息 * @return 自增主键 */
    @Insert(value = "insert into user(username,password,age) values(#{userName},#{passWord},#{age})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(User user);

    /** * 根据用户id删除用户信息 * * @param id 用户id * @return 是否删除成功 */
    @Delete(value = "delete from user where id=#{id}")
    boolean delete(Integer id);

    /** * 根据用户id进行用户信息的更新 * * @param user 用户信息 * @return 是否更新成功 */
    @Update(value = "update user set username=#{userName},password=#{passWord} where id=#{id}")
    boolean update(User user);

    /**
     * * 根据用户名和密码进行查找 * * @param userName 用户名 * @param passWord 密码 * @return 用户信息
     */
    @Results(value = { @Result(property = "id", column = "id"), @Result(property = "userName", column = "username"),
            @Result(property = "passWord", column = "password"), @Result(property = "age", column = "age") })
    @Select(value = "select * from user where username=#{userName} and password=#{passWord}")
    User selectOne(String userName, String passWord);

    /** * 根据用户名称查询用户列表信息 * * @param userName 用户名称 * @return 用户列表 */
    @Results(value = { @Result(property = "id", column = "id"), @Result(property = "userName", column = "username"),
            @Result(property = "passWord", column = "password"), @Result(property = "age", column = "age") })
    @Select(value = "select * from user where username like #{userName}")
    List<User> selectList(String userName);

    /** * 批量增加数据 * * @param userList 用户列表信息 * @return 是否保存成功 */
    @InsertProvider(type = UserSqlProvider.class, method = "batchInsert")
    int batchInsert(@Param(value = "userList") List<User> userList);

    /** * 批量删除用户信息 * * @param userList 用户列表信息 * @return 是否删除成功 */
    @DeleteProvider(type = UserSqlProvider.class, method = "batchDelete")
    boolean batchDelete(@Param(value = "userList") List<User> userList);

    /** * 批量更新 * * @param userList 用户列表信息 * @return 是否更新成功 */
    @UpdateProvider(type = UserSqlProvider.class, method = "batchUpdate")
    boolean batchUpdate(@Param(value = "userList") List<User> userList);

    /** * 批量查询 * * @param userList 用户列表 * @return 用户列表信息 */
    @Results(value = { @Result(property = "id", column = "id"), @Result(property = "userName", column = "username"),
            @Result(property = "passWord", column = "password"), @Result(property = "age", column = "age") })
    @SelectProvider(type = UserSqlProvider.class, method = "batchList")
    List<User> batchList(@Param(value = "userList") List<User> userList);

    class UserSqlProvider {
        /** * 批量增加 * * @param userList 用户列表 * @return str字符串 */
        public String batchInsert(@Param(value = "userList") List<User> userList) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("insert into user(username,password,age)values");
            String message = "(''{0}'',''{1}'',{2})";
            int i = 1;
            for (User u : userList) {
                String format = MessageFormat.format(message, u.getUserName(), u.getPassWord(), u.getAge());
                stringBuilder.append(format);
                if (i == userList.size()) {
                    break;
                }
                stringBuilder.append(",");
                i++;
            }
            return stringBuilder.toString();
        }

        /** * 批量删除 * * @param userList 用户列表信息 * @return str字符串 */
        public String batchDelete(@Param(value = "userList") List<User> userList) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("delete from user where id in(");
            int i = 1;
            for (User u : userList) {
                stringBuilder.append(u.getId());
                if (i == userList.size()) {
                    break;
                }
                stringBuilder.append(",");
                i++;
            }
            stringBuilder.append(")");
            return stringBuilder.toString();
        }

        /** * 批量更新 * * @param userList 用户列表 * @return str字符串 */
        public String batchUpdate(@Param(value = "userList") List<User> userList) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("insert into user(id,name,password,age) values");
            String message = "{0},''{1}'',''{2}'',{3}";
            int i = 1;
            for (User u : userList) {
                String format = MessageFormat.format(message, u.getId(), u.getUserName(), u.getPassWord(), u.getAge());
                stringBuilder.append(format);
                if (i == userList.size()) {
                    break;
                }
                stringBuilder.append(",");
                i++;
                stringBuilder.append(
                        "on duplicate key update id=values(id),username=values(username),password=values(password),age=values(age)");
            }
            return stringBuilder.toString();
        }

        /** * 批量查询 * * @param userList 用户列表信息 * @return str字符串 */
        public String batchList(@Param(value = "userList") List<User> userList) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("select * from user where id in(");
            int i = 1;
            for (User u : userList) {
                stringBuilder.append(u.getId());
                if (i == userList.size()) {
                    break;
                }
                stringBuilder.append(",");
                i++;
            }
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }
}