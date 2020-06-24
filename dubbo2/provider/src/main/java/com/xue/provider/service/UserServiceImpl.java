package com.xue.provider.service;

import entity.User;
import org.apache.dubbo.config.annotation.Service;
import service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setName("ddd");
        users.add(user);
        return users;
    }
}
