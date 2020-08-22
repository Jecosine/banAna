/*
 * @Date: 2020-07-25 16:15:10
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-21 23:04:51
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
import swu.smxy.banana.service.BaseService;
import swu.smxy.banana.service.BusinessService;
import swu.smxy.banana.dao.*;
// import org.springframework.http.codec.json.Jackson2JsonDecoder;
// import swu.smxy.banana.util.DBConnection;

// @RestController
// @RequestMapping("/business")
@SuppressWarnings("unchecked")
public class BaseController<T extends BaseService>
{
    @Autowired
    private T baseService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public <U extends Object> List<U> getAll()
    {
        return baseService.getAll();
    }

    @RequestMapping(value="/getByName", method=RequestMethod.GET)
    public <U extends Object> U getByName(@RequestParam String name) {
        return (U)baseService.getByName(name);
    }

    @RequestMapping(value="/getById", method=RequestMethod.GET)
    public <U extends Object> U getById(@RequestParam String id) {
        return (U)baseService.getById(id);
    }

}