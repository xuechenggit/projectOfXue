package com.example.es.controller;

import com.example.es.dao.UserRepository;
import com.example.es.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("getUser")
    public void getUSer() {
        Iterable<User> users = userRepository.findAll();
        users.forEach(user -> {
            System.out.println(user.toString());
        });
    }

}
