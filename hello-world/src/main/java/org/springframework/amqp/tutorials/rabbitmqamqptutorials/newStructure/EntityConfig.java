package org.springframework.amqp.tutorials.rabbitmqamqptutorials.newStructure;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"newStructure", "test-rabbit"})
@Configuration
public class EntityConfig {

    private static final String QUEUE_NAME = "entity-queue";
    private static final String EXCHANGE_NAME = "entity-exchange";

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue queue(){
        return new AnonymousQueue();
    }

    @Bean
    public Binding binding(TopicExchange topicExchange, Queue queue){
        return BindingBuilder.bind(queue).to(topicExchange).with("#.from.client");
    }

    @Profile("receiver")
    @RabbitListener(queues = QUEUE_NAME)
    public IReceiver receiver() {
        return new EntityReceiver();
    }

    @Profile("sender")
    @Bean
    public EntitySender sender() {
        return new EntitySender();
    }


}
