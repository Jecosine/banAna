/*
 * @Date: 2020-07-25 13:50:28
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-23 15:20:59
 * @FilePath: \banana\src\main\java\swu\smxy\banana\controller\MainController.java
 */
package swu.smxy.banana.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.apache.commons.logging.Log;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;
import swu.smxy.banana.entity.CartItem;
import swu.smxy.banana.entity.Item;
import swu.smxy.banana.entity.Order;
import swu.smxy.banana.entity.ResponseType;
import swu.smxy.banana.entity.User;
import swu.smxy.banana.service.FileService;
import swu.smxy.banana.service.ItemService;
import swu.smxy.banana.service.OrderService;
import swu.smxy.banana.service.UserService;

// @RestController
@Log4j2
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
    @Autowired
    private FileService fileService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("${banana.order.exchange}")
    private String exchangeName;
    @Value("${banana.order.queue}")
    private String queueName;
    @Value("${banana.order.routekey}")
    private String directKey;

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
    
    @RequestMapping("/register")
    public String register(Model model)
    {
        return "register.html";
    }
    @RequestMapping("/becomeSaler")
    public String becomeSaler(HttpServletRequest request)
    {
        User user = (User)request.getSession().getAttribute("user_auth");
        if (user != null)
        {
            if(user.getUserId() != null)
            {
                userService.setSaler(user);
                return "redirect:/console";

            }
        }
        return "redirect:/login";        
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
        User user = (User)request.getSession().getAttribute("user_auth");
        if (user != null)
        {
            if(user.getUserId() != null)
                response.sendRedirect("/");
        }
        return "login.html";
    }
    @ResponseBody
    @RequestMapping(value = "/newOrder", method = RequestMethod.POST)
    public ResponseType<String> newOrder(@RequestBody List<CartItem> items, HttpServletRequest request)
    {
        User user = (User)request.getSession().getAttribute("user_auth");
        ResponseType<String> result = itemService.generateOrder(items, user);
        rabbitTemplate.convertAndSend(exchangeName,directKey, result.getData(), messagePostProcessor());
        return result;
    }

    private MessagePostProcessor messagePostProcessor(){
        return  new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //message.getMessageProperties().setExpiration("1800000");
                message.getMessageProperties().setExpiration("10000");
                return message;
            }
        };
    }

    @ResponseBody
    @RequestMapping("/order/getById")
    public ResponseType<List<Order>> getOrderByParentId(@RequestParam String id)
    {
        return orderService.getByParentId(id);
    }
    @ResponseBody
    @RequestMapping(value="/order/update", method=RequestMethod.POST)
    public ResponseType<String> updateOrder(@RequestBody List<Order> orders)
    {
        return orderService.updateOrder(orders);

    }
    @ResponseBody
    @RequestMapping("/order/getByUserId")
    public ResponseType<List<Order>> getOrderByUserId(HttpServletRequest request, HttpServletResponse response)
            throws IOException
    {
        User user = (User)request.getSession().getAttribute("user_auth");
        if (user == null || user.getUserId()==null)
        {
            ResponseType<List<Order>> resp = new ResponseType<List<Order>>();
            resp.setStatus(-1);
            return resp;
        }

        return orderService.getByUserId(user.getUserId());
    }

    @RequestMapping("/order/{orderId}")
    public String getOrder(HttpServletRequest request, @PathVariable String orderId)
    {
        System.out.println(orderId);
        ResponseType<List<Order>> resp = orderService.getByParentId(orderId);
        if(resp.getData() == null)
            return "redirect:/404";
        User user = (User)request.getSession().getAttribute("user_auth");
        if (user == null)
        {
            return "/login";
        }
        return "order.html";
    }
    @RequestMapping("/manage")
    public String manage()
    {
        return "manage.html";
    }
    @ResponseBody
    @RequestMapping(value="/upload", method=RequestMethod.POST)
    public ResponseType<String> uploadSingleFile(@RequestParam("file") MultipartFile file)
    {
        return fileService.uploadFile(file);
    }
}