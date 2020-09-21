/*
 * @Date: 2020-07-25 13:50:28
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-31 02:33:40
 * @FilePath: \banana\src\main\java\swu\smxy\banana\controller\MainController.java
 */
package swu.smxy.banana.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import swu.smxy.banana.entity.CartItem;
import swu.smxy.banana.entity.Item;
import swu.smxy.banana.entity.Order;
import swu.smxy.banana.entity.ResponseType;
import swu.smxy.banana.entity.User;
import swu.smxy.banana.service.ItemService;

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
    @Autowired
    private ItemService itemService;
    
    @RequestMapping("/")
    public String index(Model model)
    {
        return "index.html";
    }
    @RequestMapping("/personal")
    public String personal(Model model)
    {
        return "personal.html";
    }
    @ResponseBody
    @RequestMapping("/searchresult")
    public ResponseType<List<Item>> searchResult(@RequestParam String s)
    {
        return itemService.blurSearchItem(s);
    }
    @RequestMapping("/search")
    public String search()
    {
        return "search.html";
    }
    @RequestMapping("/404")
    public String errorPage404()
    {
        return "404.html";
    }
    @RequestMapping("/my500")
    public String errorPage500()
    {
        return "500";
    }
    @RequestMapping("/cate")
    public String cate()
    {
        return "cate.html";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    // @Controller
    public String login(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        if (request.getSession().getAttribute("user_auth") != null)
        {
            response.sendRedirect("/");
        }
        return "login.html";
    }
    @ResponseBody
    @RequestMapping(value = "/orderinfo", method = RequestMethod.POST)
    public ResponseType<List<Order>> getOrderInfo(@RequestBody List<CartItem> items, HttpServletRequest request)
    {
        User user = (User)request.getSession().getAttribute("user_auth");
        return itemService.generateOrder(items, user);
    }
    @RequestMapping("/order")
    public String getOrder(HttpServletRequest request)
    {
        User user = (User)request.getSession().getAttribute("user_auth");
        if (user == null)
        {
            return "login.html";
        }
        return "order.html";
    }
}