/*
 * @Date: 2020-09-02 23:05:39
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-02 23:11:52
 */
package swu.smxy.banana.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import swu.smxy.banana.service.BaseService;
import swu.smxy.banana.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController extends BaseController<ItemService>
{
    
}