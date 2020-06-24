package com.xue.foundation.designPattern.domain;

import com.xue.foundation.designPattern.PizzaAbstract;

public class ShangHaiPizza2 extends PizzaAbstract {
    @Override
    public void make() {
        System.out.println("正在制作上海pizza2");
    }
}
