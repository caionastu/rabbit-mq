package org.springframework.amqp.tutorials.rabbitmqamqptutorials.newStructure;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
@DependsOn("listeners-config")
public class EntityReceiver {

    @RabbitListener(queues = RabbitListenersConfig.QUEUE_NAME)
    public void receive(String message) {
        System.out.println(message);
    }
}
