package demo.spring.boot;

import demo.spring.boot.controller.UserController;
import demo.spring.boot.mapper.UserMapper;
import demo.spring.boot.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import javax.annotation.security.RunAs;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestClass {

    @Autowired
    private UserController userController;

    @Resource
    private UserMapper userMapper;

    @Test
    public void test01() {
        userController.setUser();
    }

    @Test
    public void test02() {
        userController.getUser();
    }

    @Test
    public void test03() {
        List<User> res = userMapper.getAllUsers();
        System.out.println(res);
    }
}
