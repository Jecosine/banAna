/*
 * @Date: 2020-08-31 02:33:25
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-08-31 02:58:40
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
import swu.smxy.banana.service.CategoryService;
import swu.smxy.banana.dao.*;
// import org.springframework.http.codec.json.Jackson2JsonDecoder;
// import swu.smxy.banana.util.DBConnection;

@RestController
@RequestMapping("/cate")
public class CategoryController extends BaseController<CategoryService> {
    @Autowired
    private CategoryService categoryService;
    @RequestMapping("/getCateData")
    public ResponseType<List<Category>> getCateData() {
        return  categoryService.getChildCate("0");
        // return cate;
    }

}