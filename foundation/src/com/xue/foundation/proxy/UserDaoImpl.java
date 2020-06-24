package com.xue.foundation.proxy;

public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("save");
    }
}
