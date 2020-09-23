/*
 * @Date: 2020-09-23 14:44:35
 * @LastEditors: Jecosine
 * @LastEditTime: 2020-09-23 15:27:24
 */
package swu.smxy.banana.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeadLetterConfiguration
{
    @Value("${banana.order.exchange}")
    private String exchangeName;
    @Value("${banana.order.queue}")
    private String queueName;
    @Value("${banana.order.routekey}")
    private String directKey;
    @Value("${banana.dead.exchange}")
    private String deadExchangeName;
    @Value("${banana.dead.queue}")
    private String deadQueueName;
    @Value("${banana.dead.routekey}")
    private String deadkey;

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory)
    {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        return rabbitTemplate;
    }

    @Bean
    public DirectExchange directExchange()
    {
        return new DirectExchange(deadExchangeName);
    }

    @Bean
    public DirectExchange orderExchange()
    {
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Queue deadQueue()
    {
        return new Queue(deadQueueName);
    }

    @Bean
    public Queue orderQueue()
    {
        Map<String, Object> arguments = new HashMap<String, Object>(2);
        // 绑定我们的死信交换机
        arguments.put("x-dead-letter-exchange", deadExchangeName);
        // 绑定我们的路由key
        arguments.put("x-dead-letter-routing-key", deadkey);
        return new Queue(exchangeName, true, false, false, arguments);
    }

    @Bean
    public Binding orderBinding()
    {
        return BindingBuilder.bind(orderQueue()).to(orderExchange()).with(directKey);
    }

    @Bean
    public Binding binding()
    {
        return BindingBuilder.bind(deadQueue()).to(directExchange()).with(directKey);
    }

}