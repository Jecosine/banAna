/*
 * @Date: 2020-07-25 13:50:28
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-21 20:56:09
 * @FilePath: \banana\src\main\java\swu\smxy\banana\controller\MainController.java
 */
package swu.smxy.banana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @RestController
@Controller
// @RequestMapping("/eiheihei")
public class MainController
{
    /**
     * @description: test service
     * @param <empty>
     * @return: String
     */
    @RequestMapping("/")
    public String banana(Model model)
    {
        return "test.html";
    }
}