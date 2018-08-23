package com.lxh.rabbitmq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class RabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqApplication.class, args);
    }

    final static String queueName = "fanout-queue";
//
//    @Bean
//    Queue queue() {
//        return new Queue(queueName);
//    }
//
//    @Bean
//    Queue queue1() {
//        return new Queue(queueName + 1);
//    }
//
//    @Bean
//    CustomExchange delayedExchange(){
//        Map<String, Object> args = new HashMap<>();
//        args.put("x-delayed-type", "direct");
//        return new CustomExchange("test-delayed-msg", "x-delayed-message", true, false, args);
//    }
//
//    @Bean
//    Queue delayedQueue(){
//        return new Queue("delayed-queue", true);
//    }
//
//    @Bean
//    FanoutExchange exchange() {
//        return new FanoutExchange("fanout-exchange");
//    }
//
//    @Bean
//    Binding binding(Queue queue, FanoutExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange);
//    }
//
//    @Bean
//    Binding binding1(Queue queue1, FanoutExchange exchange) {
//        return BindingBuilder.bind(queue1).to(exchange);
//    }
//
//    @Bean
//    Binding binding2(Queue delayedQueue, CustomExchange delayedExchange){
//       return BindingBuilder.bind(delayedQueue).to(delayedExchange).with("delayed-queue-route").noargs();
//    }
//
//    @Bean
//    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
//                                             MessageListenerAdapter listenerAdapter) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(queueName);
////        container.setMessageListener(listenerAdapter);
//        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        container.setMessageListener(new MessageListenerAdapter() {
//            @Override
//            public void onMessage(Message message, Channel channel) throws Exception{
//                System.out.println("Received <" + new String(message.getBody(), "UTF-8") + ">");
////                Thread.sleep(3000);
//                channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
//            }
//        });
//        return container;
//    }
//
//    @Bean
//    MessageListenerAdapter listenerAdapter(Receiver receiver) {
//        return new MessageListenerAdapter(receiver, "receiveMessage");
//    }
//
//    @Bean
//    SimpleMessageListenerContainer container1(ConnectionFactory connectionFactory,
//                                             MessageListenerAdapter listenerAdapter1) {
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setQueueNames(queueName + 1);
//        container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
//        container.setMessageListener(new MessageListenerAdapter() {
//            @Override
//            public void onMessage(Message message, Channel channel) throws Exception{
//                System.out.println("Received <" + new String(message.getBody(), "UTF-8") + ">");
////                Thread.sleep(3000);
//                channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
//            }
//        });
//        return container;
//    }
//
//    @Bean
//    MessageListenerAdapter listenerAdapter1(Receiver receiver) {
//        return new MessageListenerAdapter(receiver, "receiveMessage");
//    }
}
