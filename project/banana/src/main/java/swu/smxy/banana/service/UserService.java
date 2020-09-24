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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.DigestUtils;

import swu.smxy.banana.dao.UserMapper;
import swu.smxy.banana.entity.ResponseType;
import swu.smxy.banana.entity.User;
import swu.smxy.banana.util.UuidGenerator;

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
        SqlSession session = sqlSessionFactory.openSession();
        mapper = session.getMapper(UserMapper.class);
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
        session.clearCache();
        session.close();
        return response;
    }
    @Transactional
    public ResponseType<User> updateUserInfoService(User user)
    {
        ResponseType<User> response = new ResponseType<User>();
        SqlSession session = sqlSessionFactory.openSession();
        mapper = session.getMapper(UserMapper.class);
        int status = 0;
        String message = "Update Successfully!";
        try {
            mapper.update(user);
            session.commit();

        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            status = -1;
            message = "Invalid modify:" + e.getMessage();
            System.out.println("status: " + status + " " + message + "\n" + user);
            response.setStatus(status);
            response.setMessage(message);
            return response;
        }

        // session.clearCache();
        System.out.println("status: " + status + "\n" + user);
        response.setData(user);
        response.setStatus(status);
        response.setMessage(message);
        return response;
    }
    @Transactional
    public ResponseType<User> addUser(User user)
    {
    	ResponseType<User> response = new ResponseType<User>();
        SqlSession session = sqlSessionFactory.openSession();
        mapper = session.getMapper(UserMapper.class);
        try {
        	user.setUserId(UuidGenerator.getUuid(10));
        	user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
            mapper.addUser(user);
            session.commit();

        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        	System.out.println("failed to add" + e.getMessage());
        	response.setStatus(-1);
        	return response;
        }
        response.setMessage("successful");
        response.setData(user);
        return response;
    }
    @Transactional
	public void setSaler(User user) {
        user.setIsSaler(1);
        SqlSession session = sqlSessionFactory.openSession();
        mapper = session.getMapper(UserMapper.class);
        try {
            mapper.update(user);
            session.commit();
        } catch (Exception e) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        	System.out.println("failed to add" + e.getMessage());
        }
	}
}