/*
 * @Date: 2020-09-02 23:07:34
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-03 23:31:20
 */
package swu.smxy.banana.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import swu.smxy.banana.dao.ItemMapper;
import swu.smxy.banana.entity.CartItem;
import swu.smxy.banana.entity.Item;
import swu.smxy.banana.entity.Order;
import swu.smxy.banana.entity.ResponseType;

@Service
public class ItemService extends BaseService<Item, ItemMapper> {
    private ItemMapper mapper;
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;
    public ResponseType<List<Order>> generateOrder(@RequestBody List<CartItem> items)
    {
        ResponseType<List<Order>> response = new ResponseType<List<Order>>();
        Map<String, Order> mp = new HashMap();

        Order temp = null;
        for (CartItem item : items) {
            temp = mp.get(item.getBusinessId());
            if (temp!=null)
            {
                temp.getOrderItemList().add(item);
            }
            else
            {
                temp = new Order();
                temp.setBusinessId(item.getBusinessId());
                temp.setBusinessName(item.getBusinessName());
                temp.setOrderItemList(new ArrayList<CartItem>());
                temp.getOrderItemList().add(item);
                mp.put(item.getBusinessId(), temp);
            }
        }
        List<Order> orders = new ArrayList<Order>(mp.values());
        response.setData(orders);
        return response;
    }
    public ResponseType<Item> getByIdAndType(String itemId, String typeCode)
    {
        ResponseType<Item> response = new ResponseType<Item>();
        SqlSession session = sqlSessionFactory.openSession();
        mapper = session.getMapper(ItemMapper.class);
        response.setStatus(0);
        Item item;
        if (typeCode == null)
        {
            response.setMessage("Get Main Item Successfully");
            item = mapper.getById(itemId);
        }
        else 
        {
            response.setMessage("Get Sub Item Successfully");
            item = mapper.getByIdAndType(itemId, typeCode);
        }
        if (item == null)
        {
            response.setMessage("No such item");
            response.setStatus(-1);
        }
        session.close();
        return response;
    }
    public ResponseType<List<Item>> blurSearchItem(String s)
    {
        ResponseType<List<Item>> response = new ResponseType<List<Item>>();
        SqlSession session = sqlSessionFactory.openSession();
        mapper = session.getMapper(ItemMapper.class);
        List<Item> data = mapper.blurSearchItem(s);
        response.setStatus(0);
        response.setData(data);
        response.setMessage("Get Items Successfully");
        session.close();
        return response;
    }
    public ResponseType<List<Item>> recoms()
    {
        ResponseType<List<Item>> response = new ResponseType<List<Item>>();
        SqlSession session = sqlSessionFactory.openSession();
        mapper = session.getMapper(ItemMapper.class);
        List<Item> data = mapper.recomList();
        response.setStatus(0);
        response.setData(data);
        response.setMessage("Get Items Successfully");
        session.close();
        return response;
    }
    public ResponseType<List<Item>> getByCate(String cateId)
    {
        ResponseType<List<Item>> response = new ResponseType<List<Item>>();
        SqlSession session = sqlSessionFactory.openSession();
        mapper = session.getMapper(ItemMapper.class);
        List<Item> data = mapper.getByCate(cateId);
        response.setStatus(0);
        response.setData(data);
        response.setMessage("Get Items Successfully");
        session.close();
        return response;
    }

}