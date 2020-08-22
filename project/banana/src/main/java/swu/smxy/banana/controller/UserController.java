/*
 * @Date: 2020-08-22 01:37:06
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-22 23:37:31
 */
package swu.smxy.banana.controller;

import java.io.IOException;

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

@Controller
@RequestMapping("/user")
public class UserController extends BaseController<UserService>
{
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/loginService", method = RequestMethod.POST)
    @ResponseBody
    public void loginService(@RequestParam String userName, @RequestParam String password, HttpServletRequest request,
            HttpServletResponse response) throws IOException
    {
        User user = userService.loginService(userName, password);
        if (user == null)
        {
            response.sendRedirect("/user/login");
            // return "";
        }
        else
        {
            request.getSession().setAttribute("user_auth", user);
        }
        // return "";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    // @Controller
    public String login(Model model, HttpServletRequest request, HttpServletResponse response)
    {
        return "login.html";
    }

    @RequestMapping(value="/logout", method=RequestMethod.GET)
    public void requestMethodName(HttpServletRequest request,
    HttpServletResponse response) throws IOException 
    {
        request.getSession().removeAttribute("user_auth");
        response.sendRedirect("/user/login");
    }
    
}