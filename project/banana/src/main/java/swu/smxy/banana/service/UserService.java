/*
 * @Date: 2020-07-25 17:00:29
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-22 23:42:16
 * @FilePath: \banana\src\main\java\swu\smxy\banana\service\UserService.java
 */
package swu.smxy.banana.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import swu.smxy.banana.dao.UserMapper;
import swu.smxy.banana.entity.ResponseType;
import swu.smxy.banana.entity.User;

@Service
public class UserService extends BaseService<User, UserMapper>
{
    private UserMapper mapper;
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;
    public ResponseType<User> loginService(String userName, String password)
    {
        mapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        User user = mapper.getByNameAndPassword(userName, password);
        int status = 0;
        String message = "Login Successfully";
        if(user == null)
        {
            status = -1;
            message = "Login failed, please check you username or password";
            System.out.println("Login failed");
        }
        ResponseType<User> response = new ResponseType<User>();
        response.setData(user);
        response.setStatus(status);
        response.setMessage(message);
        return response;

    }
}