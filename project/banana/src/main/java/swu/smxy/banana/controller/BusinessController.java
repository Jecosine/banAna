/*
 * @Date: 2020-07-25 16:15:10
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-21 22:59:38
 * @FilePath: \banana\src\main\java\swu\smxy\banana\controller\BusinessController.java
 */
package swu.smxy.banana.controller;

import java.util.List;
import javax.annotation.Resource;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import swu.smxy.banana.entity.*;
import swu.smxy.banana.service.BusinessService;
import swu.smxy.banana.dao.*;
// import org.springframework.http.codec.json.Jackson2JsonDecoder;
// import swu.smxy.banana.util.DBConnection;

@RestController
@RequestMapping("/business")
public class BusinessController extends BaseController<BusinessService>
{

    // @Resource
    // @Autowired
    // private BusinessService businessService;
    // @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    // @ResponseBody
    // public List<Business> getAll()
    // {
    //     return businessService.getAll();
    // }

    // @RequestMapping(value="/getByName", method=RequestMethod.GET)
    // public Business getByName(@RequestParam String name) {
    //     return businessService.getByName(name);
    // }
}