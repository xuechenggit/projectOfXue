package com.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;

public class ConsumerController {

    @Reference(version = "1.0.0", timeout = 3000)
    private UserService userService;

}
