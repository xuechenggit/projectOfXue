package com.cloud.bus.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Sender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        String date = new Date().toString();
        amqpTemplate.convertAndSend("hello", date);
    }

}
