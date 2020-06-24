package com.xue.foundation.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyClass {

    Object obj;

    public ProxyClass(Object obj) {
        this.obj = obj;
    }

    public Object getInstnce() {
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("pre");
                method.invoke(obj, args);
                System.out.println("next");
                return null;
            }
        });
    }

}
