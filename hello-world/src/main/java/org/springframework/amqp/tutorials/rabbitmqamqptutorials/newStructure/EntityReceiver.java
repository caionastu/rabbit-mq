package org.springframework.amqp.tutorials.rabbitmqamqptutorials.newStructure;

public class EntityReceiver implements IReceiver {
    @Override
    public void receive(String message) {
        System.out.println(message);
    }
}
