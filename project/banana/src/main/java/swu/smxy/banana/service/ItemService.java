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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.bind.annotation.RequestBody;

import swu.smxy.banana.dao.CartMapper;
import swu.smxy.banana.dao.ItemMapper;
import swu.smxy.banana.entity.CartItem;
import swu.smxy.banana.entity.Item;
import swu.smxy.banana.entity.Order;
import swu.smxy.banana.entity.ResponseType;
import swu.smxy.banana.entity.User;
import swu.smxy.banana.util.UuidGenerator;

@Service
public class ItemService extends BaseService<Item, ItemMapper> {
    private ItemMapper mapper;
    @Autowired
    private BusinessService businessService;
    @Autowired
    private OrderService orderService;
    @Resource(name = "sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;

    public ResponseType<String> submitOrder() {
        ResponseType<String> response = new ResponseType<String>();

        return response;
    }

    @Transactional
    public ResponseType<String> generateOrder(List<CartItem> items, User user) {
        ResponseType<String> response = new ResponseType<String>();
        String parentId = UuidGenerator.getUuid(20);
        CartMapper cartMapper;
        Map<String, Order> mp = new HashMap();
        if (user == null)
        {
            response.setStatus(-2);
            response.setMessage("Not login");
            return response;
        }
        Order temp = null;
        Item tempItem = null;
        SqlSession session = sqlSessionFactory.openSession();
        for (CartItem item : items) {
            temp = mp.get(item.getBusinessId());
            mapper = session.getMapper(ItemMapper.class);
            cartMapper = session.getMapper(CartMapper.class);
            tempItem = mapper.getById(item.getItemId());
            // update stock
            if (tempItem.getRemain() < item.getItemCount()) {
                response.setStatus(-1);
                try {
                    response.setMessage("Not enough stock: " + new ObjectMapper().writeValueAsString(tempItem));
                } catch (JsonProcessingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                session.commit();
                session.close();
                return response;
            }
            else
            {
                tempItem.setRemain(tempItem.getRemain() - item.getItemCount());
                if(tempItem.getRemain() == 0)
                {
                    tempItem.setItemStatus("Undercarriaged");
                }
                mapper.updateStock(tempItem);
                item.setItemStatus("inactive");
                cartMapper.update(item);
            }
            if (temp!=null)
            {
                temp.getOrderItemList().add(item);
                temp.setOrderPrice(temp.getOrderPrice() + item.getPrice() * ((item.getItemCount()!=null)?item.getItemCount():0));
            }
            else
            {
                // set order data
                temp = new Order();
                temp.setParentId(parentId);
                temp.setOrderId(UuidGenerator.getUuid(20));
                temp.setBusinessId(item.getBusinessId());
                temp.setBusinessName(businessService.getNameById(item.getBusinessId()));
                temp.setOrderItemList(new ArrayList<CartItem>());
                temp.getOrderItemList().add(item);
                temp.setOrderStatus("Pre");
                temp.setUserId(user.getUserId());
                // calc total
                temp.setOrderPrice(item.getPrice() * ((item.getItemCount()!=null)?item.getItemCount():0));
                mp.put(item.getBusinessId(), temp);
            }
        }
        List<Order> orders = new ArrayList<Order>(mp.values());
        orderService.newOrder(orders);
        response.setData(parentId);
        session.commit();
        session.close();
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
    public ResponseType<List<Item>> getByBusinessId(User user)
    {
        String userId = user.getUserId();
        ResponseType<List<Item>> response = new ResponseType<List<Item>>();
        SqlSession session = sqlSessionFactory.openSession();
        mapper = session.getMapper(ItemMapper.class);
        List<Item> items = mapper.getByBusinessId(userId);
        response.setData(items);
        return response;
    }
}