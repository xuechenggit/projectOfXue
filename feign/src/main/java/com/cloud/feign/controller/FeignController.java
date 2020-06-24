package com.cloud.feign.controller;

import com.cloud.feign.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("feign")
public class FeignController {

    @Resource
    private ConsumerService consumerService;


    @RequestMapping("index")
    public String feignComsumer() {
        System.out.println(consumerService.hello1(1, "zu"));
        return consumerService.index();
    }

}
