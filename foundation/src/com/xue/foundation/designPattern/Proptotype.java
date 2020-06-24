package com.xue.foundation.designPattern;

public class Proptotype implements Cloneable {

    public Proptotype() {
        System.out.println("创建对象");
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
