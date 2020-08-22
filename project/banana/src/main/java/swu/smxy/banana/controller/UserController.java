/*
 * @Date: 2020-08-22 01:37:06
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-22 23:16:23
 */
package swu.smxy.banana.controller;

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
    public ResponseType<User> loginService(@RequestParam String userName, @RequestParam String password)
    {
        return userService.loginService(userName, password);
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    // @Controller
    public String login(Model model, HttpServletRequest request, HttpServletResponse response)
    {

        User user = (User)request.getSession().getAttribute("user_auth");
        if (user == null)
        {
            user = new User();
            user.setUserName("jecosine");
            request.getSession().setAttribute("user_auth", user);
        }
        return "login.html";
    }
}