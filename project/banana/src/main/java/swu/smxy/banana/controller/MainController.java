package swu.smxy.banana.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eiheihei")
public class MainController {
    
  @RequestMapping("/banana")
  public String banana()
  {
    return "banana!!";
  }
}