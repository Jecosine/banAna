package swu.smxy.banana.service;

import java.util.List;

import javax.annotation.Resource;
import javax.websocket.Session;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import swu.smxy.banana.dao.OrderMapper;
import swu.smxy.banana.entity.CartItem;
import swu.smxy.banana.entity.Order;
import swu.smxy.banana.entity.ResponseType;

@Service
public class OrderService extends BaseService<Order, OrderMapper> {
  @Resource(name = "sqlSessionFactory")
  private SqlSessionFactory sqlSessionFactory;
  SqlSession session;
  OrderMapper mapper;
  public ResponseType<List<Order>> getByUserId(String userId)
  {
    ResponseType<List<Order>> response = new ResponseType<List<Order>>();
    List<Order> orders = null;
    try {
      orders = sqlSessionFactory.openSession().getMapper(OrderMapper.class).getByUserId(userId);
      
    } catch (Exception e) {
      response.setStatus(-1);
      response.setMessage("Error fetching orders");
    }
    response.setMessage("Successful");
    response.setData(orders);
    return response;
  }
  @Transactional
  public ResponseType<String> newOrder(List<Order> orders)
  {
    ResponseType<String> response = new ResponseType<String>();
    mapper = session.getMapper(OrderMapper.class);
    try {
      for (Order order : orders) {
        mapper.newOrder(order);
      }      
    } 
    catch(Exception e)
    {
      TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
      session.close();
      response.setStatus(-1);
      response.setMessage("Error insertint order");
      response.setData(e.getMessage());
      return response;
    }
    session.commit();
    session.close();
    response.setMessage("Successful");

    return response;
  }

}