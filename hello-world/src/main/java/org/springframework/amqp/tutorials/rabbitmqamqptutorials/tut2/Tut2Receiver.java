package org.springframework.amqp.tutorials.rabbitmqamqptutorials.tut2;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

@RabbitListener(queues = "hello")
public class Tut2Receiver {

    private final int instance;

    public Tut2Receiver(int instance) {
        this.instance = instance;
    }

    @RabbitHandler
    public void receive(String in) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("instance " + this.instance + " [x] Received '" + in + "'");
        doWork(in);
        stopWatch.stop();
        System.out.println("instance " + this.instance + " [x] Done In '" + stopWatch.getTotalTimeSeconds() + "'");
    }

    private void doWork(String in) throws InterruptedException {
        for (char ch : in.toCharArray()) {
            if (ch == '.') {
                Thread.sleep(1000);
            }
        }
    }
}
