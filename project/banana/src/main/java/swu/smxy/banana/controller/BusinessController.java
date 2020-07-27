/*
 * @Date: 2020-07-25 16:15:10
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-07-25 19:32:00
 * @FilePath: \banana\src\main\java\swu\smxy\banana\controller\BusinessController.java
 */
package swu.smxy.banana.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import swu.smxy.banana.entity.*;
import swu.smxy.banana.dao.*;
// import 
import swu.smxy.banana.util.DBConnection;


@RestController
@RequestMapping("/business")
public class BusinessController {
  @ResponseBody
  @RequestMapping(value="/getAll", method=RequestMethod.GET)
  public List<Business> getAll() {
    SqlSession sqlSession = DBConnection.getFactory().openSession();
    BusinessMapper businessMapper = sqlSession.getMapper(BusinessMapper.class);
    return businessMapper.getAllBusiness();
  }
  
}