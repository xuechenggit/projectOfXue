package demo.spring.boot.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private RedisTemplate redisTemplate;

    @RequestMapping("getUser")
    public String getUser() {
        Object object = redisTemplate.opsForValue().get("userOne");
        return object.toString();
    }

    @RequestMapping("setUser")
    public void setUser() {
        redisTemplate.opsForValue().set("userOne", "xue");
    }



}
