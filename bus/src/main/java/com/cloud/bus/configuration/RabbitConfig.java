package com.cloud.bus.configuration;


import com.rabbitmq.client.impl.AMQImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public AMQImpl.Queue getQueue() {
        return new AMQImpl.Queue();
    }

}
