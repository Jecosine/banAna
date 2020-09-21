/*
 * @Date: 2020-09-02 23:05:39
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-04 17:34:29
 */
package swu.smxy.banana.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import swu.smxy.banana.service.BaseService;
import swu.smxy.banana.service.ItemService;
import swu.smxy.banana.entity.Item;
import swu.smxy.banana.entity.ResponseType;

@Controller
@RequestMapping("/item")
public class ItemController extends BaseController<ItemService>
{
    @Autowired
    private ItemService itemService;
    
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String getItem()
    {
        return "item.html";
    }
    @ResponseBody
    @RequestMapping(value="/{itemId}", method = RequestMethod.GET)
    public ResponseType<Item> getItem(@PathVariable("itemId") String itemId, @RequestParam(name="typeCode", required=false) String typeCode)
    {
        return itemService.getByIdAndType(itemId, typeCode);
    }
    @ResponseBody
    @RequestMapping(value="/info", method = RequestMethod.GET)
    public ResponseType<Item> getItemById(@RequestParam("itemId") String itemId)
    {
        ResponseType<Item> resp = new ResponseType<Item>();
        resp.setStatus(0);
        resp.setMessage("Update successfully");
        resp.setData(itemService.getById(itemId));
        return resp;
    }
    @ResponseBody
    @RequestMapping(value="/getByCate", method = RequestMethod.GET)
    public ResponseType<List<Item>> getItemByCate(@RequestParam("id") String cateId)
    {
        return itemService.getByCate(cateId);
    }
    // TODO update item data
    @ResponseBody
    @RequestMapping(value="/update", method = RequestMethod.POST)
    public ResponseType<String> updateItem(@RequestBody Item item, HttpServletRequest request, HttpServletResponse response)
    {
        ResponseType<String> resp = new ResponseType<String>();
        resp.setStatus(0);
        resp.setMessage("Update successfully");
        return resp; 
    }
    @ResponseBody
    @RequestMapping(value="/delete", method = RequestMethod.GET)
    public ResponseType<String> deleteByItem(@RequestBody Item item)
    {
        ResponseType<String> response = new ResponseType<String>();
        // response = itemService.deleteByItem(item);
        return response;
    }
    @ResponseBody
    @RequestMapping(value="/recommend", method = RequestMethod.GET)
    public ResponseType<List<Item>> recoms()
    {
        return itemService.recoms();
    }
}