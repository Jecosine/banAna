/*
 * @Date: 2020-09-09 08:43:44
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-09 09:49:42
 */
package swu.smxy.banana.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
public class NotificationController {
    public static final Map<String, SseEmitter> SSE_HOLDER = new ConcurrentHashMap<>();
    @RequestMapping("/sse/test")
    public SseEmitter testEmitter()
    {
        return new SseEmitter();
    }
}