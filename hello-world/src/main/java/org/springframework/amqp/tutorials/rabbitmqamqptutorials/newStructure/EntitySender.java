package org.springframework.amqp.tutorials.rabbitmqamqptutorials.newStructure;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class EntitySender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private TopicExchange topicExchange;

    @Scheduled(fixedDelay = 100, initialDelay = 500)
    public void send() {
        String message = "Hello World";
        this.rabbitTemplate.convertAndSend(topicExchange.getName(), "test.from.client", message);
    }
}
