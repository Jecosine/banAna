package swu.smxy.banana.listener;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class TestListener {
  private static final Logger log= LoggerFactory.getLogger(TestListener.class);
 
  @Autowired
  private ObjectMapper objectMapper;

  /**
   * 监听消费消息
   * @param message
   */
  @RabbitListener(queues = "myQueue")
  public void consumeMessage(@Payload byte[] message){
      try {
          //TODO：接收String
          String result=new String(message,"UTF-8");
          log.info("接收String消息： {} ",result);
      }catch (Exception e){
          log.error("监听消费消息 发生异常： ",e.fillInStackTrace());
      }
  }
}