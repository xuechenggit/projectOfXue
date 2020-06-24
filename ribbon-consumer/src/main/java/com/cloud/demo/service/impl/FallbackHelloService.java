package com.cloud.demo.service.impl;

import com.cloud.demo.entity.User;
import com.cloud.demo.service.ConsumerService;
import com.cloud.demo.service.HelloService;
import org.springframework.stereotype.Component;

@Component
public class FallbackHelloService implements HelloService {
    @Override
    public String index() {
        return "error";
    }

    @Override
    public String hello(String name) {
        return "error";
    }

    @Override
    public String hello(Integer id, String name) {
        return "error";
    }

    @Override
    public String hello(User user) {
        return "error";
    }
}
