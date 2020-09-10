package swu.smxy.banana.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfiguration {
    //TODO：基本消息模型构建
    @Bean
    public DirectExchange basicExchange(){
        return new DirectExchange("directExchange", true,false);
    }
 
    @Bean(name = "basicQueue")
    public Queue basicQueue(){
        return new Queue("myQueue", true);
    }
 
    @Bean
    public Binding basicBinding(){
        return BindingBuilder.bind(basicQueue()).to(basicExchange()).with("myKey");
    }
    
    // @Bean
    // MessageListenerAdapter listenerAdapter(Receiver receiver) {
    //   return new MessageListenerAdapter(receiver, "receiveMessage");
    // }
    // @Bean
    // SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
    //     MessageListenerAdapter listenerAdapter) {
    //   SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
    //   container.setConnectionFactory(connectionFactory);
    //   container.setQueueNames("myQueue");
    //   // container.setMessageListener(listenerAdapter);
    //   return container;
    // }
}