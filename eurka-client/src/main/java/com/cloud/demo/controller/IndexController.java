package com.cloud.demo.controller;

import com.cloud.demo.entity.User;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class IndexController {

    /*@Resource
    private EurekaDiscoveryClient client;*/

    @RequestMapping("index")
    public String index() throws InterruptedException {
        System.out.println("hello + 2223");
        return "hello";
    }

    @RequestMapping("hello1")
    public String hello(@RequestParam String name) throws InterruptedException {
        return "hello" + name;
    }

    @RequestMapping("hello2")
    public String hello(@RequestHeader Integer id, @RequestHeader String name) {
        return new User(id, name).toString();
    }

    @RequestMapping(value = "hello3", method = RequestMethod.POST)
    public String hello(@RequestBody User user) {
        return "hello" + user.getId() +"  " + user.getName();
    }


}