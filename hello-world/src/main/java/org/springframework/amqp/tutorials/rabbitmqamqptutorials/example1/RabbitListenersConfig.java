package org.springframework.amqp.tutorials.rabbitmqamqptutorials.example1;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("listeners-config")
public class RabbitListenersConfig {

    public static final String QUEUE_NAME = "entity-queue";
    public static final String EXCHANGE_NAME = "entity-exchange";
    private static final String BINDING_KEY = "consumer";

    @Autowired
    private AmqpAdmin amqpAdmin;

    @PostConstruct
    private void listeners() {
        Queue queue = new Queue(QUEUE_NAME);
        amqpAdmin.declareQueue(queue);
        TopicExchange exchange = new TopicExchange(EXCHANGE_NAME);
        amqpAdmin.declareExchange(exchange);
        amqpAdmin.declareBinding(BindingBuilder.bind(queue).to(exchange).with(BINDING_KEY));
    }

}
