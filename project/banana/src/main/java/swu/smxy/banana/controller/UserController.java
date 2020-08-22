/*
 * @Date: 2020-08-22 01:37:06
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-22 12:12:42
 */
package swu.smxy.banana.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseType<User> login(@RequestParam String userName, @RequestParam String password)
    {
        return userService.loginService(userName, password);
    }
}