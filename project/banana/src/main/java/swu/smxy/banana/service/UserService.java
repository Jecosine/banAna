/*
 * @Date: 2020-07-25 17:00:29
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-02 18:44:47
 * @FilePath: \banana\src\main\java\swu\smxy\banana\service\UserService.java
 */
package swu.smxy.banana.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
        if (user == null)
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

    public ResponseType<User> userInfoService(String id)
    {
        mapper = sqlSessionFactory.openSession().getMapper(UserMapper.class);
        User user = mapper.getById(id);
        int status = 0;
        String message = "Search Successfully";
        if (user == null)
        {
            status = -1;
            message = "User not exsists, please check your id";
            System.out.println("Search failed");
        }
        ResponseType<User> response = new ResponseType<User>();
        response.setData(user);
        response.setStatus(status);
        response.setMessage(message);
        return response;
    }
    @Transactional
    public ResponseType<User> updateUserInfoService(User user)
    {
        ResponseType<User> response = new ResponseType<User>();
        SqlSession session = sqlSessionFactory.openSession();
        mapper = session.getMapper(UserMapper.class);
        int status = 0;
        String message = "Update Successfully";
        // TODO 这里最好加一个和原来得user比较看是否更改了 其实这个前端做很麻烦，后台更好困了 2分钟内        
        try {
            mapper.update(user);
        } catch (Exception e) {
            status = -1;
            message = "Invalid modify:" + e.getMessage();
            System.out.println("status: " + status + " " + message + "\n" + user);
            response.setStatus(status);
            response.setMessage(message);
            return response;
        } finally {
            session.commit();
            session.close();
        }
        // System.out.println("status: " + status + "\n" + user);
        response.setData(user);
        response.setStatus(status);
        response.setMessage(message);
        return response;
    }
}