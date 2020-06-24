package com.cloud.demo.controller;

import com.cloud.demo.entity.User;
import com.cloud.demo.service.ConsumerService;
import com.cloud.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ComsumerController {

    @Autowired
    private ConsumerService consumerService;

    @Autowired
    private HelloService helloService;

    @RequestMapping("consumer")
    public String consumer() {
        String res = consumerService.consumer();
        String res1 = consumerService.consumer();
        System.out.println(res + res1);
        return res;
    }

    @RequestMapping("consumer1")
    public String consumer1() {
        String res = helloService.hello("xue");
        System.out.println(res);
        res = helloService.hello(1, "xue");
        System.out.println(res);
        res = helloService.hello(new User(2, "xue"));
        System.out.println(res);
        return helloService.index();
    }
}
