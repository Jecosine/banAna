/*
 * @Date: 2020-08-22 01:37:06
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-23 00:52:50
 */
package swu.smxy.banana.controller;

import java.io.IOException;
import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import swu.smxy.banana.entity.ResponseType;
import swu.smxy.banana.entity.User;
import swu.smxy.banana.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController<UserService>
{
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/registerService", method = RequestMethod.POST)
    @ResponseBody
    public ResponseType<User> registerService(@RequestBody User user)
    {
    	return userService.addUser(user);
    }
    @RequestMapping(value = "/loginService", method = RequestMethod.POST)
    @ResponseBody
    public ResponseType<User> loginService(@RequestParam String userName, @RequestParam String password,
            HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        ResponseType<User> responseType = userService.loginService(userName, password);
        if (responseType.getStatus() == 0)
        {
            request.getSession().setAttribute("user_auth", responseType.getData());
        }
        return responseType;
    }    

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public void requestMethodName(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        request.getSession().removeAttribute("user_auth");
        response.sendRedirect("/login");
    }
    
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public ResponseType<User> userInfoService(@RequestParam String id,
    		HttpServletRequest request, HttpServletResponse response) throws IOException
    {
    	ResponseType<User> responseType = userService.userInfoService(id);
    	return responseType;
    }
    
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    @ResponseBody
    public ResponseType<User> updateUserInfoService(@RequestBody User user, HttpServletRequest request) throws IOException
    {
        ResponseType<User> responseType = userService.updateUserInfoService(user);
        if(responseType.getStatus() == 0)
        {
            request.getSession().setAttribute("user_auth", responseType.getData());
        }
    	return responseType;
    }
    @RequestMapping(value="/currentinfo", method=RequestMethod.GET)
    public ResponseType<User> requestMethodName(HttpServletRequest request) {
        ResponseType<User> resp = new ResponseType<User>();
        resp.setData((User)request.getSession().getAttribute("user_auth"));
        return resp;
    }
    

}