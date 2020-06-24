package com.xue.foundation.designPattern;

public abstract class PizzaAbstract {

    protected String name;

    public abstract void make();

    public void box(){
        System.out.println("披萨正在打包中...");
    }

}
