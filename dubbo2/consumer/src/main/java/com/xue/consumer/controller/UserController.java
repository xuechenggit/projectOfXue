package com.xue.consumer.controller;

import entity.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.UserService;

import java.util.List;

@RestController
public class UserController {

    @Reference(url = "dubbo://localhost:20880")
    UserService userService;

    @RequestMapping("getAllUser")
    public void getAllUser() {
        List<User> users = userService.getAllUser();
        System.out.println(users.size());
    }
}
