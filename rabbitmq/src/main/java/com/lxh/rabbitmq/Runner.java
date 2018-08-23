package com.lxh.rabbitmq;

/**
 * User: LinXiaoHui
 * Date: 2018/5/31
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
@Component
public class Runner implements CommandLineRunner, RabbitTemplate.ConfirmCallback {
    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;
    private final ConfigurableApplicationContext context;
    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate,
                  ConfigurableApplicationContext context) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
        this.context = context;
    }
    @Override
    public void run(String... args) throws Exception {
//        System.out.println("Sending message...");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println("消息发送时间:"+sdf.format(new Date()));
//        rabbitTemplate.setConfirmCallback(this);
//        CorrelationData data = new CorrelationData("123");
//        rabbitTemplate.convertAndSend("fanout-exchange", "", "Hello from RabbitMQ!", data);
//        rabbitTemplate.convertAndSend("test-delayed-msg", "delayed-queue-route", "haha", new MessagePostProcessor() {
//            @Override
//            public Message postProcessMessage(Message message) throws AmqpException {
//                message.getMessageProperties().setHeader("x-delay", 5000);
//                return message;
//            }
//        });
//        context.close();
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        System.out.println("ack="+ ack);
    }
}
