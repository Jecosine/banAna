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
    // Business business = 
    return new String();
  }
  
}