package org.springframework.amqp.tutorials.rabbitmqamqptutorials.newStructure;

import com.sun.org.apache.xpath.internal.operations.VariableSafeAbsRef;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;

public abstract class AbstractEntityConfig {

    protected String bindingKey;

    public abstract String getQueueName();
    public abstract String getExchangeName();
    public abstract IReceiver receiver();

    public AbstractEntityConfig(){
        this.bindingKey = "#.from.client";
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(getExchangeName());
    }

    @Bean
    public Queue queue(){
        return new Queue(getQueueName());
    }

    @Bean
    public Binding binding(TopicExchange topicExchange, Queue queue){
        return BindingBuilder.bind(queue).to(topicExchange).with(bindingKey);
    }

}
