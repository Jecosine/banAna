/*
 * @Date: 2020-09-02 23:05:39
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-03 23:32:23
 */
package swu.smxy.banana.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import swu.smxy.banana.service.BaseService;
import swu.smxy.banana.service.ItemService;
import swu.smxy.banana.entity.Item;
import swu.smxy.banana.entity.ResponseType;

@RestController
@RequestMapping("/item")
public class ItemController extends BaseController<ItemService>
{
    @Autowired
    private ItemService itemService;
    @ResponseBody
    @RequestMapping(value="/{itemId}", method = RequestMethod.GET)
    public ResponseType<Item> getItem(@PathVariable("itemId") String itemId, @RequestParam(name="typeCode", required=false) String typeCode)
    {
        return itemService.getByIdAndType(itemId, typeCode);
    }
}