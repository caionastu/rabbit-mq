package org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut1;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class Tut1Sender {

    private int count = 0;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 100, initialDelay = 500)
    public void send() {
        count++;
        String message = count + " Hello World";
        this.rabbitTemplate.convertAndSend(queue.getName(), message);
        System.out.println(" [" + count + "] Sent '" + message + "'");
    }
}
