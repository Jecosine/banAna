/*
 * @Date: 2020-09-09 08:43:44
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-09 09:49:42
 */
package swu.smxy.banana.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import swu.smxy.banana.entity.ResponseType;

@RestController
public class NotificationController {
    public static final Map<String, SseEmitter> SSE_HOLDER = new ConcurrentHashMap<>();
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    @RequestMapping("/sse/test")
    public SseEmitter testEmitter()
    {
        return new SseEmitter();
    }
    @RequestMapping(value = "/message/send",method = RequestMethod.GET)
    public ResponseType<String> sendSimpleMessage(@RequestParam String message){
        ResponseType<String> response=new ResponseType<String>();
        try {
            System.out.println("待发送的消息： {} " + message);
 
            rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
            rabbitTemplate.setExchange("directExchange");
            rabbitTemplate.setRoutingKey("myKey");
            
            Message msg=MessageBuilder.withBody(objectMapper.writeValueAsBytes(message)).build();
            rabbitTemplate.convertAndSend(msg);
        }catch (Exception e){
            System.out.println("发送简单消息发生异常： " + e.fillInStackTrace());
        }
        return response;
    }

}