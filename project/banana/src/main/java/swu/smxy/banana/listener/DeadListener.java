package swu.smxy.banana.listener;

import java.util.List;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import swu.smxy.banana.entity.Order;
import swu.smxy.banana.entity.ResponseType;
import swu.smxy.banana.service.OrderService;

@Component
public class DeadListener {
    @Autowired
    OrderService orderService;
    @RabbitListener(queues = "order.dead.queue")
    public void orderConsumer(String orderId) {
      System.out.println("Get Message:" + orderId);
      if (StringUtils.isEmpty(orderId)) {
          return;
      }

      ResponseType<List<Order>> resp = orderService.getByParentId(orderId);
      if (resp.getData() == null) {
          return;
      }
      List<Order> orders = resp.getData();
      for (Order order : orders) {
        String orderStatus=order.getOrderStatus();
        if (orderStatus.equals("Unpaid"))
        {
          System.out.println("asdsadsa!!!!");
          orderService.cancelOrder(order);
        }
      }
  }
}