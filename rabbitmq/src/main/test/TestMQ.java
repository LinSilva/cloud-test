import com.lxh.rabbitmq.RabbitmqApplication;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * User: LinXiaoHui
 * Date: 2018/6/8
 */
@SpringBootTest(classes = RabbitmqApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMQ {

    @Autowired
    private ConnectionFactory connectionFactory;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void send(){
        rabbitTemplate.convertAndSend("fanout-exchange", "", "hello from rabbit");
    }

   @Test
    public void receive() throws Exception {
     Channel channel = connectionFactory.createConnection().createChannel(false);
     channel.basicConsume("fanout-queue1", false, new DefaultConsumer(channel){

         @Override
         public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
             System.out.println(new String(body));
//             channel.basicAck(envelope.getDeliveryTag(), false);
         }
     });
       try {
           Thread.sleep(1000000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
//     channel.close();
   }

}
