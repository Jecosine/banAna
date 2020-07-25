/*
 * @Date: 2020-07-25 16:15:10
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-07-25 16:59:30
 * @FilePath: \banana\src\main\java\swu\smxy\banana\controller\BusinessController.java
 */ 
package swu.smxy.banana.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import swu.smxy.banana.entity.*;
// import 
@RestController
public class BusinessController {
  @RequestMapping(value="/getById", method=RequestMethod.GET)
  public String getById(@RequestParam String businessId) {
    return new String();
  }
  
}