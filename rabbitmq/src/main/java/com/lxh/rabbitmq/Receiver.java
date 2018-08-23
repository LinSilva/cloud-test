package com.lxh.rabbitmq;

/**
 * User: LinXiaoHui
 * Date: 2018/5/31
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
@Component
public class Receiver {
    public void receiveMessage(Message message, Channel channel) throws Exception {
        Thread.sleep(3000);
        System.out.println("Received <" + new String(message.getBody(), "UTF-8") + ">");
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
    }

    @RabbitListener(queues = "delayed-queue")
    public void receive(String msg){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("消息接收时间:"+sdf.format(new Date()));
        System.out.println("接收到的消息:"+msg);
    }
}
