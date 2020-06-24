package com.xue.foundation.proxy;

public class Test {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();

        UserDao proxy = (UserDao) new ProxyClass(userDao).getInstnce();

        proxy.save();
    }
}
