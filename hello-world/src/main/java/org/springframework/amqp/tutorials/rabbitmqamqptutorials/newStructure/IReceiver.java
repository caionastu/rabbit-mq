package org.springframework.amqp.tutorials.rabbitmqamqptutorials.newStructure;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;

public interface IReceiver {

    @RabbitHandler
    void receive(String message);
}
