package com.cloud.demo.service;

import com.cloud.demo.entity.User;
import com.cloud.demo.service.impl.FallbackHelloService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "HELLO-FIRST", fallback = FallbackHelloService.class)
public interface HelloService {

    @RequestMapping("index")
    String index();

    @RequestMapping("hello1")
    public String hello(@RequestParam("name") String name);

    @RequestMapping("hello2")
    String hello(@RequestHeader("id") Integer id, @RequestHeader("name") String name);

    @RequestMapping(value = "hello3", method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
