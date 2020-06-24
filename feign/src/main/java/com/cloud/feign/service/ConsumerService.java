package com.cloud.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("hello-first")
public interface ConsumerService {

    @RequestMapping("index")
    public String index();

    @RequestMapping("hello2")
    public String hello1(@RequestHeader("id") Integer id, @RequestHeader("name") String name);

}
